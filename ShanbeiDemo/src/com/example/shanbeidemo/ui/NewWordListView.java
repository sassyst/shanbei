package com.example.shanbeidemo.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class NewWordListView extends ListView {

	public NewWordListView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public NewWordListView(Context context, AttributeSet attrs) {
		// TODO Auto-generated constructor stub
		super(context, attrs);
	}

	public NewWordListView(Context context, AttributeSet attrs, int defStyle) {
		// TODO Auto-generated constructor stub
		super(context, attrs, defStyle);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);

	}

}
