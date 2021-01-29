package com.example.meeting;

import java.time.LocalTime;

import java.util.Set;

public class Room {

    private String name;

    private int capacity;

    private Set<Meeting> reservationSlots;

    private Set<Hardware> equipment;

    public Room() {
    }

    public Room(String name, int capacity, Set<Meeting> reservationSlots, Set<Hardware> equipment) {
        this.name = name;
        this.capacity = capacity;
        this.reservationSlots = reservationSlots;
        this.equipment = equipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Set<Meeting> getReservationSlots() {
        return reservationSlots;
    }

    public void setReservationSlots(Set<Meeting> reservationSlots) {
        this.reservationSlots = reservationSlots;
    }

    public Set<Hardware> getEquipment() {
        return equipment;
    }

    public void setEquipment(Set<Hardware> equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", reservationSlots=" + reservationSlots +
                ", equipment=" + equipment +
                '}';
    }
}
