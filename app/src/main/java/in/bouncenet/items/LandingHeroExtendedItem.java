package in.bouncenet.items;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.google.android.material.card.MaterialCardView;

import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;

public class LandingHeroExtendedItem implements BaseRecyclerItem {
    @Override
    public int getLayoutResourceId() {
        return R.layout.item_landing_hero_extended;
    }

    @Override
    public void bind(View itemView) {
        // Initialize views and animations here
        MaterialCardView cardCommunity = itemView.findViewById(R.id.cardCommunitySupport);
        MaterialCardView cardOpportunity = itemView.findViewById(R.id.cardLandingHeroExtendedFinancialSupport);
        MaterialCardView cardFinancial = itemView.findViewById(R.id.cardFindYourNextOpportunity);
        MaterialCardView cardLearning = itemView.findViewById(R.id.cardLandingHeroExtendedBnLearning);

        // Start floating animations
        startFloatingAnimation(cardCommunity, 0);
        startFloatingAnimation(cardOpportunity, 150);
        startFloatingAnimation(cardFinancial, 300);
        startFloatingAnimation(cardLearning, 450);
    }

    private void startFloatingAnimation(View card, long delay) {
        card.setTranslationY(10f);
        card.setAlpha(0.9f);

        card.animate()
                .translationY(-10f)
                .setDuration(3200)
                .setStartDelay(delay)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .withEndAction(() -> {
                            card.animate()
                                    .translationY(10f)
                                    .setDuration(3200)
                                    .setInterpolator(new AccelerateDecelerateInterpolator())
                                    .start();
                        }
                ).start();
    }

    @Override
    public Object getUniqueId() {
        return "LandingHeroExtended";
    }
}
