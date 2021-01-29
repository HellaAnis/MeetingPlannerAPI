package com.example.meeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;


@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase() {
        Room room = new Room("E01", 10, new HashSet<>(), new HashSet<>(Arrays.asList(Hardware.SCREEN)));
        Room room1 = new Room("E02", 10, new HashSet<>(), new HashSet<>(Arrays.asList(Hardware.BOARD)));
        Room room2 = new Room("E03", 10, new HashSet<>(), new HashSet<>(Arrays.asList(Hardware.SCREEN, Hardware.PIEUVRE,Hardware.WEBCAM)));


        return args -> {
            log.info("Preloading " +  PlannerService.allRooms.add(room));
            log.info("Preloading " +  PlannerService.allRooms.add(room1));
            log.info("Preloading " +  PlannerService.allRooms.add(room2));


        };
    }
}

