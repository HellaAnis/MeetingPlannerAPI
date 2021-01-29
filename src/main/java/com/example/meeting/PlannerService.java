package com.example.meeting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlannerService {

    private final Meeting meeting;
    public static List<Room> allRooms = new ArrayList<>();
    public static List<Hardware> hardwares = new ArrayList<>();

    public PlannerService(Meeting meeting) {
        this.meeting = meeting;
    }

    public boolean isSameTypeMeeting(Meeting meeting, Room room) {
        for (Hardware hardware : Type.getHardwareMeeting(meeting.getType())) {
            if (!room.getEquipment().contains(hardware)) return false;
        }
        return true;
    }

    public double calculatePercentage(double obtained) {
        return (obtained * 70)/100;
    }

    public Room planeMeeting() {
        Room  roomMeeting = null;
        for (Room room : allRooms) {
            if (isSameTypeMeeting(meeting, room) && meeting.getPeopleOfMeeting() <= calculatePercentage(room.getCapacity()))  //todo capacite
            {
                if (!room.getReservationSlots().stream().map(Meeting::getMeetingDepartureTime).collect(Collectors.toSet()).contains(meeting.getMeetingDepartureTime())
                        && !room.getReservationSlots().stream().map(Meeting::getMeetingDepartureTime).collect(Collectors.toSet()).contains(meeting.getMeetingDepartureTime().minusHours(1))
                        && !room.getReservationSlots().stream().map(Meeting::getMeetingDepartureTime).collect(Collectors.toSet()).contains(meeting.getMeetingDepartureTime().plusHours(1))) {
                    room.getReservationSlots().add(meeting);
                    roomMeeting = room;
                    break;
                }
                else {
                    System.out.println("Le créneau est ocuper" );
                }
            }
        }
        return  roomMeeting;
    }
}
