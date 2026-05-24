package in.bouncenet.adapters;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

import in.bouncenet.R;
import in.bouncenet.items.FeatureItem;

public class FeatureAdapter extends RecyclerView.Adapter<FeatureAdapter.FeatureViewHolder> {

    private List<FeatureItem> items;

    public FeatureAdapter(List<FeatureItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public FeatureAdapter.FeatureViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_feature_card_layout, parent, false);

        return new FeatureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeatureAdapter.FeatureViewHolder holder, int position) {
        FeatureItem item = items.get(position);
        holder.featureImageView.setImageResource(item.getIconResId());
        holder.featureTxtTitle.setText(item.getTitle());
        holder.featuretxtSubTitle.setText(item.getSubTitle());
        holder.txtAction.setText(item.getActionText());
        holder.featureImageView.setColorFilter(item.getIconTintColor());
        holder.iconContainer.setBackgroundTintList(
                ColorStateList.valueOf(item.getIconBackgroundColor())
        );
        holder.txtAction.setBackgroundTintList(
                ColorStateList.valueOf(item.getActionBackGroundColor())
        );
        holder.txtAction.setTextColor(item.getIconTintColor());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class FeatureViewHolder extends RecyclerView.ViewHolder{

        private final MaterialCardView cardView;
        private final FrameLayout iconContainer;
        private final ImageView featureImageView;
        private final TextView featureTxtTitle;
        private final TextView featuretxtSubTitle;
        private final TextView txtAction;

        public FeatureViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.featureCardView);
            iconContainer = itemView.findViewById(R.id.featureItemIconContainer);
            featureImageView = itemView.findViewById(R.id.featureItemIconContainerImageView);
            featureTxtTitle = itemView.findViewById(R.id.txtFeatureTitle);
            featuretxtSubTitle = itemView.findViewById(R.id.txtFeatureSubTitle);
            txtAction = itemView.findViewById(R.id.txtAction);
        }
    }
}
