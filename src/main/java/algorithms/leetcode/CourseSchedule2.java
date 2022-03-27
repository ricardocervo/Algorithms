package algorithms.leetcode;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class CourseSchedule2 {

    HashSet<Integer> setVisited = new HashSet<>();
    HashSet<Integer> setCurrentPath = new HashSet<>();
    HashMap<Integer, List<Integer>> mapPreReq = new HashMap<>();
    int[] order;
    int orderIndex;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            mapPreReq.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            mapPreReq.get(course).add(prereq);
        }

        for (int i = 0; i < numCourses; i++) {
            setCurrentPath.clear();
            if (!topologicalOrder(i)) {
                return new int[] {};
            }
        }
        return order;
    }

    boolean topologicalOrder(int course) {
        if (setCurrentPath.contains(course)) {
            return false;
        }
        if (setVisited.contains(course)) {
            return true;
        }

        if (mapPreReq.get(course).isEmpty()) {
            order[orderIndex++] = course;
            setVisited.add(course);
            return true;
        }

        setCurrentPath.add(course);
        for (Integer prereq : mapPreReq.get(course)) {
            if (!topologicalOrder(prereq)) {
                return false;
            }
        }
        order[orderIndex++] = course;
        setCurrentPath.remove(course);
        setVisited.add(course);
        return true;
    }

    @Test
    public void test1() {
        int[][] graph = { { 1, 0 } };
        int numCourses = 2;
        assertTrue(Arrays.equals(new int[] { 0, 1 }, findOrder(numCourses, graph)));
    }

    @Test
    public void test2() {
        int[][] graph = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int numCourses = 4;
        assertTrue(Arrays.equals(new int[] { 0, 1, 2, 3 }, findOrder(numCourses, graph)));
    }

    @Test
    public void test3() {
        int[][] graph = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        int numCourses = 3;
        assertTrue(Arrays.equals(new int[] { 2, 1, 0 }, findOrder(numCourses, graph)));
    }

    @Test
    public void test4() {
        int[][] graph = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 1 } };
        int numCourses = 3;
        assertTrue(Arrays.equals(new int[] {}, findOrder(numCourses, graph)));
    }

    @Test
    public void test5() {
        int[][] graph = { { 1, 0 }, { 0, 3 }, { 0, 2 }, { 3, 2 }, { 2, 5 }, { 4, 5 }, { 5, 6 }, { 2, 4 } };
        int numCourses = 7;
        assertTrue(Arrays.equals(new int[] { 6, 5, 4, 2, 3, 0, 1 }, findOrder(numCourses, graph)));
    }

}
