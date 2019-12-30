package com.wiser.self_vp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * @author Wiser
 * 
 *         自适应高度VP
 */
public class SelfHeightViewPagerN extends ViewPager {

	private int		currentPage;

	private boolean	isCanScroll;

	public SelfHeightViewPagerN(@NonNull Context context) {
		super(context);
	}

	public SelfHeightViewPagerN(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	private void init(Context context, AttributeSet attrs) {
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SelfHeightViewPagerN);
		isCanScroll = ta.getBoolean(R.styleable.SelfHeightViewPagerN_svpn_scroll, isCanScroll);
		ta.recycle();
	}

	@Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if (getChildCount() > 0 && getChildCount() > currentPage) {
			View child = getChildAt(currentPage);
			child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
			int h = child.getMeasuredHeight();
			heightMeasureSpec = MeasureSpec.makeMeasureSpec(h, MeasureSpec.EXACTLY);
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	/**
	 * 在切换tab的时候，重置ViewPager的高度
	 *
	 * @param current
	 */
	public void resetHeight(int current) {
		this.currentPage = current;
		MarginLayoutParams params = (MarginLayoutParams) getLayoutParams();
		setLayoutParams(params);
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
