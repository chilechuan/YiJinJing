package com.example.tx.viewpagernine;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;

/**
 * Created by dell-3020 on 2017/9/26.
 */

public class BaseDialogAlertUtils {

    public static Dialog showAlertDialog(Context context, String title, String message, Bitmap bitmap, String leftLabel, DialogInterface.OnClickListener leftListener,
                                         String rightLabel, DialogInterface.OnClickListener rightListener){
        BaseDialogAlert.Builder builder = new BaseDialogAlert.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setBitmap(bitmap);
        builder.setNegativeButtonText(leftLabel, leftListener);
        builder.setPositiveButtonText(rightLabel, rightListener);
        BaseDialogAlert dialog = builder.creatDialog();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        return dialog;
    }
}
