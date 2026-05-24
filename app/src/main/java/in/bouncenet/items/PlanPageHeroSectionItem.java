package in.bouncenet.items;

import android.view.View;

import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;

public class PlanPageHeroSectionItem implements BaseRecyclerItem {
    @Override
    public int getLayoutResourceId() {
        return R.layout.item_plan_hero_section;
    }

    @Override
    public void bind(View itemView) {

    }

    @Override
    public Object getUniqueId() {
        return "PLAN_PAGE_HERO_SECTION";
    }
}
