package in.bouncenet.items;

import android.view.View;

import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;
import in.bouncenet.common.views.GlobalTopBarView;

public class GlobalTopBarItem implements BaseRecyclerItem {

    private final String primary;
    private final String secondary;

    public GlobalTopBarItem(String primary, String secondary) {
        this.primary = primary;
        this.secondary = secondary;
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.view_global_top_bar;
    }

    @Override
    public void bind(View itemView) {
        GlobalTopBarView topBarView = (GlobalTopBarView) itemView;
        topBarView.setBrandMode(primary, secondary);
    }

    @Override
    public Object getUniqueId() {
        return "TOP_BAR";
    }
}
