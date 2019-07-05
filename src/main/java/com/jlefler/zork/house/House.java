package com.jlefler.zork.house;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany
    private Collection<Room> rooms;

    public House() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Room room) {
        rooms.add(room);
    }
}
