package org.example.models;

public class ProjectPrice {
    private int ID;
    private String startDate;
    private String finishDate;

    public ProjectPrice(int ID, String startDate, String finishDate) {
        this.ID = ID;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "\nProjectPrice{" +
                "ID=" + ID +
                ", startDate='" + startDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                '}';
    }
}
