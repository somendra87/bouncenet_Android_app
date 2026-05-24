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
import in.bouncenet.adapters.YourProgressAdapter;
import in.bouncenet.items.YourProgressItem;

public class ProgressSectionContainer extends ConstraintLayout {

    private RecyclerView progressRecyclerView;

    public ProgressSectionContainer(@NonNull Context context) {
        super(context);
        init(context);
    }

    public ProgressSectionContainer(@NonNull Context context,
                                    @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ProgressSectionContainer(@NonNull Context context,
                                    @Nullable AttributeSet attrs,
                                    int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context)
                .inflate(
                        R.layout.view_progress_section,this, true);

        progressRecyclerView = findViewById(R.id.progressSectionRecycler);

        progressRecyclerView.setLayoutManager(
                new LinearLayoutManager(context,
                        LinearLayoutManager.HORIZONTAL, false));
    }


    public void setProgressItems(List<YourProgressItem> items){
        YourProgressAdapter adapter = new YourProgressAdapter(items);
        progressRecyclerView.setAdapter(adapter);
    }
}
