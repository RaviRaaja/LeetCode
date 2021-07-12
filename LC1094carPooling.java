// https://leetcode.com/problems/car-pooling/

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        Map<Integer, Integer> tm = new TreeMap<>();
        int numberOfPeople, start, end;
        
        for(int[] trip: trips) {
            
            numberOfPeople = trip[0];
            start = trip[1];
            end = trip[2];
            
            tm.put(start, tm.getOrDefault(start,0) + numberOfPeople);
            tm.put(end, tm.getOrDefault(end, 0) - numberOfPeople);
        }
        
        int ourCapacity = 0;
        for(int value: tm.values()) {
            ourCapacity += value;
            if(ourCapacity > capacity) return false;
        }
        
        return true;
        
    }
}


