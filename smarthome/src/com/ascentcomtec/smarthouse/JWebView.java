package com.ascentcomtec.smarthouse;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/**
 * Project name : YWCA
 * Package name : com.ywca.portlets.aboutus
 * File name    : AboutUs.java
 * Create by    : longtq6195
 * Create date  : Sep 9, 2012 10:11:53 PM
 */
@SuppressLint("SetJavaScriptEnabled")
public class JWebView extends WebView{
	private Activity activity;
     /***
     * 
     * @param context
     */
	@SuppressLint("SetJavaScriptEnabled")
	public JWebView(Activity activity) {
		super(activity);
		this.activity = activity;
        getSettings().setJavaScriptEnabled(true);
        //getSettings().setBuiltInZoomControls(true);
        getSettings().setLoadsImagesAutomatically(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        //setInitialScale(100);
        getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        getSettings().setAllowFileAccess(true);
  		setHorizontalScrollBarEnabled(false);
		getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
  		setWebViewClient(webViewClient);
	}
	
	@Override
	public void scrollTo(int x, int y) {
		super.scrollTo(0,y);
	}
	/***
	 * 
	 */
	private WebViewClient webViewClient = new WebViewClient(){
		private ProgressDialog progressDialog;
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
	        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
	        activity.startActivity(intent);
	        return true; 
 		}
		/**
		 * 
		 */
        @Override
        public void onPageFinished(WebView view, final String url) {
    		if (progressDialog != null) {
    			progressDialog.cancel();
    			progressDialog = null;
    		}
        }
        /***
         * 
         */
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
    		if (progressDialog == null) {
    			progressDialog = ProgressDialog.show(activity, null, "Please wait...", true);
    			progressDialog.setCancelable(false);
    		}
        }

	};
}
