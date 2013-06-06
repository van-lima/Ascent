package com.ascentcomtec.smarthouse.ui.components;

import android.content.Context;
import android.media.MediaPlayer;

public class Media {
	
	private Context context;
	private static Media media;
    private MediaPlayer mediaPlayer;
    /**
     * 
     * @param context
     */
    private Media(Context context){
    	this.context = context;
    }
    /**
     * 
     * @param context
     * @return
     */
	public static Media getMedia(Context context){
		if(null == media){
 			media = new Media(context);
		}
		return media;
	}
	/***
	 * 
	 */
	public void start(){
		if (null == mediaPlayer) {
			mediaPlayer = MediaPlayer.create(context, com.ascentcomtec.smarthouse.R.raw.beep_sm);
		}
		if (null != mediaPlayer && !mediaPlayer.isPlaying()) {
			mediaPlayer.start();
		}
	}
	
}
