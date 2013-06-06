package com.ascentcomtec.smarthouse.ui.plaf;

import android.content.Context;

import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
import com.ascentcomtec.smarthouse.utils.Utils;
/***
 * Project name : YWCA
 * Package name : com.ywca.ui.plaf
 * File name    : Style.java
 */
public class Style {
	
    private Context context;
    private int fgColor   = 0x000000;
    private int bgColor   = 0xFFFFFF;
    private int[] padding = new int[4];
    private int[] margin  = new int[4];

    /**
     * Each component when it draw itself uses this Object 
     * to determine in what colors it should use.
     * When a Component is generated it construct a default Style Object.
     * The Default values for each Component can be changed by using the UIManager class
     */
	public Style(Context context) {
		this.context = context;
		setPadding(5, 5, 15, 15);
		setMargin(5, 5, 15, 15);
	}
    /**
     * Sets the Style Margin
     *  
     * @param top number of margin pixels
     * @param bottom number of margin pixels
     * @param left number of margin pixels
     * @param right number of margin pixels
     */
    public void setMargin(int top, int bottom, int left, int right) {
        if (top < 0 || left < 0 || right < 0 || bottom < 0) {
            throw new IllegalArgumentException("margin cannot be negative");
        }
        if (margin[AbstractActivity.TOP] != top || margin[AbstractActivity.BOTTOM] != bottom || margin[AbstractActivity.LEFT] != left || margin[AbstractActivity.RIGHT] != right) {
            margin[AbstractActivity.TOP]    = Utils.convertDips2Pixel(top, context);
            margin[AbstractActivity.BOTTOM] = Utils.convertDips2Pixel(bottom, context);
            margin[AbstractActivity.LEFT]   = Utils.convertDips2Pixel(left, context);
            margin[AbstractActivity.RIGHT]  = Utils.convertDips2Pixel(right, context);
         }
    }
    /**
     * Sets the Style Margin
     * 
     * @param orientation one of: Component.TOP, Component.BOTTOM, Component.LEFT, Component.RIGHT
     * @param gap number of margin pixels
     */
    public void setMargin(int orientation, int gap) {
        setMargin(orientation, gap, false);
    }
    /**
     * Sets the Style Margin
     * 
     * @param orientation one of: Component.TOP, Component.BOTTOM, Component.LEFT, Component.RIGHT
     * @param gap number of margin pixels
     * @param override If set to true allows the look and feel/theme to override 
     * the value in this attribute when changing a theme/look and feel
     */
    public void setMargin(int orientation, int gap, boolean override) {
        if (orientation < AbstractActivity.TOP || orientation > AbstractActivity.RIGHT) {
            throw new IllegalArgumentException("wrong orientation " + orientation);
        }
        if (gap < 0) {
            throw new IllegalArgumentException("margin cannot be negative");
        }
        if (margin[orientation] != gap) {
            margin[orientation] = Utils.convertDips2Pixel(gap, context);
        }
    }
    /**
     * Returns the Margin
     * 
     * @param orientation one of: Component.TOP, Component.BOTTOM, Component.LEFT, Component.RIGHT
     * @return number of margin pixels in the givven orientation
     */
    public int getMarginValue(int orientation) {
        if (orientation < AbstractActivity.TOP || orientation > AbstractActivity.RIGHT) {
            throw new IllegalArgumentException("wrong orientation " + orientation);
        }
        return margin[orientation];
    }

    /**
     * Sets the Style Padding
     *  
     * @param top number of pixels to padd
     * @param bottom number of pixels to padd
     * @param left number of pixels to padd
     * @param right number of pixels to padd
     */
    public void setPadding(int top, int bottom, int left, int right) {
        if (top < 0 || left < 0 || right < 0 || bottom < 0) {
            throw new IllegalArgumentException("padding cannot be negative");
        }
        if (padding[AbstractActivity.TOP] != top || padding[AbstractActivity.BOTTOM] != bottom || padding[AbstractActivity.LEFT] != left || padding[AbstractActivity.RIGHT] != right) {
            padding[AbstractActivity.TOP]    = Utils.convertDips2Pixel(top, context);
            padding[AbstractActivity.BOTTOM] = Utils.convertDips2Pixel(bottom, context);
            padding[AbstractActivity.LEFT]   = Utils.convertDips2Pixel(left, context);
            padding[AbstractActivity.RIGHT]  = Utils.convertDips2Pixel(right, context);
        }
    }
    /**
     * Sets the Style Padding
     * 
     * @param orientation one of: Component.TOP, Component.BOTTOM, Component.LEFT, Component.RIGHT
     * @param gap number of pixels to padd
     */
    public void setPadding(int orientation, int gap) {
        setPadding(orientation, gap, false);
    }
    /**
     * Sets the Style Padding
     * 
     * @param orientation one of: Component.TOP, Component.BOTTOM, Component.LEFT, Component.RIGHT
     * @param gap number of pixels to padd
     * @param override If set to true allows the look and feel/theme to override 
     * the value in this attribute when changing a theme/look and feel
     */
    public void setPadding(int orientation, int gap,boolean override) {
        if (orientation < AbstractActivity.TOP || orientation > AbstractActivity.RIGHT) {
            throw new IllegalArgumentException("wrong orientation " + orientation);
        }
        if (gap < 0) {
            throw new IllegalArgumentException("padding cannot be negative");
        }
        if (padding[orientation] != gap) {
            padding[orientation] = Utils.convertDips2Pixel(gap, context);
        }
    }
    /**
     * Returns the Padding in the internal value regardless of the unit
     *
     * @param orientation one of: Component.TOP, Component.BOTTOM, Component.LEFT, Component.RIGHT
     * @return number of padding pixels in the givven orientation
     */
    public int getPaddingValue(int orientation) {
        if (orientation < AbstractActivity.TOP || orientation > AbstractActivity.RIGHT) {
            throw new IllegalArgumentException("wrong orientation " + orientation);
        }
        return padding[orientation];
    }


    /**
     * Background color for the component
     *
     * @return the background color for the component
     */
    public int getBgColor() {
        return bgColor;
    }
 
 
    /**
     * Foreground color for the component
     *
     * @return the foreground color for the component
     */
    public int getFgColor() {
        return fgColor;
    }
}
