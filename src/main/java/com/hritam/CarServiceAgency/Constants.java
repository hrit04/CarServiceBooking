package com.hritam.CarServiceAgency;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constants {

    // Define the key-value pairs in a Map
    private static final Map<String, Integer> CONSTANTS_MAP;

    static {
        Map<String, Integer> map = new HashMap<>();
        map.put("BOOKING_CREATED", 1);
        map.put("BOOKING_RESCHEDULED", 2);
        map.put("BOOKING_PROCESSED", 3);
        map.put("BOOKING_CANCELED", 4);
        CONSTANTS_MAP = Collections.unmodifiableMap(map);  // Make the map unmodifiable
    }

    // Method to access the constants
    public static Integer getValue(String key) {
        return CONSTANTS_MAP.get(key);
    }
}

