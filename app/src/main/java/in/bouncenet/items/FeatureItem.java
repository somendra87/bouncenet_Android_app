package in.bouncenet.items;

public class FeatureItem {

    private int iconResId;
    private String title;
    private String subTitle;
    private String actionText;

    private int iconTintColor;
    private int iconBackgroundColor;
    private int actionBackGroundColor;

    public FeatureItem(int iconResId,
                       String title,
                       String subTitle,
                       String actionText,
                       int iconTintColor,
                       int iconBackgroundColor,
                       int actionBackGroundColor) {
        this.iconResId = iconResId;
        this.title = title;
        this.subTitle = subTitle;
        this.actionText = actionText;
        this.iconTintColor = iconTintColor;
        this.iconBackgroundColor = iconBackgroundColor;
        this.actionBackGroundColor = actionBackGroundColor;
    }

    public FeatureItem(int iconResId, String title, String subTitle, String actionText) {
        this.iconResId = iconResId;
        this.title = title;
        this.subTitle = subTitle;
        this.actionText = actionText;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getActionText() {
        return actionText;
    }

    public void setActionText(String actionText) {
        this.actionText = actionText;
    }

    public int getIconTintColor() {
        return iconTintColor;
    }

    public void setIconTintColor(int iconTintColor) {
        this.iconTintColor = iconTintColor;
    }

    public int getIconBackgroundColor() {
        return iconBackgroundColor;
    }

    public void setIconBackgroundColor(int iconBackgroundColor) {
        this.iconBackgroundColor = iconBackgroundColor;
    }

    public int getActionBackGroundColor() {
        return actionBackGroundColor;
    }

    public void setActionBackGroundColor(int actionBackGroundColor) {
        this.actionBackGroundColor = actionBackGroundColor;
    }
}
