package com.ascentcomtec.smarthouse.ui.components;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
import com.ascentcomtec.smarthouse.ui.components.layout.JRelativeLayout;
import com.ascentcomtec.smarthouse.ui.plaf.Style;
import com.ascentcomtec.smarthouse.utils.Utils;
/**
 * Top level component that serves as the root for the UI, this
 * {@link Container} handles the menus and title while placing content between
 * them. By default a forms central content (the content pane) is scrollable.
 * 
 * Form contains Title bar, MenuBar and a ContentPane. Calling to addComponent
 * on the Form is delegated to the contenPane.addComponent
 * 
 * <pre>
 *       **************************
 *       *         Title          *
 *       **************************
 *       *                        *
 *       *                        *
 *       *      ContentPane       *
 *       *                        *
 *       *                        *
 *       **************************
 *       *         MenuBar        *
 *       **************************
 * </pre>
 */
public abstract class FormFactory extends AbstractActivity {
	
	private int screenWidth  = 0;
	private int screenHeight = 0;
	private int contentPaneHeight = 0;
	public static final int TITLE_AREA_HEIGHT   = 55;
	private final int MENUBAR_AREA_HEIGHT = 0;
	private final int ID_TITLEAREA   = 0xFF11;
	private final int ID_CONTENTPANE = 0xFF12;
	private final int ID_MENUBAR     = 0xFF13;
	private LinearLayout titleArea;
	private LinearLayout contentPane;
	private LinearLayout menuBar;
	private JRelativeLayout formLayout;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		screenWidth  = display.getWidth(); 
		screenHeight = display.getHeight(); 
		contentPaneHeight = screenHeight - Utils.convertDips2Pixel(TITLE_AREA_HEIGHT, getApplicationContext())*1;
		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
		linearLayout.setBackgroundDrawable(new ColorDrawable(0xFFFFFFFF));
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		formLayout = new JRelativeLayout(this);
 		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);
		formLayout.setLayoutParams(layoutParams);
		linearLayout.addView(formLayout);
		setContentView(linearLayout);
		//create title
		titleArea = new LinearLayout(this);
		titleArea.setBackgroundColor(Color.GRAY);
		titleArea.setId(ID_TITLEAREA);
		titleArea.setOrientation(LinearLayout.HORIZONTAL);
		RelativeLayout.LayoutParams relativeLayoutParamsTitleArea = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, Utils.convertDips2Pixel(TITLE_AREA_HEIGHT, getApplicationContext()));
		relativeLayoutParamsTitleArea.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
		relativeLayoutParamsTitleArea.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
 		titleArea.setLayoutParams(relativeLayoutParamsTitleArea);
		//create content 
		contentPane = new LinearLayout(this);
		contentPane.setBackgroundColor(Color.GRAY);
   		contentPane.setPadding(0, 0, 0, 0);
		contentPane.setId(ID_CONTENTPANE);
		RelativeLayout.LayoutParams relativeLayoutParamsContentPane = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);
		relativeLayoutParamsContentPane.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
		relativeLayoutParamsContentPane.addRule(RelativeLayout.BELOW, ID_TITLEAREA);
		relativeLayoutParamsContentPane.addRule(RelativeLayout.ABOVE, ID_MENUBAR);
		contentPane.setOrientation(LinearLayout.VERTICAL);
		contentPane.setLayoutParams(relativeLayoutParamsContentPane);
		//create menu 
		menuBar = new LinearLayout(this);
		menuBar.setGravity(Gravity.CENTER);
		menuBar.setOrientation(LinearLayout.VERTICAL);
		menuBar.setPadding(0, 0, 0, 0);
		menuBar.setId(ID_MENUBAR);
		menuBar.setBackgroundColor(0xFF777777);
		RelativeLayout.LayoutParams relativeLayoutParamsMenuBar = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, Utils.convertDips2Pixel(MENUBAR_AREA_HEIGHT, getApplicationContext()));
		relativeLayoutParamsMenuBar.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
		relativeLayoutParamsMenuBar.addRule(RelativeLayout.BELOW, ID_MENUBAR);
 		menuBar.setLayoutParams(relativeLayoutParamsMenuBar);
 		// add title, content, menu to form
 		formLayout.addView(titleArea);
		formLayout.addView(contentPane);
		formLayout.addView(menuBar);
		execute();
	}
	
	@Override
	protected void onResume() {
 		super.onResume();
 		
	}
	
	
	public int getContentPaneHeight() {
		return contentPaneHeight;
	}

	public void setContentPaneHeight(int contentPaneHeight) {
		this.contentPaneHeight = contentPaneHeight;
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	/**
	 * 
	 */
	public void alertDialogQuestion(final AbstractActivity abstractActivity){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setCancelable(true);
 		builder.setTitle("Alert");
 		builder.setMessage("We are only supporting standard modes resolution 1024x600, Are you sure you want to continuous?");
		builder.setInverseBackgroundForced(true);
		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
		  @Override
		  public void onClick(DialogInterface dialog, int which) {
			  dialog.dismiss();
  		  }
		});
		builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
		  @Override
		  public void onClick(DialogInterface dialog, int which) {
			  abstractActivity.finish();
		  }
		});
		AlertDialog alert = builder.create();
		alert.show();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		formLayout.removeAllViews();
		formLayout = null;
		System.gc();
	}

    /**
     * The should place its UI into the given form 
     */
	public abstract void execute();
	
	/***
	 * get layout params for screen title
	 * 
	 * @return
	 */
	public LinearLayout.LayoutParams getLinearLayoutLayoutParams() {
		Style style = new Style(getApplicationContext());
		style.setMargin(0, 0, 10, 10);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT), style.getMarginValue(AbstractActivity.TOP), style.getMarginValue(AbstractActivity.RIGHT), style.getMarginValue(AbstractActivity.BOTTOM));
		return layoutParams;
	}

	public LinearLayout getTitleArea() {
		return titleArea;
	}

	public void setTitleArea(LinearLayout titleArea) {
		this.titleArea = titleArea;
	}

	public LinearLayout getContentPane() {
		return contentPane;
	}

	public void setContentPane(LinearLayout contentPane) {
		this.contentPane = contentPane;
	}

	public LinearLayout getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(LinearLayout menuBar) {
		formLayout.addView(menuBar);
	}
	/***
	 * 
	 * @param id
	 */
	public void setBackgroundDrawableFormLayout(int id){
 		formLayout.invalidate();
 	}
}
