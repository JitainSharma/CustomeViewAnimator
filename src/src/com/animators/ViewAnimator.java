package com.animators;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;

/**
 * This class presents the way to animate the views by using the
 * Runnable and Handler.
 * @author jsharma
 *
 */
public class ViewAnimator {

	private final Handler updateView = new Handler();
	private Runnable runUpdate;
	private final long delayMillis = 700; //.5Sec

	private int totalCount = 0;
	private int currentCount = 0;

	private View[] views;
	private Drawable drawableActive, drawableDeActive;

	public ViewAnimator(View[] views, Drawable drawableActive, Drawable drawableDeActive){
		this.views = views;
		this.drawableActive = drawableActive;
		this.drawableDeActive = drawableDeActive;

		if(null != views)
			totalCount = views.length;
	}

	public void start(){

		if(null == updateView || null == views){
			return;
		}

		if(null != runUpdate){
			updateView.removeCallbacks(runUpdate);
		}
		initilizeRunnable();
		updateView.postDelayed(runUpdate, delayMillis);
	}

	public void stop(){
		if(null != updateView){
			if(null != runUpdate){
				updateView.removeCallbacks(runUpdate);
			}
		}
		runUpdate = null;
	}

	public void reset(View[] views, Drawable drawableActive, Drawable drawableDeActive){
		stop();

		this.views = views;
		this.drawableActive = drawableActive;
		this.drawableDeActive = drawableDeActive;

		if(null != views)
			totalCount = views.length;

		start();
	}

	private void initilizeRunnable(){
		runUpdate = new Runnable() {

			@Override
			public void run() {

				if(currentCount == totalCount){
					currentCount = 0;
					for(int i= (currentCount); i<totalCount; i++ ){
						CommonViewUtil.setViewBackground(views[i], drawableDeActive);
					}
				}
				else{
					for(int i= (currentCount); i<totalCount; i++ ){
						CommonViewUtil.setViewBackground(views[i], drawableDeActive);
					}				
					CommonViewUtil.setViewBackground(views[currentCount], drawableActive);
					currentCount++;
				}				
				start();
			}
		};
	}
}