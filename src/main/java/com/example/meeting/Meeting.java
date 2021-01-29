package com.example.meeting;

import java.time.LocalTime;


public class Meeting {

    private String name;

    private LocalTime meetingDepartureTime;

    private MeetingType type;

    private int peopleOfMeeting;

    public Meeting(String name, LocalTime localTime, MeetingType type, int peopleOfMeeting) {
        this.name = name;
        this.meetingDepartureTime = localTime;
        this.type = type;
        this.peopleOfMeeting = peopleOfMeeting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getMeetingDepartureTime() {
        return meetingDepartureTime;
    }

    public void setMeetingDepartureTime(LocalTime meetingDepartureTime) {
        this.meetingDepartureTime = meetingDepartureTime;
    }

    public MeetingType getType() {
        return type;
    }

    public void setType(MeetingType type) {
        this.type = type;
    }

    public int getPeopleOfMeeting() {
        return peopleOfMeeting;
    }

    public void setPeopleOfMeeting(int peopleOfMeeting) {
        this.peopleOfMeeting = peopleOfMeeting;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "name='" + name + '\'' +
                ", meetingDepartureTime=" + meetingDepartureTime +
                ", type=" + type +
                ", peopleOfMeeting=" + peopleOfMeeting +
                '}';
    }
}
