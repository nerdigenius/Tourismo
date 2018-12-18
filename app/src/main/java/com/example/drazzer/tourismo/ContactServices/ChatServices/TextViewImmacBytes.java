package com.example.drazzer.tourismo.ContactServices.ChatServices;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


public class TextViewImmacBytes extends android.support.v7.widget.AppCompatTextView {

    public TextViewImmacBytes(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewImmacBytes(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewImmacBytes(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.SANS_SERIF;
            setTypeface(tf);
        }
    }

}