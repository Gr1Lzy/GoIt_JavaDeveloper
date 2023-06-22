package org.example.models;

public class LongestProject {
    private final int id;
    private final int clientId;
    private final String startDate;
    private final String finishDate;
    private final int durationMonths;

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
