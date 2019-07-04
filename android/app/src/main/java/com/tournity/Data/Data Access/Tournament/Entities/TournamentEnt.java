package Tournament.Entities;

public class TournamentEnt{
    int id;
    String owner;
    int Group;
    String name;
    int init_date;
    int finish_date;

    public TournamentEnt(int id, String owner, int group, String name, int init_date, int finish_date) {
        this.id = id;
        this.owner = owner;
        Group = group;
        this.name = name;
        this.init_date = init_date;
        this.finish_date = finish_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getGroup() {
        return Group;
    }

    public void setGroup(int group) {
        Group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInit_date() {
        return init_date;
    }

    public void setInit_date(int init_date) {
        this.init_date = init_date;
    }

    public int getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(int finish_date) {
        this.finish_date = finish_date;
    }
}
