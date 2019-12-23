package com.wiser.self_vp;

import android.content.Context;
import android.util.AttributeSet;
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

	private int currentPage;

	public SelfHeightViewPagerN(@NonNull Context context) {
		super(context);
	}

	public SelfHeightViewPagerN(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
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
}
