package in.bouncenet.containers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.bouncenet.R;
import in.bouncenet.adapters.UpcomingInterviewAdapter;
import in.bouncenet.models.UpcomingInterviewModel;

public class UpcomingInterviewsContainer extends ConstraintLayout {

    private RecyclerView upcomingInterviewRecycler;

    public UpcomingInterviewsContainer(@NonNull Context context) {
        super(context);
        init(context);
    }

    public UpcomingInterviewsContainer(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public UpcomingInterviewsContainer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context)
                .inflate(
                        R.layout.view_upcoming_interviews_section,
                        this
                        , true);
        initViews(context);
    }

    private void initViews(Context context) {
        upcomingInterviewRecycler = findViewById(R.id.upcomingInterviewRecyclerView);
        upcomingInterviewRecycler.setLayoutManager(new LinearLayoutManager(context));
    }


    public void setUpcomingInterviewsItems(List<UpcomingInterviewModel> upcomingInterviewsItems){
        UpcomingInterviewAdapter upcomingInterviewAdapter =
                new UpcomingInterviewAdapter(upcomingInterviewsItems);
        upcomingInterviewRecycler.setAdapter(upcomingInterviewAdapter);
    }
}
