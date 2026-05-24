package in.bouncenet.helpers;

import android.view.View;

public class BnHelper {
    public static int resolvedColor(View itemView, int color){
        return androidx.core.content.ContextCompat.getColor(itemView.getContext(), color);
    }
}
