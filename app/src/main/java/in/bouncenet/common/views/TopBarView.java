package in.bouncenet.common.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.jetbrains.annotations.NotNull;

import in.bouncenet.R;

public class TopBarView extends ConstraintLayout {

    public TopBarView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public TopBarView(@NotNull Context context,
                      @Nullable AttributeSet attrs,
                      int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    // ADD THIS CONSTRUCTOR
    public TopBarView(@NonNull Context context,
                      @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context)
                .inflate(R.layout.view_top_bar, this, true);
    }

}
