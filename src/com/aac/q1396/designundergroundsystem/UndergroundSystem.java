package com.aac.q1396.designundergroundsystem;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

    Map<String, Map<String, int[]>> from_A_to_B_for_C_times_D_hours;

    class CheckInfo {
        String checkInPosition;
        int checkInTime;
        public CheckInfo (String p, int t) {
            checkInPosition = p;
            checkInTime = t;
        }
    }

    Map<Integer, CheckInfo> checkInList;

    public UndergroundSystem() {
        from_A_to_B_for_C_times_D_hours = new HashMap<>();
        checkInList = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        if(!checkInList.containsKey(id)) {
            checkInList.put(id, new CheckInfo(stationName, t));
        }
    }

    public void checkOut(int id, String stationName, int t) {
        if(checkInList.containsKey(id)) {
            CheckInfo c = checkInList.get(id);
            if(!from_A_to_B_for_C_times_D_hours.containsKey(c.checkInPosition)) {
                from_A_to_B_for_C_times_D_hours.put(c.checkInPosition, new HashMap<>());
                from_A_to_B_for_C_times_D_hours.get(c.checkInPosition).put(stationName, new int[] {1, t - c.checkInTime});
            } else {
                if(!from_A_to_B_for_C_times_D_hours.get(c.checkInPosition).containsKey(stationName)) {
                    from_A_to_B_for_C_times_D_hours.get(c.checkInPosition).put(stationName, new int[] {1, t - c.checkInTime});
                } else {
                    int[] currentCD = from_A_to_B_for_C_times_D_hours.get(c.checkInPosition).get(stationName);
                    from_A_to_B_for_C_times_D_hours.get(c.checkInPosition).put(stationName, new int[] {currentCD[0] + 1, t - c.checkInTime + currentCD[1]});
                }
            }
            checkInList.remove(id);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] currentCD = from_A_to_B_for_C_times_D_hours.get(startStation).get(endStation);
        return currentCD[1] * 1.0 / currentCD[0];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */