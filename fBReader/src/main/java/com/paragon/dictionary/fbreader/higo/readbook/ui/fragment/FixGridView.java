package com.paragon.dictionary.fbreader.higo.readbook.ui.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by zhangyipeng on 16/1/16.
 */
public class FixGridView extends GridView {
    public FixGridView(Context context) {
        super(context);

    }

    public FixGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FixGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
