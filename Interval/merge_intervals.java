class Solution {
    public int[][] merge(int[][] intervals) {
         if (intervals.length == 0) {
            return new int[0][0];
        }
        
        // Sort intervals by their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Create a list to store the merged intervals
        List<int[]> merged = new ArrayList<>();
        
        // Initialize the first interval as the starting interval to compare
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);
        
        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];
            
            if (currentEnd >= nextStart) { // Overlapping intervals, merge them
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else { // Non-overlapping interval, add it to the list
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}
