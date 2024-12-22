package model;

import java.time.ZonedDateTime;

public class activity {
    private String id;
    private String type;
    private actor actor;
    private repo repo;
    private payload payload;
    private boolean IsPublic;
    private ZonedDateTime created_at;


    public activity(String id, String type, model.actor actor,repo repo, boolean isPublic, ZonedDateTime created_at) {
        this.id = id;
        this.type = type;
        this.actor = actor;
        this.repo = repo;
        IsPublic = isPublic;
        this.created_at = created_at;
    }

    public activity(String id, String type, model.actor actor, model.repo repo, payload payload, boolean isPublic,
    ZonedDateTime created_at) {
        this.id = id;
        this.type = type;
        this.actor = actor;
        this.repo = repo;
        this.payload = payload;
        IsPublic = isPublic;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public actor getActor() {
        return actor;
    }

    public void setActor(actor actor) {
        this.actor = actor;
    }

    public repo getRepo() {
        return repo;
    }

    public void setRepo(repo repo) {
        this.repo = repo;
    }

    public payload getPayload() {
        return payload;
    }

    public void setPayload(payload payload) {
        this.payload = payload;
    }

    public boolean isIsPublic() {
        return IsPublic;
    }

    public void setIsPublic(boolean isPublic) {
        IsPublic = isPublic;
    }

    public ZonedDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(ZonedDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Activity {\n\nid: \"" + id + "\", \ntype: \"" + type + "\", \nactor:\n\t{" + actor + ", \nrepo: " + repo + ", \npayload: " + payload
                + ", \nIsPublic: \"" + IsPublic + "\", \ncreated_at: \"" + created_at + "\"\n}";
    }

    
    
}
