package cn.zpf.dto;

import java.util.Date;

/**
 * Created by LoseMyself on 2017/2/27.
 */
public class Actor {
    private Long actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;

    public Long getActorId() {
        return actorId;
    }

    public Actor setActorId(Long actor) {
        this.actorId = actor;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Actor setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Actor setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public Actor setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public String toString(){
        return "Actor[id="+ actorId +", FirstName="+firstName+", LastName="+lastName+", LastUpdate="+lastUpdate+"]";
    }
}
