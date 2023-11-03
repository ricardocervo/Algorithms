package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CourseSchedule {

    HashSet<Integer> setVisited = new HashSet<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int crs = prerequisites[i][0];
            int pre = prerequisites[i][1];

            map.get(crs).add(pre);
        }

        for (Integer crs : map.keySet()) {
            if (!dfs(crs)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int crs) {
        if (setVisited.contains(crs)) {
            return false;
        }
        if (map.get(crs).isEmpty()) {
            return true;
        }
        
        setVisited.add(crs);
        for (Integer pre : map.get(crs)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        
        setVisited.remove(crs);
        map.get(crs).clear();
        return true;
        
    }
    
    /*
        Input: numCourses = 2, prerequisites = [[1,0]]
        Output: true
        Explanation: There are a total of 2 courses to take. 
        To take course 1 you should have finished course 0. So it is possible.
     */
    @Test
    public void test1() {
        int[][] graph = {{1, 0}};
        int numCourses = 2;
        assertEquals(true, canFinish(numCourses, graph));
    }

    /*
        Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
        Output: false
        Explanation: There are a total of 2 courses to take. 
        To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.    
     */
    @Test
    public void test2() {
        int numCourses = 2;
        int[][] graph = {{1, 0}, {0, 1}};
        assertEquals(false, canFinish(numCourses, graph));
    }
}
