package de.hska.iwi.vslab.OAuthServer;

public class Role {

    private int id;
    private String type;
    private int level;

    public Role() {

    }

    public Role(String typ, Integer level) {
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
    }


}
