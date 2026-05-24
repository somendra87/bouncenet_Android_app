package in.bouncenet.models;

public class UpcomingInterviewModel {
    private final String month;
    private final String day;
    private final String title;
    private final String company;
    private final String schedule;
    private final String status;

    public UpcomingInterviewModel(String month,
                                  String day,
                                  String title,
                                  String company,
                                  String schedule,
                                  String status) {
        this.month = month;
        this.day = day;
        this.title = title;
        this.company = company;
        this.schedule = schedule;
        this.status = status;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getStatus() {
        return status;
    }
}
