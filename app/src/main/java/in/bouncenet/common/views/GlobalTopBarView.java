package in.bouncenet.common.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.navigation.Navigation;

import com.google.android.material.button.MaterialButton;

import in.bouncenet.R;

public class GlobalTopBarView extends ConstraintLayout {

    private ImageView imgLogo, imgAvatar;
    private TextView txtTitle, textSecondary;
    private MaterialButton btnPrimary;

    public GlobalTopBarView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public GlobalTopBarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GlobalTopBarView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        LayoutInflater.from(context)
                .inflate(R.layout.view_global_top_bar, this, true);
        imgLogo = findViewById(R.id.imgGlobalLogo);
        imgAvatar = findViewById(R.id.imgTopBarAvatar);
        txtTitle = findViewById(R.id.txtTopBarTitle);

        // login button
        textSecondary = findViewById(R.id.txtGlobalSecondary);

        // join now button
        btnPrimary = findViewById(R.id.btnGlobalPrimary);
        btnPrimary.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_landing_to_signup);
        });
        textSecondary.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_landing_to_login);
                });
    }

    // MODE: Brand/Public (Landing Page)
    public void setBrandMode(String primaryText, String secondaryText){
        imgLogo.setVisibility(VISIBLE);
        imgAvatar.setVisibility(GONE);
        txtTitle.setText("BounceNet");

        btnPrimary.setVisibility(VISIBLE);
        btnPrimary.setText(primaryText);

        if (secondaryText != null ){
            textSecondary.setVisibility(VISIBLE);
            textSecondary.setText(secondaryText);
        }
        updateTitleConstraint(R.id.imgGlobalLogo);
    }

    // MODE: User/Private (Dashboard)
    public void setUserMode(String name, int avatarRes) {
        imgLogo.setVisibility(GONE);
        imgAvatar.setVisibility(VISIBLE);
        imgAvatar.setImageResource(avatarRes);

        txtTitle.setText("Hello, " + name);
        btnPrimary.setVisibility(GONE);
        textSecondary.setVisibility(GONE);

        updateTitleConstraint(R.id.imgTopBarAvatar);
    }

    // Helper to fix spacing based on which icon is showing
    private void updateTitleConstraint(int startId) {
        ConstraintLayout inner = findViewById(R.id.innerConstraintLayout);
        ConstraintSet set = new ConstraintSet();
        set.clone(inner);
        set.connect(R.id.txtTopBarTitle, ConstraintSet.START, startId, ConstraintSet.END);
        set.applyTo(inner);
    }
}
