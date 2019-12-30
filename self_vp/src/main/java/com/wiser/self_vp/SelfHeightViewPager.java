package com.wiser.self_vp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * @author Wiser
 * 
 *         自适应ViewPager高度
 */
public class SelfHeightViewPager extends ViewPager {

	private boolean isCanScroll;

	public SelfHeightViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	private void init(Context context, AttributeSet attrs) {
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SelfHeightViewPager);
		isCanScroll = ta.getBoolean(R.styleable.SelfHeightViewPager_svp_scroll, isCanScroll);
		ta.recycle();
	}

	@Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		View view = getChildAt(getCurrentItem());
		if (view != null) {
			view.measure(widthMeasureSpec, heightMeasureSpec);
		}

		setMeasuredDimension(getMeasuredWidth(), measureHeight(heightMeasureSpec, view));
	}

	private int measureHeight(int measureSpec, View view) {
		int result = 0;
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize = MeasureSpec.getSize(measureSpec);

		if (specMode == MeasureSpec.EXACTLY) {
			result = specSize;
		} else {
			// set the height from the base view if available
			if (view != null) {
				result = view.getMeasuredHeight();
			}
			if (specMode == MeasureSpec.AT_MOST) {
				result = Math.min(result, specSize);
			}
		}
		return result;
	}

	@Override public boolean onInterceptTouchEvent(MotionEvent ev) {
		return isCanScroll && super.onInterceptTouchEvent(ev);
	}

	@SuppressLint("ClickableViewAccessibility") @Override public boolean onTouchEvent(MotionEvent ev) {
		return isCanScroll && super.onTouchEvent(ev);
	}

	public boolean isCanScroll() {
		return isCanScroll;
	}

	public void setCanScroll(boolean isCanScroll) {
		this.isCanScroll = isCanScroll;
	}
}
