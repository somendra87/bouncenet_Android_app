package in.bouncenet.containers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.button.MaterialButton;

import in.bouncenet.R;
import in.bouncenet.models.PremiumUpgrade;

public class PremiumUpgradeContainer extends ConstraintLayout {

    private TextView premiumTitle;
    private TextView premiumDescription;
    private MaterialButton mateUpgradeButton;

    public PremiumUpgradeContainer(@NonNull Context context) {
        super(context);
        init(context);
    }

    public PremiumUpgradeContainer(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PremiumUpgradeContainer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context)
                .inflate(R.layout.view_premium_upgrade, this, true);
        initViews();
    }

    private void initViews() {
        premiumTitle = findViewById(R.id.premiumUpgradeTitleTextView);
        premiumDescription = findViewById(R.id.premiumUpgradeDescriptionTextView);
        mateUpgradeButton = findViewById(R.id.premiumUpgradeActionButton);
    }

    public void setData(
            PremiumUpgrade data
    ){
        premiumTitle.setText(data.getPremiumUpgradeTitle());
        premiumDescription.setText(data.getPremiumUpgradeDescription());
        mateUpgradeButton.setText(data.getPremiumUpgradeActionText());
    }

}
