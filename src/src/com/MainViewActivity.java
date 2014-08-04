package com;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;

import com.animator.R;
import com.views.ViewAnimation;

public class MainViewActivity extends FragmentActivity {

	private ViewAnimation transmissionView;
	private LinearLayout viewLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_view);

		viewLayout = (LinearLayout)findViewById(R.id.dashboard_icon_layout);
		transmissionView = new ViewAnimation(this);
		viewLayout.addView(transmissionView);
	}

	@Override
	protected void onDestroy() {
		viewLayout = null;
		super.onDestroy();
	}
}