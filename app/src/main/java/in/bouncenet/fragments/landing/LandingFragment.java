package in.bouncenet.fragments.landing;

import android.graphics.Color;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;
import in.bouncenet.common.recycler.GenericAdapter;
import in.bouncenet.common.views.GlobalTopBarView;
import in.bouncenet.items.CommunityStatsItem;
import in.bouncenet.items.FooterItem;
import in.bouncenet.items.LandingFooterHeroSectionItem;
import in.bouncenet.items.LandingHeroExtendedItem;
import in.bouncenet.items.LandingHeroItem;
import in.bouncenet.items.ItemSectionHeader;
import in.bouncenet.items.MarketingFeatureItem;
import in.bouncenet.items.ProcessStepItem;
import in.bouncenet.items.StatUnitItem;
import in.bouncenet.viewmodel.LandingViewModel;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class LandingFragment extends Fragment {

    private GenericAdapter genericAdapter = new GenericAdapter();
    private LandingViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_landing, container, false);


        // initialize ViewModel
        viewModel = new ViewModelProvider(this).get(LandingViewModel.class);

        setUpTopBar(view);
        setUpLandingPageRecycler(view);

        // Triggering dataload from ViewModel
        viewModel.loadData();
        return view;
    }

    private void setUpTopBar(View view) {
        GlobalTopBarView topBarView = view.findViewById(R.id.landingTopBar);
        topBarView.setBrandMode("Join Now", "Log in");
    }

    private void setUpLandingPageRecycler(View view){
        RecyclerView recyclerView = view.findViewById(R.id.landingRecyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                BaseRecyclerItem item = genericAdapter.getItemAt(position);
                return (item instanceof StatUnitItem) ? 1 : 2;
            }
        });

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(genericAdapter);

        // 3. Observe the LiveData from ViewModel
        viewModel.getLandingPageItems().observe(getViewLifecycleOwner(), items -> {
            genericAdapter.submitList(items);
        });

    }

    private void buildLandingPage() {
        /*List<BaseRecyclerItem> recyclerItems = new ArrayList<>();
        recyclerItems.add(new LandingHeroItem(
                "From Setback\nTo Comeback.",
                "Join a community that stands with you.",
                "♥ A COMMUNITY THAT STANDS WITH YOU",
                Color.BLACK
        ));

        // landing page hero section extended
        recyclerItems.add(
                new LandingHeroExtendedItem()
        );

        // landing page stats count
        recyclerItems.add(new CommunityStatsItem());

        // headers
        recyclerItems.add(
                new ItemSectionHeader(
                        "Everything you need to Bounce Back",
                        "We combine Technology, Community and Compassion"
                )
        );

        // 2. Marketing Features (Vertical Cards)
        recyclerItems.add(new MarketingFeatureItem(
                "1. Financial Support from Community Fund",
                "Get verified financial assistance during job loss or emergencies " +
                        "from our transparent community fund",
                "✓ Verified and secured Support.\n✓ Transparent fund usage.\n✓ Dignified Help No Judgement",
                "LEARN MORE",
                R.drawable.twotone_money_24,
                getContext().getColor(R.color.feature_green)));
        recyclerItems.add(new MarketingFeatureItem(
                "2. Get Your Next Job",
                "AI powered matching...",
                "✓ Bullet 1\n✓ Bullet 2",
                "EXPLORE",
                R.drawable.twotone_workspaces_24,
                getContext().getColor(R.color.feature_blue)));

        // 3. Stats (This will automatically form a 2x2 grid because of the SpanSizeLookup)
        recyclerItems.add(new StatUnitItem("10,000+",
                "Members", R.drawable.twotone_group_24));
        recyclerItems.add(new StatUnitItem("₹5.2 Cr+",
                "Disbursed", R.drawable.twotone_attach_money_24));
        recyclerItems.add(new StatUnitItem("4,500+",
                "Placed", R.drawable.twotone_work_24));
        recyclerItems.add(new StatUnitItem("12,000+",
                "Courses", R.drawable.twotone_book_24));

        // headers
        recyclerItems.add(
                new ItemSectionHeader(
                        "How BounceNet Works",
                        "Simple steps to start your comeback Journey."
                )
        );
        // 4. How it Works Steps
        recyclerItems.add(new ProcessStepItem(1,
                "Join the Community",
                "Create your profile and become part of supportive network."
        , ContextCompat.getColor(getContext(), R.color.feature_blue)
        ));

        recyclerItems.add(new ProcessStepItem(2,
                "Get Support",
                "Access Financial aid, resources and guidance when you need it"
        ,ContextCompat.getColor(getContext(), R.color.feature_green)
                ));

        recyclerItems.add(new ProcessStepItem(3,
                "Find Opportunities",
                "Let AI match you to jobs and get community referrals.",
                ContextCompat.getColor(getContext(), R.color.bounce_blue_mid)
                ));

        recyclerItems.add(new ProcessStepItem(4,
                "Learn & Grow",
                "Upskill with BounceNet learning Center and get job-ready.",
                ContextCompat.getColor(getContext(), R.color.premium_orange)
                ));

        recyclerItems.add(new ProcessStepItem(5,
                "Bounce Back Stronger",
                "Land your next role and build a better, brighter future.",
                ContextCompat.getColor(getContext(), R.color.feature_purple)
                ));

        recyclerItems.add(new ItemSectionHeader("Real People. Real Comebacks",
                    "Stories from Our Community that inspires us."
                ));

        recyclerItems.add(
                new LandingFooterHeroSectionItem()
        );

        // 5. Footer
        recyclerItems.add(new FooterItem());*/

        //genericAdapter.submitList(recyclerItems);
    }
}