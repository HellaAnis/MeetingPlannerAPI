package com.example.meeting;

import com.example.meeting.service.PlannerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MeetingApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoadsFromController() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/rooms",
                ArrayList.class)).isNotNull();
    }

    @Test
    public void dataLoads(){
        assertThat(PlannerService.allRooms).isNotNull();
        assertThat(PlannerService.extraHardwares).isNotNull();
    }


}
