package com.animators;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;

public class CommonViewUtil {

	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	public static void setViewBackground(View view, Drawable drawable){
		int sdk = android.os.Build.VERSION.SDK_INT;
		if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
			view.setBackgroundDrawable(drawable);
		} else {
			view.setBackground(drawable);
		}
	}
}