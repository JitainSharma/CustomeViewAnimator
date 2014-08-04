package com.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.animator.R;
import com.animators.ViewAnimator;


public class ViewAnimation extends LinearLayout {

	private ViewAnimator viewAnimator;

	private ImageView dataArrowOne, dataArrowTwo, dataArrowThree;
	
	public ViewAnimation(Context context) {
		super(context);

		inflate(R.layout.data_transmission_view);
		bind();
	}

	public ViewAnimation(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.customviewanimator, 0, 0);
		int layout = ta.getResourceId(R.styleable.customviewanimator_layout, R.layout.data_transmission_view);
		ta.recycle();
		inflate(layout);
		bind();
	}
	public ViewAnimation(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.customviewanimator, 0, 0);
		int layout = ta.getResourceId(R.styleable.customviewanimator_layout, R.layout.data_transmission_view);
		ta.recycle();
		inflate(layout);
		bind();
	}

	private void inflate(int layout) {
		LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (inflater != null) {
			inflater.inflate(layout, this);
		}
	}
	private void bind() {
		dataArrowOne = (ImageView)findViewById(R.id.data_arrow_one);
		dataArrowTwo = (ImageView)findViewById(R.id.data_arrow_two);
		dataArrowThree = (ImageView)findViewById(R.id.data_arrow_three);

		viewAnimator = new ViewAnimator(new View[]{dataArrowOne, dataArrowTwo, dataArrowThree},
				getResources().getDrawable(R.drawable.data_arrow_green),
				getResources().getDrawable(R.drawable.data_arrow_empty));
		viewAnimator.start();
	}
}