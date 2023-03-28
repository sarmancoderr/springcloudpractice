package es.sarman.pruebatecnica.Heroes;

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
