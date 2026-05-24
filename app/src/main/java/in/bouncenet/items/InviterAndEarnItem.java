package in.bouncenet.items;

import static android.widget.Toast.makeText;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;
import kotlinx.serialization.descriptors.PrimitiveKind;

public class InviterAndEarnItem implements BaseRecyclerItem {
    @Override
    public int getLayoutResourceId() {
        return R.layout.item_invite_earn;
    }

    @Override
    public void bind(View itemView) {
        TextView tvGetLink = itemView.findViewById(R.id.inviteAndEarnReferralLink);

        tvGetLink.setOnClickListener(v -> {
            makeText(itemView.getContext(),
                    "Share Link Coming Soon", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public Object getUniqueId() {
        return "INVITE_AND_EARN";
    }
}
