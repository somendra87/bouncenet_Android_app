package in.bouncenet.items;

import static in.bouncenet.helpers.BnHelper.resolvedColor;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;

import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;

public class ProcessStepItem implements BaseRecyclerItem {

    private final int stepNumber;
    private final String stepTitle;
    private final String stepDescription;

    private final int bgColorForStepNumber;

    public ProcessStepItem(int stepNumber,
                           String stepTitle,
                           String stepDescription,
                           int bgColorForStepNumber) {
        this.stepNumber = stepNumber;
        this.stepTitle = stepTitle;
        this.stepDescription = stepDescription;
        this.bgColorForStepNumber = bgColorForStepNumber;
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.item_process_step;
    }

    @Override
    public void bind(View itemView) {
        TextView stepNumberTv = itemView.findViewById(R.id.txtStepNum);
        TextView stepTitleTv = itemView.findViewById(R.id.txtStepTitle);
        TextView stepDescTv = itemView.findViewById(R.id.txtStepDesc);

        stepNumberTv.setText(String.valueOf(stepNumber));
        stepNumberTv.setBackgroundTintList(
                ColorStateList.valueOf(resolvedColor(itemView, bgColorForStepNumber)));
        stepTitleTv.setText(stepTitle);
        stepDescTv.setText(stepDescription);

    }

    @Override
    public Object getUniqueId() {
        return "STEP_" + stepNumber;
    }
}
