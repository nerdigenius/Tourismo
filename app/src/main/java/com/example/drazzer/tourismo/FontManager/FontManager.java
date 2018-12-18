package com.example.drazzer.tourismo.FontManager;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Drazzer on 12/11/2017.
 */

public class FontManager {
    public static final String ROOT = "fonts/",
            FONTAWESOME = ROOT + "fontawesome-webfont.ttf";

    public static Typeface getTypeface(Context context, String font) {
        return Typeface.createFromAsset(context.getAssets(), font);
    }
}
