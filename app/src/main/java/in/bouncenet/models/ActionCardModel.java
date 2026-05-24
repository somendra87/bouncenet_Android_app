package in.bouncenet.models;

public class ActionCardModel {
    private final String title;
    private final String subTitle;
    private final String actionText;
    private final int backgroundColor;

    private final Integer progress;



    public ActionCardModel(String title,
                           String subTitle,
                           String actionText,
                           int backgroundColor,
                           Integer progress) {
        this.title = title;
        this.subTitle = subTitle;
        this.actionText = actionText;
        this.backgroundColor = backgroundColor;
        this.progress = progress;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getActionText() {
        return actionText;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public Integer getProgress() {
        return progress;
    }
}
