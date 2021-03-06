package kpavlov.jsonweb.domain;

public class Item {

    private Integer id;
    private String name;
    private String description;

    public Item(String name, String description) {
        this.id = null;
        this.name = name;
        this.description = description;
    }

    public Item(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
