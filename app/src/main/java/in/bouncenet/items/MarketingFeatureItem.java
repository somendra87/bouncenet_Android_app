package in.bouncenet.items;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;
import in.bouncenet.helpers.BnHelper;

public class MarketingFeatureItem implements BaseRecyclerItem {
    private final String marketingTitle;
    private final String marketingDescription;
    private final String marketingBullets;
    private final String marketingButtonAction;
    private final int marketingIconResource;
    private final int marketingColorTheme;

    public MarketingFeatureItem(String marketingTitle,
                                String marketingDescription,
                                String marketingBullets,
                                String marketingButtonAction,
                                int marketingIconResource,
                                int marketingColorTheme) {
        this.marketingTitle = marketingTitle;
        this.marketingDescription = marketingDescription;
        this.marketingBullets = marketingBullets;
        this.marketingButtonAction = marketingButtonAction;
        this.marketingIconResource = marketingIconResource;
        this.marketingColorTheme = marketingColorTheme;
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.item_marketing_feature;
    }

    @Override
    public void bind(View itemView) {
        View topCardAccent = itemView.findViewById(R.id.topAccentBar);
        TextView titleTv = itemView.findViewById(R.id.marketingFeatureTitle);
        TextView descriptionTv = itemView.findViewById(R.id.marketingFeatureDesc);
        TextView bulletTv = itemView.findViewById(R.id.marketingFeatureBullets);
        TextView btnAction = itemView.findViewById(R.id.marketingFeatureBtnAction);


        ImageView iconIv = itemView.findViewById(R.id.marketingFeatureIcon);
        iconIv.getBackground().setTint(BnHelper.resolvedColor(itemView, marketingColorTheme));
        iconIv.getBackground().setAlpha(38); // 15% opacity
        iconIv.setColorFilter(BnHelper.resolvedColor(itemView, marketingColorTheme));
        iconIv.setImageResource(marketingIconResource);


        // 2. Color Coordinated Ticks (Spannable logic)
        SpannableStringBuilder ssb = new SpannableStringBuilder(marketingBullets);
        int index = marketingBullets.indexOf("✓");
        while (index >= 0) {
            ssb.setSpan(new ForegroundColorSpan(
                    BnHelper.resolvedColor(itemView, marketingColorTheme)),
                    index, index + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            index = marketingBullets.indexOf("✓", index + 1);
        }
        bulletTv.setText(ssb);

        topCardAccent.setBackgroundColor(BnHelper.resolvedColor(itemView, marketingColorTheme));
        titleTv.setText(marketingTitle);
        descriptionTv.setText(marketingDescription);

        btnAction.setText(marketingButtonAction + "→");
        btnAction.setTextColor(BnHelper.resolvedColor(itemView, marketingColorTheme));

    }

    @Override
    public Object getUniqueId() {
        return marketingTitle;
    }
}
