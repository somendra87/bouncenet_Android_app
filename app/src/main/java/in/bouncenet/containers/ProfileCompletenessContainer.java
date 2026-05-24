package in.bouncenet.containers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.progressindicator.LinearProgressIndicator;

import in.bouncenet.R;
import in.bouncenet.models.ProfileCompleteness;

public class ProfileCompletenessContainer extends ConstraintLayout {


    private TextView txtProfileTitle;
    private TextView txtPercentage;
    private TextView txtProfileDescription;
    private TextView txtAction;
    private LinearProgressIndicator profileProgressIndicator;

    public ProfileCompletenessContainer(@NonNull Context context) {
        super(context);
        init(context);
    }

    public ProfileCompletenessContainer(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ProfileCompletenessContainer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        LayoutInflater.from(context)
                .inflate(R.layout.view_profile_completeness, this, true);
        initViews();
    }

    private void initViews() {
        txtProfileTitle = findViewById(R.id.profileCompletenessTitle);
        txtPercentage = findViewById(R.id.profileCompletenessPercentage);
        txtProfileDescription = findViewById(R.id.profileCompletenessDescriptionText);
        txtAction = findViewById(R.id.profileCompletenessActionText);
        profileProgressIndicator = findViewById(R.id.profileProgressBarIndicator);
    }

    public void setData(ProfileCompleteness data){
        txtProfileTitle.setText(data.getProfileCompletenessTitle());
        txtProfileDescription.setText(data.getProfileCompletenessDescription());
        txtAction.setText(data.getProfileCompletenessActionText());
        profileProgressIndicator.setProgress(data.getProgress());
        txtPercentage.setText(getContext().getString(R.string.profile_percentage, data.getProgress()));
    }
}
