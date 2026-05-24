package in.bouncenet.models;

public class PremiumUpgrade {
    private final String premiumUpgradeTitle;
    private final String premiumUpgradeDescription;
    private final String premiumUpgradeActionText;

    public PremiumUpgrade(String premiumUpgradeTitle, String premiumUpgradeDescription, String premiumUpgradeActionText) {
        this.premiumUpgradeTitle = premiumUpgradeTitle;
        this.premiumUpgradeDescription = premiumUpgradeDescription;
        this.premiumUpgradeActionText = premiumUpgradeActionText;
    }

    public String getPremiumUpgradeTitle() {
        return premiumUpgradeTitle;
    }

    public String getPremiumUpgradeDescription() {
        return premiumUpgradeDescription;
    }

    public String getPremiumUpgradeActionText() {
        return premiumUpgradeActionText;
    }
}
