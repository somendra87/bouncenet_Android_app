package in.bouncenet.items;

import android.view.View;

import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

import in.bouncenet.R;
import in.bouncenet.adapters.TestimonialPagerAdapter;
import in.bouncenet.common.recycler.BaseRecyclerItem;
import in.bouncenet.models.LandingPageTestimonialModel;

public class TestimonialSectionItem implements BaseRecyclerItem {

    private List<LandingPageTestimonialModel> testimonials;

    public TestimonialSectionItem(List<LandingPageTestimonialModel> testimonials) {
        this.testimonials = testimonials;
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.item_testimonial_corousel;
    }

    @Override
    public void bind(View itemView) {
        ViewPager2 viewPager2 = itemView.findViewById(R.id.testimonialViewPager);
        TabLayout dots = itemView.findViewById(R.id.dotsIndicatorViewPager);

        // Set the adapter for horizontal scrolling
        TestimonialPagerAdapter adapter = new TestimonialPagerAdapter(testimonials);
        viewPager2.setAdapter(adapter);

        // setup dots indicator
        new TabLayoutMediator(dots, viewPager2, (tab, position) -> {}).attach();

        // Configuring viewpager for peaking effect
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);

        // adding transformer for spacing and scaling animation
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();

        // add spaces between pages
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));

        // adding scaling effect (side cards appear slightly smaller)
        compositePageTransformer.addTransformer((page, position) ->{
            float r = 1 - Math.abs(position);
            page.setScaleX(0.85f + r * 0.15f);
        });

        viewPager2.setPageTransformer(compositePageTransformer);
    }

    @Override
    public Object getUniqueId() {
        return "TESTIMONIAL_SECTION_" + testimonials.hashCode();
    }
}
