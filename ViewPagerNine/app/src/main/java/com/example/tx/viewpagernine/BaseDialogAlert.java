package com.example.tx.viewpagernine;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by dell-3020 on 2017/9/26.
 */

public class BaseDialogAlert extends Dialog{

    public BaseDialogAlert(Context context) {
        super(context);
    }

    public BaseDialogAlert(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected BaseDialogAlert(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder {
        private Context mContext;
        private String title;
        private String message;
        private String positiveButtonText;
        private String negativeButtonText;
        private Bitmap bitmap;
        private View convertView;
        private OnClickListener positiveButtonClickListener, negativeButtonClickListener;

        public Builder (Context context){
            this.mContext = context;
        }

        public Builder setMessage(String message){
            this.message = message;
            return this;
        }

        public Builder setTitle(String title){
            this.title = title;
            return this;
        }

        public Builder setBitmap(Bitmap bitmap){
            this.bitmap = bitmap;
            return this;
        }

        public Builder setPositiveButtonText(String positiveButtonText, OnClickListener listener){
            this.positiveButtonText = positiveButtonText;
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButtonText(String negativeButtonText, OnClickListener listener){
            this.negativeButtonText = negativeButtonText;
            this.negativeButtonClickListener = listener;
            return this;
        }

        public Builder setConvertView(View view){
            this.convertView = view;
            return this;
        }

        public BaseDialogAlert creatDialog(){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // instantiate the dialog with the custom Theme
            final BaseDialogAlert dialog = new BaseDialogAlert(mContext, R.style.DialogTheme);
            View layout = inflater.inflate(R.layout.activity_dialog, null);
            dialog.addContentView(layout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            // set the dialog title
            if (title == null || title.trim().equals("")) {
                ((TextView) layout.findViewById(R.id.tv_title)).setVisibility(View.GONE);

            }

            else {
                ((TextView) layout.findViewById(R.id.tv_title)).setVisibility(View.VISIBLE);
                ((TextView) layout.findViewById(R.id.tv_title)).setText(title);
            }
            // set the confirm button
            if (positiveButtonText != null) {
                ((TextView) layout.findViewById(R.id.tv_to_know)).setText(positiveButtonText);
                if (positiveButtonClickListener != null) {
                    ((TextView) layout.findViewById(R.id.tv_to_know)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            positiveButtonClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                        }
                    });
                }
            } else {
                // if no confirm button just set the visibility to GONE
                layout.findViewById(R.id.tv_to_know).setVisibility(View.GONE);
            }
            // set the cancel button
            if (negativeButtonText != null) {
                ((TextView) layout.findViewById(R.id.tv_know)).setText(negativeButtonText);
                if (negativeButtonClickListener != null) {
                    ((TextView) layout.findViewById(R.id.tv_know)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            negativeButtonClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
                        }
                    });
                }
            } else {
                // if no confirm button just set the visibility to GONE
                layout.findViewById(R.id.tv_know).setVisibility(View.GONE);
            }
            if (message != null) {

                ((TextView) layout.findViewById(R.id.tv_content)).setText(message);
            } else if (convertView != null) {
                // if no message set
                // add the contentView to the dialog body
//                ((TextView) layout.findViewById(R.id.tv_content)).removeAllViews();
//                ((TextView) layout.findViewById(R.id.content)).addView(contentView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
            if (bitmap == null){
                layout.findViewById(R.id.iv_bc).setBackgroundResource(R.mipmap.ic_nsd_address);
            }
            dialog.setContentView(layout);
            Window window = dialog.getWindow();
            window.setGravity(Gravity.CENTER);
            android.view.WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.width = ((Activity) mContext).getWindowManager().getDefaultDisplay().getWidth() * 53 / 62; //原72
            window.setAttributes(layoutParams);
            window.setWindowAnimations(R.style.DialogThemeDefault);
            return dialog;
        }
    }
}
