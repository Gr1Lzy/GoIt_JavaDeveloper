package org.example;

public class YoungestAndOldestWorker {
    private String name;
    private String birthday;

    public YoungestAndOldestWorker(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nYoungestAndOldestWorkers{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
