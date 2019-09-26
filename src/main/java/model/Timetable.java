package model;

import java.time.LocalTime;

public class Timetable {

    private String name;
    private LocalTime departureTime;
    private LocalTime arrivingTime;

    public Timetable() {}

    public Timetable(String name, LocalTime departureTime, LocalTime arrivingTime) {
        this.name = name;
        this.departureTime = departureTime;
        this.arrivingTime = arrivingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivingTime() {
        return arrivingTime;
    }

    public void setArrivingTime(LocalTime arrivingTime) {
        this.arrivingTime = arrivingTime;
    }
}
