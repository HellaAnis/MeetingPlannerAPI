package com.example.meeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;

@RestController
public class Controller {


    @GetMapping("/room")
    List<Room> all() {
        return PlannerService.allRooms;
    }

    @GetMapping("/mee")
    Meeting meeting() {
        return  new Meeting("1",LocalTime.of(9, 0), MeetingType.VC, 8);

    }

    @PostMapping("/room/meeting")
    List<Room> newMeeting(@RequestBody Meeting meeting) {
        PlannerService service = new PlannerService(meeting);
        service.planeMeeting();
        System.out.println("PlannerService.allRooms = " + PlannerService.allRooms);
        return PlannerService.allRooms;
    }

}
