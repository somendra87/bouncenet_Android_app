package in.bouncenet.common.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.progressindicator.LinearProgressIndicator;

import in.bouncenet.R;
import in.bouncenet.models.ActionCardModel;

public class ActionCardView extends MaterialCardView {

    private TextView titleTv, subTitleTv, actionTv, percentageTv;
    private LinearProgressIndicator progressIndicator;

    public ActionCardView(Context context) {
        super(context);
        init(context);
    }

    public ActionCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ActionCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.view_action_card, this, true);
        titleTv = findViewById(R.id.txtActionTitle);
        subTitleTv = findViewById(R.id.txtActionSubTitle);
        actionTv = findViewById(R.id.btnAction);
        percentageTv = findViewById(R.id.txtPercentage);
        progressIndicator = findViewById(R.id.actionCardProgress);

        // Default Styling
        setRadius(getResources().getDimension(R.dimen.card_radius));
        setCardElevation(8f);

    }

    public void setData(ActionCardModel model){
        titleTv.setText(model.getTitle());
        subTitleTv.setText(model.getSubTitle());
        actionTv.setText(model.getActionText());
        setCardBackgroundColor(model.getBackgroundColor());

        // handle optional progress
        progressHandler(model);
    }

    private void progressHandler(ActionCardModel model) {
        if (model.getProgress() != null) {
            progressIndicator.setVisibility(VISIBLE);
            percentageTv.setVisibility(VISIBLE);

            progressIndicator.setProgress(model.getProgress());
            percentageTv.setText(model.getProgress() + "%");
        } else {
            progressIndicator.setVisibility(GONE);
            percentageTv.setText("0%");
        }
    }
}
