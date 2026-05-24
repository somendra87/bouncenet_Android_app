package in.bouncenet.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.bouncenet.R;
import in.bouncenet.items.YourProgressItem;

public class YourProgressAdapter
        extends RecyclerView.Adapter<YourProgressAdapter.YourProgressViewHolder> {

    private final List<YourProgressItem> items;

    public YourProgressAdapter(List<YourProgressItem> items) {
        System.out.println("Items set in your progress adapter" + items);
        this.items = items;
    }

    @NonNull
    @Override
    public YourProgressAdapter.YourProgressViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(
                        R.layout.item_your_progress_card, parent, false);
        return new YourProgressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YourProgressAdapter.YourProgressViewHolder holder,
                                 int position) {
        YourProgressItem item = items.get(position);
        holder.yourProgressTitleTextView.setText(item.getYourProgressTitle());
        holder.yourProgressSubTitleTextView.setText(item.getYourProgressSubTitle());
        holder.yourProgressMainValueTextView.setText(item.getYouProgressMainValue());
        holder.yourProgressMainValueTextView.setTextColor(item.getValueColor());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class YourProgressViewHolder extends RecyclerView.ViewHolder{
        private final TextView yourProgressTitleTextView;
        private final TextView yourProgressSubTitleTextView;
        private final TextView yourProgressMainValueTextView;

        public YourProgressViewHolder(@NonNull View itemView) {
            super(itemView);
            yourProgressTitleTextView =
                    itemView.findViewById(R.id.yourProgressCardTitle);
            yourProgressSubTitleTextView =
                    itemView.findViewById(R.id.yourProgressCardSubTitle);
            yourProgressMainValueTextView =
                    itemView.findViewById(R.id.yourProgressCardMainValue);
        }

    }
}
