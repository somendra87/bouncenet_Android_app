package in.bouncenet.items;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;

public class StatUnitItem implements BaseRecyclerItem {
    private final String value, label;
    private final int iconRes;

    public StatUnitItem(String value, String label, int iconRes) {
        this.value = value;
        this.label = label;
        this.iconRes = iconRes;
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.item_stat_unit;
    }

    @Override
    public void bind(View itemView) {
        ((TextView) itemView.findViewById(R.id.txtStatValue)).setText(value);
        ((TextView) itemView.findViewById(R.id.txtStatLabel)).setText(label);
        ((ImageView) itemView.findViewById(R.id.statIcon)).setImageResource(iconRes);
    }

    @Override
    public Object getUniqueId() {
        return label;
    }

}

