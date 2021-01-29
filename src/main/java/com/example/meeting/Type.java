package com.example.meeting;

import java.util.*;

public class Type {

    public static List<Hardware> getHardwareMeeting(MeetingType meetingType){

        if (meetingType.equals(MeetingType.VC)) {
            return Arrays.asList(Hardware.SCREEN,Hardware.PIEUVRE,Hardware.WEBCAM); }
        else if (meetingType.equals(MeetingType.SPEC)) {
            return Collections.singletonList(Hardware.BOARD);}
        else if (meetingType.equals(MeetingType.RC)) {
            return Arrays.asList(Hardware.BOARD,Hardware.SCREEN,Hardware.PIEUVRE); }
        else { return new ArrayList<>();}
    }

}
