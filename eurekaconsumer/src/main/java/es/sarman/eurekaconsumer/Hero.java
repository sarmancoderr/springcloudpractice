package es.sarman.eurekaconsumer;

public class Hero {

    public int id;

    public String name;

    public Hero() {}

    public Hero(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
