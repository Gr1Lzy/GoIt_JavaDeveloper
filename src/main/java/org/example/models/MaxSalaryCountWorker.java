package org.example.models;

public class MaxSalaryCountWorker {
    private final String name;
    private final int salary;

    public MaxSalaryCountWorker(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nMaxSalaryCountWorker{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
