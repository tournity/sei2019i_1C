package user_sports_group.Entities;

public class usgEntity{
    private int Id;
    private String name;
    private String description;
    private int user_sport;

    public usgEntity(int id, String name, String description, int user_sport) {
        Id = id;
        this.name = name;
        this.description = description;
        this.user_sport = user_sport;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public int getUser_sport() {
        return user_sport;
    }

    public void setUser_sport(int user_sport) {
        this.user_sport = user_sport;
    }
}