package com.fitbitsample.dialog;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class BaseDialog extends Dialog {
    Context context;

    BaseDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
    }


}