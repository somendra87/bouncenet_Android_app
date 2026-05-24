package in.bouncenet.fragments.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import in.bouncenet.R;
import in.bouncenet.adapters.FeatureAdapter;
import in.bouncenet.common.views.ActionCardView;
import in.bouncenet.containers.PremiumUpgradeContainer;
import in.bouncenet.containers.ProfileCompletenessContainer;
import in.bouncenet.containers.ProgressSectionContainer;
import in.bouncenet.containers.UpcomingInterviewsContainer;
import in.bouncenet.data.Data;
import in.bouncenet.models.ActionCardModel;
import in.bouncenet.items.FeatureItem;
import in.bouncenet.models.PremiumUpgrade;
import in.bouncenet.models.ProfileCompleteness;
import in.bouncenet.items.YourProgressItem;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private RecyclerView featureItemRecycler;

    private ProgressSectionContainer progressSectionContainer;

    private ProfileCompletenessContainer profileCompletenessContainer;
    private PremiumUpgradeContainer premiumUpgradeContainer;

    private UpcomingInterviewsContainer upcomingInterviewsContainer;

    private ActionCardView profileActionCard;
    private ActionCardView premiumActionCard;

    public HomeFragment(){}

    @Override
    @Nullable
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ){
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initViews(view);
        setUpFeatureItemsRecyclerView();
        setUpProgressSection();
        setUpProfileCompletenessSection();
        setUpPremiumUpgradeSection();
        setUpUpcomingInterviewSection();
        setUpActionCards();
        return view;
    }

    private void setUpActionCards() {
        // 1. Setup Profile Card (With Progress)
        ActionCardModel profileData = new ActionCardModel(
                "Profile Completeness",
                "Complete your profile to unlock new opportunities",
                "Complete Now →",
                ContextCompat.getColor(getContext(), R.color.primary_blue),
                75 // The progress percentage
        );
        profileActionCard.setData(profileData);

        // 2. Setup Premium Card (No Progress)
        ActionCardModel premiumData = new ActionCardModel(
                "Unlock BouncePlus",
                "Get AI Auto-Apply and mentor support",
                "Upgrade Now →",
                ContextCompat.getColor(getContext(), R.color.premium_navy),
                null // Passing null hides the progress bar automatically
        );
        premiumActionCard.setData(premiumData);
    }

    private void setUpUpcomingInterviewSection() {
        upcomingInterviewsContainer.setUpcomingInterviewsItems(Data.getUpcomingInterviews());
    }

    private void setUpPremiumUpgradeSection() {
        premiumUpgradeContainer.setData(
                new PremiumUpgrade(
                        "Unlock new opportunities!",
                        "Upgrade to BouncePlus and get AI Auto-Apply, mentor support and faster referal",
                        "Upgrade Now →"
                )
        );
    }

    private void setUpProfileCompletenessSection() {
        profileCompletenessContainer.setData(new ProfileCompleteness(81,
                "Profile Completeness",
                "Complete your profile to unlock new opportunities",
                "Complete Now →"
                ));
    }


    private void setUpFeatureItemsRecyclerView() {
        List<FeatureItem> featureItemsList = Data.getFeatureItemData(getContext());
        FeatureAdapter featureAdapter = new FeatureAdapter(featureItemsList);
        featureItemRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        featureItemRecycler.setAdapter(featureAdapter);
    }


    private void setUpProgressSection() {
        List<YourProgressItem> items = Data.getYourProgressItemData(requireContext());
        System.out.println("Progress Items : " + items);
        progressSectionContainer.setProgressItems(items);

    }

    private void initViews(View view) {
        profileActionCard = view.findViewById(R.id.profileActionCard);
        premiumActionCard = view.findViewById(R.id.premiumActionCard);

        featureItemRecycler = view.findViewById(R.id.featureItemsRecyclerView);
        progressSectionContainer = view.findViewById(R.id.progressSectionViewContainer);
        profileCompletenessContainer = view.findViewById(R.id.profileCompletenessContainer);
        premiumUpgradeContainer = view.findViewById(R.id.premiumUpgradeContainer);
        upcomingInterviewsContainer = view.findViewById(R.id.upcomingInterviewContainer);
    }

}