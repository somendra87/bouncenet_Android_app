package in.bouncenet.common.views;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

import android.content.Context;
import android.se.omapi.Session;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.gson.Gson;

import in.bouncenet.R;
import in.bouncenet.backendintegration.dtos.AuthResponseDto;
import in.bouncenet.backendintegration.dtos.MemberResponseDto;
import in.bouncenet.fragments.account.SessionManager;

public class HeroBannerView extends ConstraintLayout {
    private static final String HOME_BANNER_OP = "HOME_BANNER_VIEW_OP";
    private TextView heroWelcomeTitle;

    public HeroBannerView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public HeroBannerView(@NonNull Context context,
                          @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public HeroBannerView(@NonNull Context context,
                          @Nullable AttributeSet attrs,
                          int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        LayoutInflater.from(context)
                .inflate(R.layout.view_hero_banner, this, true);
        heroWelcomeTitle = findViewById(R.id.txtWelcomeTitle);
        AuthResponseDto tokenFromSession =
                SessionManager.getInstance(context).getTokenFromSession();
        String firstName = tokenFromSession.member().firstName();

        Log.i(HOME_BANNER_OP, "First Name " + firstName);
        heroWelcomeTitle.setText("Welcome !!" + firstName + "👋");
        makeText(context, "Welcome " + firstName + "👋", LENGTH_SHORT).show();

    }
}
