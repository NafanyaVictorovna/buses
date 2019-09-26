package service;

import model.Timetable;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class TimetableService {
    private static final String POSH = "Posh";
    private Map<LocalTime, Timetable> selectedTable = new HashMap<>();

    public List<String> sortTimetable(List<Timetable> timetable) {

        List<String> result = filterCollection(timetable.stream()
                .filter(o -> Math.abs(Duration.between(o.getArrivingTime(), o.getDepartureTime()).toMinutes()) <= Duration.ofHours(1).toMinutes())
                .collect(Collectors.toList())).stream()
                .sorted(Comparator.comparing(Timetable::getDepartureTime))
                .sorted(Comparator.comparing(Timetable::getName).reversed())
                .map(v -> v.getName() + " " + v.getDepartureTime().toString() + " " + v.getArrivingTime().toString() + "\n")
                .collect(Collectors.toList());
        return result;
    }

    private Collection<Timetable> filterCollection(List<Timetable> timetable) {
        for (Timetable t1: timetable) {
//            Timetable betterValue = new Timetable();
            for(Timetable t2: timetable) {
                if(t1.getDepartureTime().isAfter(t2.getDepartureTime())) {
                    betterValue = t2.getArrivingTime().isAfter(t1.getArrivingTime()) ? t1 : t2;
                } else if (t1.getDepartureTime().isBefore(t2.getDepartureTime())) {
                    betterValue = t1.getArrivingTime().isAfter(t2.getArrivingTime()) ? t2 : t1;
                } else {
                    if (!t1.equals(t2)) {
                        betterValue = t1.getArrivingTime().isBefore(t2.getArrivingTime()) ?
                                t1 : t1.getArrivingTime().isAfter(t2.getArrivingTime()) ?
                                t2 : POSH.equals(t1.getName()) ? t1 : t2;
                    }
                }
            }
        }
        return selectedTable.values();
    }

    private void setValue(Timetable value) {
        if(!selectedTable.containsKey(value.getDepartureTime()))
        selectedTable.put(value.getDepartureTime(), value);
    }

}
