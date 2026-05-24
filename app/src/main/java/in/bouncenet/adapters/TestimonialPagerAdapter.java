package in.bouncenet.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.bouncenet.R;
import in.bouncenet.models.LandingPageTestimonialModel;

public class TestimonialPagerAdapter extends RecyclerView.Adapter<TestimonialPagerAdapter.ViewHolder> {

    private List<LandingPageTestimonialModel> testimonials;

    public TestimonialPagerAdapter(List<LandingPageTestimonialModel> testimonials) {
        this.testimonials = testimonials;
    }


    @NonNull
    @Override
    public TestimonialPagerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_testimonial_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestimonialPagerAdapter.ViewHolder holder, int position) {
        LandingPageTestimonialModel item = testimonials.get(position);

        holder.testimonialDescription.setText(item.testimonialDescription());
        holder.nameOfMember.setText(item.nameOfMember());
        holder.designationOfMember.setText(item.designationOfMember());
        holder.profileImage.setImageResource(item.imageResourceId());
    }

    @Override
    public int getItemCount() {
        return testimonials.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView testimonialDescription, nameOfMember, designationOfMember;
        ImageView profileImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            testimonialDescription = itemView.findViewById(R.id.textTestimonialDescription);
            nameOfMember = itemView.findViewById(R.id.nameOfMember);
            designationOfMember = itemView.findViewById(R.id.memberDesignation);
            profileImage = itemView.findViewById(R.id.testimonialCardImageView);
        }
    }
}
