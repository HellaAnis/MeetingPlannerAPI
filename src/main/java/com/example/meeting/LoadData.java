package com.example.meeting;

import com.example.meeting.domain.ExtraHardware;
import com.example.meeting.domain.Hardware;
import com.example.meeting.domain.Room;
import com.example.meeting.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

import static com.example.meeting.service.PlannerService.extraHardwares;


@Configuration
class LoadData {

    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDatabase() {

        Room E1001 = new Room("E1001", 23, new HashSet<>(), new HashSet<>(Arrays.asList(Hardware.NEANT)));
        Room E1002 = new Room("E1002", 10, new HashSet<>(), new HashSet<>(Arrays.asList(Hardware.SCREEN)));
        Room E1003 = new Room("E1003", 8, new HashSet<>(), new HashSet<>(Arrays.asList(Hardware.PIEUVRE)));
        Room E1004 = new Room("E1004", 4, new HashSet<>(), new HashSet<>(Arrays.asList(Hardware.BOARD)));
        Room E2001 = new Room("E2001", 4, new HashSet<>(), new HashSet<>(Arrays.asList(Hardware.NEANT)));
        Room E2002 = new Room("E2002", 15, new HashSet<>(), new HashSet<>(Arrays.asList(Hardware.SCREEN,Hardware.WEBCAM)));
        Room E2003 = new Room("E2003", 7, new HashSet<>(), new HashSet<>(Arrays.asList(Hardware.NEANT)));
        Room E2004 = new Room("E2004", 9, new HashSet<>(), new HashSet<>(Arrays.asList(Hardware.BOARD)));
        Room E3001 = new Room("E3001", 13, new HashSet<>(), new HashSet<>(Arrays.asList(Hardware.SCREEN,Hardware.WEBCAM,Hardware.PIEUVRE)));
        Room E3002 = new Room("E3002", 8, new HashSet<>(), new HashSet<>(Arrays.asList(Hardware.NEANT)));
        Room E3003 = new Room("E3003", 9, new HashSet<>(), new HashSet<>(Arrays.asList(Hardware.SCREEN,Hardware.PIEUVRE)));
        Room E3004 = new Room("E3004", 4, new HashSet<>(), new HashSet<>(Arrays.asList(Hardware.NEANT)));

        
        for (int i = 0; i < 4; i++) {
            extraHardwares.add(new ExtraHardware(Hardware.PIEUVRE));
        }
        for (int i = 0; i < 4; i++) {
            extraHardwares.add(new ExtraHardware(Hardware.WEBCAM));
        }

        for (int i = 0; i <2 ; i++) {
            extraHardwares.add(new ExtraHardware(Hardware.BOARD));
        }

        for (int i = 0; i < 5; i++) {
            extraHardwares.add(new ExtraHardware(Hardware.SCREEN));

        }
        return args -> {
            log.info("Preloading room E1001 " +  PlannerService.allRooms.add(E1001));
            log.info("Preloading room E1002 " +  PlannerService.allRooms.add(E1002));
            log.info("Preloading room E1003 " +  PlannerService.allRooms.add(E1003));
            log.info("Preloading room E1004 " +  PlannerService.allRooms.add(E1004));
            log.info("Preloading room E2001 " +  PlannerService.allRooms.add(E2001));
            log.info("Preloading room E2002 " +  PlannerService.allRooms.add(E2002));
            log.info("Preloading room E2003 " +  PlannerService.allRooms.add(E2003));
            log.info("Preloading room E2004 " +  PlannerService.allRooms.add(E2004));
            log.info("Preloading room E3001 " +  PlannerService.allRooms.add(E3001));
            log.info("Preloading room E3002 " +  PlannerService.allRooms.add(E3002));
            log.info("Preloading room E3003 " +  PlannerService.allRooms.add(E3003));
            log.info("Preloading room E3004 " +  PlannerService.allRooms.add(E3004));
        };
    }
}

