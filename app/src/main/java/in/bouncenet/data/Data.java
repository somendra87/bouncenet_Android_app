package in.bouncenet.data;

import android.content.Context;

import androidx.core.content.ContextCompat;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import in.bouncenet.R;
import in.bouncenet.items.FeatureItem;
import in.bouncenet.models.UpcomingInterviewModel;
import in.bouncenet.items.YourProgressItem;

public class Data {

    @NotNull
    public static List<FeatureItem> getFeatureItemData(Context context) {
        List<FeatureItem> featureItemsList = new ArrayList<>();
        featureItemsList.add(new FeatureItem(R.drawable.outline_attach_money_24,
                "Financial Support", "Community Fund", "Apply Now",
                ContextCompat.getColor(context, R.color.feature_green),
                ContextCompat.getColor(context, R.color.feature_green_bg),
                ContextCompat.getColor(context, R.color.feature_green_bg)
        ));
        featureItemsList.add(new FeatureItem(R.drawable.outline_contract_24,
                "Find Jobs", "AI Matches", "Explore",
                ContextCompat.getColor(context, R.color.feature_purple),
                ContextCompat.getColor(context, R.color.feature_purple_bg),
                ContextCompat.getColor(context, R.color.feature_purple_bg)
        ));
        featureItemsList.add(new FeatureItem(R.drawable.outline_book_4_24,
                "Learning", "Upskill Center", "Start",
                ContextCompat.getColor(context, R.color.feature_orange),
                ContextCompat.getColor(context, R.color.feature_orange_bg),
                ContextCompat.getColor(context, R.color.feature_orange_bg)
        ));
        featureItemsList.add(new FeatureItem(R.drawable.outline_handshake_24,
                "Community", "Peer Support", "Join",
                ContextCompat.getColor(context, R.color.feature_blue),
                ContextCompat.getColor(context, R.color.feature_blue_bg),
                ContextCompat.getColor(context, R.color.feature_blue_bg)
        ));
        return featureItemsList;
    }

    @NotNull
    public static List<YourProgressItem> getYourProgressItemData(Context context){
        List<YourProgressItem> yourProgressItems = new ArrayList<>();
        yourProgressItems.add(new YourProgressItem("Applications",
                "12",
                "6 Active 10 Inact.",
                ContextCompat.getColor(context, R.color.success_green)));

        yourProgressItems.add(new YourProgressItem("Courses",
                "12",
                "6 Active 10 Inact.",
                ContextCompat.getColor(context, R.color.success_green)));

        yourProgressItems.add(new YourProgressItem("Support",
                "12",
                "6 Active 10 Inact.",
                ContextCompat.getColor(context, R.color.success_green)));

        yourProgressItems.add(new YourProgressItem("Live Support",
                "12",
                "6 Active 10 Inact.",
                ContextCompat.getColor(context, R.color.success_green)));

        yourProgressItems.add(new YourProgressItem("Profile Completed",
                "12",
                "6 Active 10 Inact.",
                ContextCompat.getColor(context, R.color.success_green)));

        return yourProgressItems;
    }

    public static List<UpcomingInterviewModel> getUpcomingInterviews(){
        List<UpcomingInterviewModel> items =
                new ArrayList<>();

        items.add(
                new UpcomingInterviewModel(
                        "MAY",
                        "10",
                        "Product Analyst",
                        "Innovatech Pvt. Ltd.",
                        "11:00 AM — Round 1",
                        "Online"
                )
        );

        items.add(
                new UpcomingInterviewModel(
                        "MAY",
                        "14",
                        "Backend Engineer",
                        "Finverse Technologies",
                        "02:30 PM — Technical",
                        "Offline"
                )
        );
        return items;
    }
}
