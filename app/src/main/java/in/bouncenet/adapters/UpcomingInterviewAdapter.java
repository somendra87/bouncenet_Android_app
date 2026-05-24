package in.bouncenet.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.bouncenet.R;
import in.bouncenet.models.UpcomingInterviewModel;

public class UpcomingInterviewAdapter extends RecyclerView.Adapter<UpcomingInterviewAdapter.UpcomingInterviewViewHolder> {


    private final List<UpcomingInterviewModel> upcomingInterviewModels;

    public UpcomingInterviewAdapter(List<UpcomingInterviewModel> upcomingInterviewModels) {
        this.upcomingInterviewModels = upcomingInterviewModels;
    }


    @NonNull
    @Override
    public UpcomingInterviewAdapter.UpcomingInterviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_upcoming_interview, parent, false);
        return new UpcomingInterviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingInterviewAdapter.UpcomingInterviewViewHolder holder, int position) {
        UpcomingInterviewModel upcomingInterviewModel = upcomingInterviewModels.get(position);
        holder.txtMonth.setText(upcomingInterviewModel.getMonth());
        holder.txtDay.setText(upcomingInterviewModel.getDay());
        holder.txtCompany.setText(upcomingInterviewModel.getCompany());
        holder.txtSchedule.setText(upcomingInterviewModel.getSchedule());
        holder.txtInterviewTitle.setText(upcomingInterviewModel.getTitle());
        holder.statusChip.setText(upcomingInterviewModel.getStatus());
    }

    @Override
    public int getItemCount() {
        return upcomingInterviewModels.size();
    }

    public class UpcomingInterviewViewHolder extends RecyclerView.ViewHolder {

        private final TextView txtMonth;
        private final TextView txtDay;
        private final TextView txtInterviewTitle;
        private final TextView txtCompany;
        private final TextView txtSchedule;
        private final TextView statusChip;

        public UpcomingInterviewViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMonth = itemView.findViewById(R.id.txtMonthTextView);
            txtDay = itemView.findViewById(R.id.txtDayTextView);
            txtInterviewTitle = itemView.findViewById(R.id.txtInterviewTitle);
            txtCompany = itemView.findViewById(R.id.txtCompanyTextView);
            txtSchedule = itemView.findViewById(R.id.txtSchedule);
            statusChip = itemView.findViewById(R.id.statusChip);
        }
    }
}
