package in.bouncenet.items;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;

public class PlanFeatureItem implements BaseRecyclerItem {

    private final String planFeatureText;

    public PlanFeatureItem(String planFeatureText) {
        this.planFeatureText = planFeatureText;
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.item_plan_features;
    }

    @Override
    public void bind(View itemView) {
        itemView.findViewById(R.id.planFeatureTickImage);
        TextView tvPlanFeatureText = itemView.findViewById(R.id.planFeatureTextView);

        tvPlanFeatureText.setText(planFeatureText);
    }

    @Override
    public Object getUniqueId() {
        return "PLAN_FEATURE_" + planFeatureText.hashCode();
    }
}
