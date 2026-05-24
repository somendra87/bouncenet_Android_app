package in.bouncenet.common.custom;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.button.MaterialButton;

import in.bouncenet.R;

public class CustomGlassButton extends MaterialButton {
    public CustomGlassButton(@NonNull Context context) {
        super(context);
        init();
    }

    public CustomGlassButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomGlassButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setBackgroundResource(R.drawable.bg_glass_premium);
        setCornerRadius((int) getResources().getDisplayMetrics().density * 12);
        setTextColor(Color.WHITE);
        setTextSize(16);
        setElevation(12f);
    }
}
