package com.example.meeting.util;

import com.example.meeting.domain.Hardware;
import com.example.meeting.domain.MeetingType;

import java.util.*;

public final class MeetingTypeUtility {

    public static List<Hardware> getHardwareMeeting(MeetingType meetingType) {

        if (meetingType.equals(MeetingType.VC)) {
            return Arrays.asList(Hardware.SCREEN, Hardware.PIEUVRE, Hardware.WEBCAM);
        } else if (meetingType.equals(MeetingType.SPEC)) {
            return Collections.singletonList(Hardware.BOARD);
        } else if (meetingType.equals(MeetingType.RC)) {
            return Arrays.asList(Hardware.BOARD, Hardware.SCREEN, Hardware.PIEUVRE);
        } else {
            return new ArrayList<>();
        }
    }

}
