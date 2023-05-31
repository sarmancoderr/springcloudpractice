package es.sarman.eurekaconsumer;

public class HeroDTO {

    public String name;

    public HeroDTO() {}

    public HeroDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
