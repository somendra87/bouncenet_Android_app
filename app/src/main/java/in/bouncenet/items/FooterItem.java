package in.bouncenet.items;

import android.view.View;

import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;

public class FooterItem implements BaseRecyclerItem {
    @Override
    public int getLayoutResourceId() {
        return R.layout.item_landing_footer;
    }

    @Override
    public void bind(View itemView) {
    }

    @Override
    public Object getUniqueId() {
        return "LANDING_FOOT";
    }
}
