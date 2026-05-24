package in.bouncenet.viewmodel;

import android.graphics.Color;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;
import in.bouncenet.items.CommunityStatsItem;
import in.bouncenet.items.FooterItem;
import in.bouncenet.items.ItemSectionHeader;
import in.bouncenet.items.LandingFooterHeroSectionItem;
import in.bouncenet.items.LandingHeroExtendedItem;
import in.bouncenet.items.LandingHeroItem;
import in.bouncenet.items.MarketingFeatureItem;
import in.bouncenet.items.ProcessStepItem;
import in.bouncenet.items.StatUnitItem;
import in.bouncenet.items.TestimonialSectionItem;
import in.bouncenet.models.LandingPageTestimonialModel;

public class LandingViewModel extends ViewModel {
    public static final String TESTIMONIAL_DESCRIPTION = "BounceNet helped me to stay afloat financially and the community referral got me my dream job";
    private final MutableLiveData<List<BaseRecyclerItem>> items =
            new MutableLiveData<>();

    public LiveData<List<BaseRecyclerItem>> getLandingPageItems(){
        return items;
    }

    public void loadData(){
        List<BaseRecyclerItem> recyclerItems = new ArrayList<>();
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
                R.drawable.twotone_money_24, R.color.feature_green));
        recyclerItems.add(new MarketingFeatureItem(
                "2. Get Your Next Job",
                "AI powered matching...",
                "✓ Bullet 1\n✓ Bullet 2",
                "EXPLORE",
                R.drawable.twotone_workspaces_24, R.color.feature_blue));

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
                , R.color.feature_blue)
        );

        recyclerItems.add(new ProcessStepItem(2,
                "Get Support",
                "Access Financial aid, resources and guidance when you need it"
                , R.color.feature_green)
        );

        recyclerItems.add(new ProcessStepItem(3,
                "Find Opportunities",
                "Let AI match you to jobs and get community referrals."
                , R.color.bounce_blue_mid)
        );

        recyclerItems.add(new ProcessStepItem(4,
                "Learn & Grow",
                "Upskill with BounceNet learning Center and get job-ready."
                , R.color.premium_orange)
        );

        recyclerItems.add(new ProcessStepItem(5,
                "Bounce Back Stronger",
                "Land your next role and build a better, brighter future."
                , R.color.feature_purple)
        );

        recyclerItems.add(new ItemSectionHeader("Real People. Real Comebacks",
                "Stories from Our Community that inspires us."
        ));


        // Testimonial view pager
        List<LandingPageTestimonialModel> testimonialModelList = Arrays.asList(
                new LandingPageTestimonialModel(
                        TESTIMONIAL_DESCRIPTION,
                        "Sarah Smith", "Product Manager"
                        , R.drawable.happy_woman_image_no_bg),

                new LandingPageTestimonialModel(
                        TESTIMONIAL_DESCRIPTION,
                        "Rahul K", "Software Architect"
                        , R.drawable.happy_woman_image_no_bg),

                new LandingPageTestimonialModel(
                        TESTIMONIAL_DESCRIPTION,
                        "Emily Clark", "AI Champion"
                        , R.drawable.happy_woman_image_no_bg)

        );
        recyclerItems.add(new TestimonialSectionItem(testimonialModelList));


        // footer hero section
        recyclerItems.add(
                new LandingFooterHeroSectionItem()
        );

        // Footer
        recyclerItems.add(new FooterItem());

        this.items.setValue(recyclerItems);
    }
}

