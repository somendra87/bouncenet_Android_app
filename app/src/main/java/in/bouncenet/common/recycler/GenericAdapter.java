package in.bouncenet.common.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class GenericAdapter extends ListAdapter<BaseRecyclerItem, GenericAdapter.ViewHolder> {

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    protected GenericAdapter(@NonNull DiffUtil.ItemCallback<BaseRecyclerItem> diffCallback) {
        super(diffCallback);
    }

    protected GenericAdapter(@NonNull AsyncDifferConfig<BaseRecyclerItem> config) {
        super(config);
    }

    public GenericAdapter() {
        super(new DiffCallback());
    }

    @Override
    public int getItemViewType(int position) {
        // gets layout res id from BaseRecyclerItem
        return getItem(position).getLayoutResourceId();
    }

    @NonNull
    @Override
    public GenericAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericAdapter.ViewHolder holder, int position) {
        BaseRecyclerItem item = getItem(position);
        item.bind(holder.itemView);

        // click support
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null){
                onItemClickListener.onItemClick(position);
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private static class DiffCallback extends DiffUtil.ItemCallback<BaseRecyclerItem> {
        @Override
        public boolean areItemsTheSame(
                @NonNull BaseRecyclerItem oldRecyclerItem,
                @NonNull BaseRecyclerItem newRecyclerItem
        ) {
            return Objects.equals(oldRecyclerItem.getUniqueId(), newRecyclerItem.getUniqueId());
        }

        @Override
        public boolean areContentsTheSame(
                @NonNull BaseRecyclerItem oldRecyclerItem,
                @NonNull BaseRecyclerItem newRecyclerItem
        ) {
            return Objects.equals(oldRecyclerItem, newRecyclerItem);
        }
    }

    // Add this inside GenericAdapter.java
    public BaseRecyclerItem getItemAt(int position) {
        return getItem(position);
    }

}
