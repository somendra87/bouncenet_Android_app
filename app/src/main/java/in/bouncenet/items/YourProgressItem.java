package in.bouncenet.items;

public class YourProgressItem {
    private final String yourProgressTitle;
    private final String youProgressMainValue;
    private final String yourProgressSubTitle;
    private final int valueColor;

    public YourProgressItem(String yourProgressTitle,
                            String youProgressMainValue,
                            String yourProgressSubTitle,
                            int valueColor) {
        this.yourProgressTitle = yourProgressTitle;
        this.youProgressMainValue = youProgressMainValue;
        this.yourProgressSubTitle = yourProgressSubTitle;
        this.valueColor = valueColor;
    }



    public String getYourProgressTitle() {
        return yourProgressTitle;
    }

    public String getYouProgressMainValue() {
        return youProgressMainValue;
    }

    public String getYourProgressSubTitle() {
        return yourProgressSubTitle;
    }

    public int getValueColor() {
        return valueColor;
    }
}
