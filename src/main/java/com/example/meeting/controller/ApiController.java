package com.example.meeting.controller;

import com.example.meeting.domain.Meeting;
import com.example.meeting.service.PlannerService;
import com.example.meeting.domain.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/rooms")
    List<Room> all() {
        return PlannerService.allRooms;
    }


    @PostMapping("/room/meeting")
    List<Room> newMeeting(@RequestBody Meeting meeting) {
        PlannerService service = new PlannerService(meeting);
        Room roomOfMeeting = service.planeMeeting();
        if (roomOfMeeting != null)
            log.info("La salle réservée pour la " + meeting.getName() + " est : " + roomOfMeeting.getName());
        return PlannerService.allRooms;
    }

}
