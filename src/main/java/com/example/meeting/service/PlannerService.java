package com.example.meeting.service;

import com.example.meeting.util.MeetingTypeUtility;
import com.example.meeting.domain.ExtraHardware;
import com.example.meeting.domain.Hardware;
import com.example.meeting.domain.Meeting;
import com.example.meeting.domain.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PlannerService implements Service {

    private final Meeting meeting;
    public static List<Room> allRooms = new ArrayList<>();
    public static List<ExtraHardware> extraHardwares = new ArrayList<>();

    private static final Logger log = LoggerFactory.getLogger(PlannerService.class);


    public PlannerService(Meeting meeting) {
        this.meeting = meeting;
    }

    public Room planeMeeting() {
        Room roomMeeting = null;
        //
        List<Room> sortedRooms = allRooms
                .stream()
                .sorted(Comparator.comparingInt(Room::getCapacity))
                .collect(Collectors.toList());

        for (Room room : sortedRooms) {
            Set<LocalTime> allRoomMeeting = room.getReservationSlots()
                    .stream()
                    .map(Meeting::getMeetingDepartureTime)
                    .collect(Collectors.toSet());

            if (isSameTypeMeeting(meeting, room))
            {
                if (isNotOccupied(meeting, allRoomMeeting) //todo capacite
                        && meeting.getPeopleOfMeeting() <= (int) calculatePercentage(room.getCapacity())) {
                    room.getReservationSlots().add(meeting);
                    roomMeeting = room;
                    break;
                }
            }

        }

        if (roomMeeting == null){
            for (Room room : sortedRooms) {
                Set<LocalTime> allRoomMeeting = room.getReservationSlots()
                        .stream()
                        .map(Meeting::getMeetingDepartureTime)
                        .collect(Collectors.toSet());

                List<Hardware> missingEquipment = getMissingEquipment(room);

                if (isMissingEquipmentAvailable(missingEquipment)) {
                    if (isNotOccupied(meeting, allRoomMeeting)
                            && meeting.getPeopleOfMeeting() <= (int) calculatePercentage(room.getCapacity())) {
                        room.getReservationSlots().add(meeting);
                        roomMeeting = room;
                        for (Hardware hardware : missingEquipment) {
                            for (ExtraHardware extraHardware : extraHardwares
                                    .stream()
                                    .filter(h -> !h.getMeetings().contains(meeting.getMeetingDepartureTime()))
                                    .collect(Collectors.toSet())) {
                                if (extraHardware.getHardware().equals(hardware)) {
                                    extraHardware.getMeetings().add(meeting.getMeetingDepartureTime());
                                    break;
                                }
                            }
                        }
                        room.getReservationSlots().add(meeting);
                        break;
                    }
                }

            }
        }
        if (roomMeeting == null)
            log.info("Toutes les salles sont occupées, impossible de faire réservation pour la réunion : " + meeting.getName());
        return roomMeeting;
    }

    private boolean isSameTypeMeeting(Meeting meeting, Room room) {
        for (Hardware hardware : MeetingTypeUtility.getHardwareMeeting(meeting.getType())) {
            if (!room.getEquipment().contains(hardware)) return false;
        }
        return true;
    }

    private double calculatePercentage(double obtained) {
        return (obtained * 70) / 100;
    }

    private boolean isNotOccupied(Meeting meeting, Set<LocalTime> allRoomMeeting) {
        return !allRoomMeeting.contains(meeting.getMeetingDepartureTime())
                && !allRoomMeeting.contains(meeting.getMeetingDepartureTime().minusHours(1))
                && !allRoomMeeting.contains(meeting.getMeetingDepartureTime().plusHours(1));
    }

    private boolean isMissingEquipmentAvailable(List<Hardware> missingEquipment) {
        boolean equipmentAvailable = true;
        for (Hardware hardware : missingEquipment
        ) {
            if (!extraHardwares.stream()
                    .filter(e -> !e.getMeetings().contains(meeting.getMeetingDepartureTime()))
                    .map(ExtraHardware::getHardware)
                    .collect(Collectors.toSet()).contains(hardware)) {
                equipmentAvailable = false;
                break;
            }
        }
        return equipmentAvailable;
    }

    private List<Hardware> getMissingEquipment(Room room) {
        List<Hardware> missingEquipment = new ArrayList<>();
        for (Hardware hardware : MeetingTypeUtility.getHardwareMeeting(meeting.getType())) {
            if (!room.getEquipment().contains(hardware)) {
                missingEquipment.add(hardware);
            }
        }
        return missingEquipment;
    }

}
