package com.jlefler.zork.house;

import com.jlefler.zork.security.User;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private int roomNumber;

    private double money;

    private String content;

    @ManyToMany
    private Set<Room> connections;

    @ManyToMany
    private Collection<User> players;

    public Room() {
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

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Collection<Room> getConnections() {
        return connections;
    }

    public void setConnections(Room connection) {
        connections.add(connection);
    }

    public Collection<User> getPlayers() {
        return players;
    }

    public void setPlayers(User player) {
        players.add(player);
    }
}
