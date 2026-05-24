package in.bouncenet.items;

import android.view.View;

import androidx.core.content.ContextCompat;

import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;
import in.bouncenet.common.views.ActionCardView;
import in.bouncenet.models.ActionCardModel;

public class ActionCardItem implements BaseRecyclerItem {

    private final String actionCardTitle;
    private final String actionCardSubTitle;
    private final String actionCardButton;

    public ActionCardItem(String actionCardTitle, String actionCardSubTitle, String actionCardButton) {
        this.actionCardTitle = actionCardTitle;
        this.actionCardSubTitle = actionCardSubTitle;
        this.actionCardButton = actionCardButton;
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.view_action_card;
    }

    @Override
    public void bind(View itemView) {
        ActionCardView cardView = (ActionCardView) itemView;
        cardView.setData(new ActionCardModel(actionCardTitle, actionCardSubTitle, actionCardButton,
                ContextCompat.getColor(itemView.getContext(), R.color.primary_blue), null));
    }

    @Override
    public Object getUniqueId() {
        return "BOTTOM_CTA";
    }
}
