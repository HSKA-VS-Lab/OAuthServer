package de.hska.iwi.vslab.OAuthServer;

public class Role {

<<<<<<< Updated upstream
    private int id;
    private String type;
    private int level;
=======
    private long id;

    private String typ;

    private Integer level;
>>>>>>> Stashed changes

    public Role() {

    }

    public Role(String typ, Integer level) {
<<<<<<< Updated upstream
        this.type = typ;
        this.level = level;
    }

    public String toString() {
        return String.format("Role[id=%d, type='%s', level=%d]", id, type, level);
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Integer getLevel() {
        return level;
=======
        this.typ = typ;
        this.level = level;
    }

    public long getId() {
        return this.id;
    }

    public String getTyp() {
        return this.typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
>>>>>>> Stashed changes
    }


}
