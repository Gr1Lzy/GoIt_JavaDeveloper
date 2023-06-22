package org.example.models;

public class YoungestAndEldestWorker {
    private final String name;
    private final String birthday;

    public YoungestAndEldestWorker(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nYoungestAndEldestWorkers{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
