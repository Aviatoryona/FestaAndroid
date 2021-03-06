package com.aviator.festa.fsta;

import java.lang.reflect.Field;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.io.File;

public final class FontsOverride {

    public static void setDefaultFont(Context context, String staticTypefaceFieldName, String fontAssetName) {
        final Typeface regular = Typeface.createFromAsset(context.getAssets(),
                fontAssetName);
        replaceFont(staticTypefaceFieldName, regular);
    }

    public static void setDefaultFont(Context context,
                                      String staticTypefaceFieldName, File fontAssetName) {
        final Typeface regular = Typeface.createFromFile(fontAssetName);
        replaceFont(staticTypefaceFieldName, regular);
    }

    private static void replaceFont(String staticTypefaceFieldName, final Typeface newTypeface) {
        try {
            final Field staticField = Typeface.class
                    .getDeclaredField(staticTypefaceFieldName);
            staticField.setAccessible(true);
            staticField.set(null, newTypeface);
        } catch (NoSuchFieldException e) {
            Log.d("FontsOveride", e.getMessage());
        } catch (IllegalAccessException e) {
            Log.d("FontsOveride", e.getMessage());
        }
    }
}

