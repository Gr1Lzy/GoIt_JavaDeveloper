package org.example;

public class LongestProject {
    private int id;
    private int clientId;
    private String startDate;
    private String finishDate;
    private int durationMonths;

    public LongestProject(int id, int clientId, String startDate, String finishDate, int durationMonths) {
        this.id = id;
        this.clientId = clientId;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.durationMonths = durationMonths;
    }

    @Override
    public String toString() {
        return "\nLongestProject{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", startDate='" + startDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                ", durationMonth=" + durationMonths +
                '}';
    }
}
