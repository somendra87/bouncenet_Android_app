package in.bouncenet.activities;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import in.bouncenet.R;

public class BounceNetSplashActivity extends AppCompatActivity {
    ImageView logo;
    TextView bnTxtLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bounce_net_splash);

        initViews();

        Animation bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        logo.startAnimation(bounceAnimation);

        // ============================================
        // TEXT APPEAR DELAY
        // ============================================

        new Handler(Looper.getMainLooper())
                .postDelayed(
                        this::animateBounceNetText,
                        500
                );

        /*// Move to main activity after 2.5 seconds
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(BounceNetSplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }, 2500);*/
    }

    private void initViews() {
        logo = findViewById(R.id.bnSplashLogo);
        bnTxtLogo = findViewById(R.id.bnTxtLogo);
    }

    private void animateBounceNetText() {
        bnTxtLogo.setVisibility(VISIBLE);
        bnTxtLogo.setAlpha(0f);
        bnTxtLogo.setTranslationY(30f);
        bnTxtLogo.animate().alpha(1f)
                .translationY(0f)
                .setDuration(700)
                .setInterpolator(
                        new AccelerateDecelerateInterpolator()
                )
                .start();

        String text = "BounceNet";

        Handler handler = new Handler(Looper.getMainLooper());
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int index = i;

            handler.postDelayed(() -> {
                builder.append(text.charAt(index));
                bnTxtLogo.setText(builder.toString());
                applyGradientToLogoText();

            }, i * 120L);
        }


        // ============================================
        // NAVIGATE TO LANDING PAGE
        // ============================================

        handler.postDelayed(() -> {
            Intent intent =
                    new Intent(
                            BounceNetSplashActivity.this,
                            MainActivity.class
                    );
            startActivity(intent);
            overridePendingTransition(
                    android.R.anim.fade_in,
                    android.R.anim.fade_out
            );
            finish();
        }, 3200);
    }

    private void applyGradientToLogoText() {

        bnTxtLogo.post(() -> {

            float width =
                    bnTxtLogo.getPaint()
                            .measureText("BounceNet");

            Shader textShader =
                    new LinearGradient(
                            0,
                            0,
                            width,
                            bnTxtLogo.getTextSize(),

                            new int[]{
                                    getColor(R.color.bounce_blue_start),
                                    getColor(R.color.bounce_purple),
                                    getColor(R.color.forward_orange)
                            },

                            null,

                            Shader.TileMode.CLAMP
                    );

            bnTxtLogo.getPaint()
                    .setShader(textShader);

            bnTxtLogo.invalidate();
        });
    }
}