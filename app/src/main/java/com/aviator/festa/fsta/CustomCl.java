package com.aviator.festa.fsta;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.aviator.festa.R;
import com.aviator.festa.clbks.IOSDgCallBack;
import com.marcoscg.dialogsheet.DialogSheet;


public class CustomCl {

    public static class Builder {
        private Context context;

        public Builder(Context context) {
            this.context = context;
        }

        public View getView(int resId) {
            return LayoutInflater.from(context)
                    .inflate(resId, null, false);
        }

        public View getView(@NonNull ViewGroup viewGroup, int resId) {
            return LayoutInflater.from(viewGroup.getContext())
                    .inflate(resId, viewGroup, false);
        }

        public Typeface getTypeface(@NonNull String font) {
            try {
                return Typeface.createFromAsset(context.getAssets(), "fonts/" + font);
            } catch (Exception e) {
                return Typeface.SANS_SERIF;
            }
        }

        @SuppressLint("ClickableViewAccessibility")
        PopupWindow createPopUp(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams;
            if (view.getLayoutParams() != null) {
                layoutParams = view.getLayoutParams();
            } else {
                layoutParams = new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
            }

            PopupWindow popupWindow = new PopupWindow();
            popupWindow.setHeight(layoutParams.height);
            popupWindow.setWidth(layoutParams.width);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setContentView(view);
            popupWindow.setFocusable(true);
            popupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
            popupWindow.setTouchable(true);
            popupWindow.setTouchInterceptor((View v, MotionEvent event) -> {
                popupWindow.dismiss();
                return true;
            });

            return popupWindow;
        }

//        public void ShowIOSDg(@NonNull String title, @NonNull String subtitle, @NonNull String ok, @NonNull String dismiss, @NonNull IOSDgCallBack callBack) {
//            new iOSDialogBuilder(context)
//                    .setTitle(title)
//                    .setSubtitle(subtitle)
//                    .setBoldPositiveLabel(true)
//                    .setCancelable(true)
//                    .setPositiveListener(ok, dialog -> {
//                        dialog.dismiss();
//                        callBack.Ok();
//                    })
//                    .setNegativeListener(dismiss, dialog -> {
//                        dialog.dismiss();
//                        callBack.Dismiss();
//                    })
//                    .build().show();
//        }

        public void ShowDialogSheet(@NonNull String title, @NonNull String subtitle, @NonNull String ok, @NonNull String dismiss, @NonNull IOSDgCallBack callBack, boolean isCancellable, @Nullable Drawable drawable) {
            DialogSheet dialogSheet = new DialogSheet(context)
                    .setTitle(title)
                    .setMessage(subtitle)
                    .setCancelable(isCancellable)
                    .setPositiveButton(ok, v -> {
                        // Your action
                        callBack.Ok();
                    })
                    .setNegativeButton(dismiss, v -> {
                        // Your action
                        callBack.Dismiss();
                    })
                    .setButtonsColorRes(R.color.colorAccent);  // Default color is accent
            if (drawable != null) {
                dialogSheet.setIcon(drawable);
            }
            dialogSheet.show();
        }

    }

}
