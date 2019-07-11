package com.jlefler.zork.house;

import com.jlefler.zork.security.User;

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

    @OneToMany
    private Collection<User> players;

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

    public Collection<User> getPlayers() {
        return players;
    }

    public void setPlayers(User player) {
        players.add(player);
    }
}
