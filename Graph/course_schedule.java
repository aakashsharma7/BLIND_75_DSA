class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         // Step 1: Create the adjacency list and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }
        
        // Step 2: Find all courses with no prerequisites (in-degree of 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // Step 3: Process the courses
        int processedCourses = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            processedCourses++;
            for (int nextCourse : graph.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }
        
        // If all courses have been processed, then it's possible to finish
        return processedCourses == numCourses;
    }
}
