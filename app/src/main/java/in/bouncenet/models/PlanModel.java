package in.bouncenet.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.math.BigDecimal;
import java.util.List;

import in.bouncenet.enums.PlanType;
import in.bouncenet.viewmodel.PlanFeature;

public record PlanModel(
        PlanType planType,
        String tagLine,
        boolean isPopular,
        List<String> planFeatures,
        String planPrice,
        String billingCycle
) {
}
