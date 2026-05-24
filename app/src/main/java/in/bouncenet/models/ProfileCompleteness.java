package in.bouncenet.models;

public class ProfileCompleteness {
    private final int progress;
    private final String profileCompletenessTitle;
    private final String profileCompletenessDescription;
    private final String profileCompletenessActionText;

    public ProfileCompleteness(int progress, String profileCompletenessTitle, String profileCompletenessDescription, String profileCompletenessActionText) {
        this.progress = progress;
        this.profileCompletenessTitle = profileCompletenessTitle;
        this.profileCompletenessDescription = profileCompletenessDescription;
        this.profileCompletenessActionText = profileCompletenessActionText;
    }

    public int getProgress() {
        return progress;
    }

    public String getProfileCompletenessTitle() {
        return profileCompletenessTitle;
    }

    public String getProfileCompletenessDescription() {
        return profileCompletenessDescription;
    }

    public String getProfileCompletenessActionText() {
        return profileCompletenessActionText;
    }
}
