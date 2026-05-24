package in.bouncenet.items;

import android.view.View;
import android.widget.TextView;

import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;

public class ItemSectionHeader implements BaseRecyclerItem {
    private final String title, description;

    public ItemSectionHeader(String title, String description) {
        this.title = title;
        this.description = description;
    }
    @Override
    public int getLayoutResourceId() {
        return R.layout.item_section_header;
    }

    @Override
    public void bind(View itemView) {
        TextView sectionHeaderTv = itemView.findViewById(R.id.itemSectionHeaderTitle);
        TextView sectionDescriptionTv = itemView.findViewById(R.id.itemSectionHeaderDescription);

        sectionHeaderTv.setText(title);
        sectionDescriptionTv.setText(description);
    }

    @Override
    public Object getUniqueId() {
        return "ITEM_SECTION_HEADER_CONTENT";
    }
}
