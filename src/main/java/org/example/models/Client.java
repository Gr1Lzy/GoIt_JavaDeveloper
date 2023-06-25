package org.example.models;

public class Client {
    private long id;
    private String name;

    public Client() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\nClient{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                '}';
    }
}
