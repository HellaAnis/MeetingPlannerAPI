package com.example.meeting.domain;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class ExtraHardware {

    private Hardware hardware;
    private Set<LocalTime> meetings = new HashSet<>();

    public ExtraHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    public Hardware getHardware() {
        return hardware;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    public Set<LocalTime> getMeetings() {
        return meetings;
    }

    public void setMeetings(Set<LocalTime> meetings) {
        this.meetings = meetings;
    }

    @Override
    public String toString() {
        return "ExtraHardware{" +
                "hardware=" + hardware +
                ", meetings=" + meetings +
                '}';
    }
}
