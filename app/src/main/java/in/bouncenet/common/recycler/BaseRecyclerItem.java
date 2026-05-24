package in.bouncenet.common.recycler;

import android.view.View;

public interface BaseRecyclerItem {

    // which layout to inflate
    int getLayoutResourceId();

    // How to set data
    void bind(View itemView);

    // For list animation
    Object getUniqueId();
}
