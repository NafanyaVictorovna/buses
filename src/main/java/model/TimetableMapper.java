package model;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TimetableMapper {

    public Timetable toModel(String line) {
        Timetable timetable;
        String[] lineArray = line.split(" ");
        final String name = lineArray[0];
        LocalTime departureTime, arrivingTime;
        try {
            departureTime = LocalTime.parse(lineArray[1]);
            arrivingTime = LocalTime.parse(lineArray[2]);
            timetable = new Timetable(name, departureTime, arrivingTime);
        } catch (DateTimeParseException e) {
            timetable = new Timetable();
        }

        return timetable;
    }

}
