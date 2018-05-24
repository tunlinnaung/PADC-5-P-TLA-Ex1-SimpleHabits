package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.components;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class MeViewPod extends FrameLayout {
    public MeViewPod(@NonNull Context context) {
        super(context);
    }

    public MeViewPod(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MeViewPod(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
