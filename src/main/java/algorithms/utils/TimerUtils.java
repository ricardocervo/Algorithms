package algorithms.utils;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class TimerUtils {

    private long millisStart;
    private final static String DAYS = "days";
    private final static String HOURS = "hours";
    private final static String MINUTES = "minutes";
    private final static String SECONDS = "seconds";
    private final static String MILLIS = "ms";

    public void reset() {
        millisStart = System.currentTimeMillis();
    }

    public String elapsedTime() {
        LocalDateTime firstDate = convertToLocalDateViaMilisecond(millisStart);
        LocalDateTime secondDate = convertToLocalDateViaMilisecond(System.currentTimeMillis());

        Duration duration = Duration.between(firstDate, secondDate);
        long days = duration.toDays();
        Duration d2 = duration.minus(days, ChronoUnit.DAYS);
        long hours = d2.toHours();
        Duration d3 = d2.minus(hours, ChronoUnit.HOURS);
        long minutes = d3.toMinutes();
        Duration d4 = d3.minus(minutes, ChronoUnit.MINUTES);
        long seconds = d4.getSeconds();
        Duration d5 = d4.minus(seconds, ChronoUnit.SECONDS);
        long millis = d5.toMillis();

        TreeMap<String, Long> map = new TreeMap<>(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                Map<String, Integer> map = new HashMap<>();
                map.put(DAYS, 1);
                map.put(HOURS, 2);
                map.put(MINUTES, 3);
                map.put(SECONDS, 4);
                map.put(MILLIS, 5);

                return map.get(o1) - map.get(o2);
            }

        });
        if (days > 0)
            map.put(DAYS, days);
        if (hours > 0)
            map.put(HOURS, hours);
        if (minutes > 0)
            map.put(MINUTES, minutes);
        if (seconds > 0)
            map.put(SECONDS, seconds);
        if (millis > 0)
            map.put(MILLIS, millis);

        String str = "";
        for (String label : map.keySet()) {
            long value = map.get(label);
            if (!str.isEmpty()) {
                str += ", ";
            }
            str += value + " " + label;
        }
        return str;
    }

    private LocalDateTime convertToLocalDateViaMilisecond(long millis) {
        return Instant.ofEpochMilli(millis)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static void main(String[] args) {
        TimerUtils timer = new TimerUtils();
        timer.reset();
        try {
            for (int i = 0; i < 50; i++) {
                Thread.sleep(new Random().nextInt(1000));
                System.out.println(timer.elapsedTime());
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    public void printTime(String description) {
        System.out.println(description + ": " + elapsedTime());
    }
}
