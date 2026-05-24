package in.bouncenet.enums;

import in.bouncenet.R;

public enum PlanType {

    SILVER("Silver", R.color.silver_plan, R.color.silver_plan_bg),
    GOLD("Gold", R.color.gold_plan, R.color.gold_plan_bg),
    DIAMOND("Diamond", R.color.diamond_plan, R.color.diamond_plan_bg);

    private final String displayName;
    private final int accentColor;

    private final int planTypelabelBgColor;

    PlanType(String displayName, int accentColor, int planTypelabelBgColor) {
        this.displayName = displayName;
        this.accentColor = accentColor;
        this.planTypelabelBgColor = planTypelabelBgColor;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getAccentColor() {
        return accentColor;
    }

    public int getPlanTypelabelBgColor(){
        return planTypelabelBgColor;
    }
}
