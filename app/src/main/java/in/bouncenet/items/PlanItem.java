package in.bouncenet.items;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.List;

import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;
import in.bouncenet.common.recycler.GenericAdapter;
import in.bouncenet.enums.PlanType;
import in.bouncenet.models.PlanModel;

public class PlanItem implements BaseRecyclerItem {

    private final PlanModel planModel;
    private boolean isSelected = false;

    public PlanItem(PlanModel planModel) {
        this.planModel = planModel;
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.item_plan_card;
    }

    @Override
    public void bind(View itemView) {
        MaterialCardView planCardContainer = itemView.findViewById(R.id.planCardContainerRoot);
        TextView tvPlanType = itemView.findViewById(R.id.tvPlanType);
        TextView tvPlanPrice = itemView.findViewById(R.id.planPrice);
        TextView tvPlanBillingCycle = itemView.findViewById(R.id.planBillingCycle);
        Chip chipPopular = itemView.findViewById(R.id.chipPopular);
        MaterialButton btnChoosePlan = itemView.findViewById(R.id.btnChoosePlan);
        RecyclerView planFeatureRecycler = itemView.findViewById(R.id.recyclerPlanFeatures);

        Context context = itemView.getContext();

        tvPlanType.setText(planModel.planType().getDisplayName().toUpperCase());
        tvPlanType.setTextColor(ContextCompat.getColor(context,
                planModel.planType().getAccentColor()));
        tvPlanType.setBackgroundTintList(
                ColorStateList.valueOf(ContextCompat.getColor(context,
                        planModel.planType().getPlanTypelabelBgColor()))
        );
        tvPlanBillingCycle.setText(planModel.billingCycle());



        updateSelectionUi(planCardContainer, context);

        setUpPlanFeatures(planFeatureRecycler, planModel.planType());

        switch (planModel.planType()) {
            case SILVER -> {
                tvPlanPrice.setText(planModel.planPrice());
                chipPopular.setVisibility(GONE);
                btnChoosePlan.setText("Choose " + planModel.planType());
                break;
            }
            case GOLD -> {
                tvPlanPrice.setText(planModel.planPrice());
                chipPopular.setVisibility(VISIBLE);
                btnChoosePlan.setText("Choose " + planModel.planType());
                break;
            }
            case DIAMOND -> {
                tvPlanPrice.setText(planModel.planPrice());
                chipPopular.setVisibility(GONE);
                btnChoosePlan.setText("Choose " +  planModel.planType());
                break;
            }
        }

        if (isSelected){
            int buttonColor = R.color.primary;
            int buttonTextColor = R.color.white;
            btnChoosePlan.setBackgroundTintList(ColorStateList.valueOf(
                    ContextCompat.getColor(context, buttonColor)));
            btnChoosePlan.setTextColor(ContextCompat.getColor(context, buttonTextColor));
        }

    }

    private void updateSelectionUi(MaterialCardView planCardContainer, Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        if (isSelected){
            planCardContainer.setStrokeColor(ContextCompat.getColor(context, R.color.feature_blue));
            planCardContainer.setStrokeWidth((int) (2 * density)); // 4dp in pixels
        } else {
            planCardContainer.setStrokeColor(ContextCompat.getColor(context, R.color.card_border));
            planCardContainer.setStrokeWidth((int) (1.5 * density)); // 1.5dp in pixels
        }
    }

    private void setUpPlanFeatures(RecyclerView planFeatureRecycler,
                                   List<String> planFeatures) {
        List<BaseRecyclerItem> planFeatureItems = new ArrayList<>();
        planFeatureRecycler.setLayoutManager(new LinearLayoutManager(planFeatureRecycler.getContext()));

        planFeatures.forEach(featureText -> {
            planFeatureItems.add(new PlanFeatureItem(featureText));
        });
        /*switch (planType) {
            case SILVER -> {
                planFeatures.add(new PlanFeatureItem("Access to Job Board"));
                planFeatures.add(new PlanFeatureItem("Basic Learning Path"));
                planFeatures.add(new PlanFeatureItem("Community Forum Access"));
                break;
            }
            case GOLD -> {
                planFeatures.add(new PlanFeatureItem("Everything in Silver"));
                planFeatures.add(new PlanFeatureItem("Full BounceUp library"));
                planFeatures.add(new PlanFeatureItem("Priority job matching"));
                planFeatures.add(new PlanFeatureItem("Mentorship sessions"));
                break;
            }
            case DIAMOND -> {
                planFeatures.add(new PlanFeatureItem("Everything in Gold"));
                planFeatures.add(new PlanFeatureItem("Dedicated career coach"));
                planFeatures.add(new PlanFeatureItem("Direct recruiter access"));
                break;
            }
        }*/
        GenericAdapter planFeatureAdapter = new GenericAdapter();
        planFeatureAdapter.submitList(planFeatureItems);
        planFeatureRecycler.setAdapter(planFeatureAdapter);
        planFeatureRecycler.setNestedScrollingEnabled(false);
    }

    @Override
    public Object getUniqueId() {
        return "PLAN_" + planModel.planType().name();
    }

    public PlanModel getPlanType() {
        return planModel;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
