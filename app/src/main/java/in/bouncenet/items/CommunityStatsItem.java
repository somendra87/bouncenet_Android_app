package in.bouncenet.items;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;

public class CommunityStatsItem implements BaseRecyclerItem {
    @Override
    public int getLayoutResourceId() {
        return R.layout.item_commonity_stats;
    }

    @Override
    public void bind(View itemView) {
        TextView tvMemberCount = itemView.findViewById(R.id.tvMembersCount);

        // Counter animation
        startCounterAnimation(tvMemberCount, 8200, 10000, 2200);

        // profile picture setup glow and overlap
        setProfiles(itemView);

    }

    private void setProfiles(View itemView) {
        CircleImageView firstProfile = itemView.findViewById(R.id.profilePictureFirst);
        CircleImageView secondProfile = itemView.findViewById(R.id.profilePictureSecond);
        CircleImageView thirdProfile = itemView.findViewById(R.id.profilePictureThird);

        // Apply glow + entrance animation
        animateProfileWithGlow(firstProfile, 0);
        animateProfileWithGlow(secondProfile, 180);
        animateProfileWithGlow(thirdProfile, 360);
    }

    private void animateProfileWithGlow(CircleImageView imageView, long delay) {
        if (imageView == null) return;

        // Initial state
        imageView.setScaleX(0.75f);
        imageView.setScaleY(0.75f);
        imageView.setElevation(12f);

        // Glow + pop animation
        imageView.animate()
                .scaleX(1.08f)
                .scaleY(1.08f)
                .setDuration(950)
                .setStartDelay(delay)
                .setInterpolator(new OvershootInterpolator(1.8f))
                .withEndAction(() -> {
                    imageView.animate()
                            .scaleX(1f)
                            .scaleY(1f)
                            .setDuration(650)
                            .start();
                })
                .start();
    }

    private void startCounterAnimation(TextView tvMemberCount, int start, int end, int duration) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(start, end);
        valueAnimator.setDuration(duration);
        valueAnimator.setInterpolator(new DecelerateInterpolator(1.5f));

        valueAnimator.addUpdateListener(animation -> {
            int animatedValue = (int) animation.getAnimatedValue();
            tvMemberCount.setText(String.format("%,d+ members", animatedValue));
        });
        valueAnimator.start();
    }

    @Override
    public Object getUniqueId() {
        return null;
    }
}
