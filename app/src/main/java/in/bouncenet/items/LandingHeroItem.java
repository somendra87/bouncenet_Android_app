package in.bouncenet.items;

import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;

import androidx.navigation.Navigation;

import com.google.android.material.button.MaterialButton;

import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;
import in.bouncenet.helpers.BnTextHelper;

public class LandingHeroItem implements BaseRecyclerItem {

    private final String title;
    private final String subTitle;

    private String heroLabel;
    private int labelColor;

    public LandingHeroItem(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public LandingHeroItem(String title,
                           String subTitle,
                           String heroLabel,
                           int labelColor) {
        this.title = title;
        this.subTitle = subTitle;
        this.heroLabel = heroLabel;
        this.labelColor = labelColor;
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.item_landing_hero;
    }

    @Override
    public void bind(View itemView) {
        TextView titleTv = itemView.findViewById(R.id.txtHeroTitle);
        TextView subTitleTv = itemView.findViewById(R.id.txtHeroSubTitle);
        TextView labelTv = itemView.findViewById(R.id.txtHeroLabel);
        MaterialButton btnJoin = itemView.findViewById(R.id.btnJoinHero);
        MaterialButton btnSeeHowItWorks = itemView.findViewById(R.id.seeHowItWorksHero);

        // Spannable string , different color for different words
        SpannableString spannableTitle = BnTextHelper.setMultiColorText(title,
                new String[]{"#0A3D91", "#0A3D91", "#F4B400", "#FF8A1F"});


        titleTv.setText(spannableTitle);
        subTitleTv.setText(subTitle);
        labelTv.setText(heroLabel);
        labelTv.setTextColor(labelColor);
        btnJoin.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.homeFragment));
        btnSeeHowItWorks.setOnClickListener(v -> btnSeeHowItWorks.performClick());

    }

    @Override
    public Object getUniqueId() {
        return "LANDING_HERO_SECTION";
    }
}
