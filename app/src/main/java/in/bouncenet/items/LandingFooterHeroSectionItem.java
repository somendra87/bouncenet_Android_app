package in.bouncenet.items;

import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.button.MaterialButton;

import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;

public class LandingFooterHeroSectionItem implements BaseRecyclerItem {
    @Override
    public int getLayoutResourceId() {
        return R.layout.item_footer_hero_section;
    }

    @Override
    public void bind(View itemView) {
        TextView footerHeroTitle = itemView.findViewById(R.id.footerHeroTitleTv);
        TextView footerHeroSubTitle = itemView.findViewById(R.id.footerHeroSubTitleTv);
        MaterialButton communityThatCaresBtn = itemView.findViewById(R.id.commThatCaresBtn);
        MaterialButton supportThatEmpowers = itemView.findViewById(R.id.supportsThatEmpowersBtn);
        MaterialButton joinBounceNetToday = itemView.findViewById(R.id.joinBounceNetTodayBtn);
        MaterialButton seeHowItWorks = itemView.findViewById(R.id.seeHowItWorksBtn);
        MaterialButton btnChooseMembership = itemView.findViewById(R.id.btnUpgradeToPremiumMembership);

        btnChooseMembership.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_upgrade_to_plans_page);
        });
    }

    @Override
    public Object getUniqueId() {
        return "LANDING_PAGE_FOOTER_HERO";
    }
}
