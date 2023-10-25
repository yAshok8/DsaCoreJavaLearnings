package leetcode;
import java.util.*;

public class LC210CourseScheduleII {

    public static void main(String[] args) {
        LC210CourseScheduleII obj = new LC210CourseScheduleII();
        for (int num: obj.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}))
            System.out.print(num+" ");
        for (int num: obj.findOrder(6, new int[][]{{1, 0}, {2, 1}, {0, 2}, {4, 3}, {4, 5}}))
            System.out.print(num+" ");
    }
    public int [] findOrder(int numCourses, int[][] prerequisites) {
        Stack<Integer> stack = new Stack<>();
        List<Integer>[] dag = new ArrayList[numCourses];
        for (int [] ar: prerequisites) {
            if (dag[ar[1]] == null) {
                dag[ar[1]] = new ArrayList<>();
            }
            dag[ar[1]].add(ar[0]);
        }
        boolean [] visited = new boolean[numCourses];
        for (int i=0; i<numCourses; i++)
            if (!visited[i])
                topologicalSort(dag, visited, new boolean[numCourses], i, stack);
        if (stack.size() != numCourses) return new int[0];
        int[] ans = new int[numCourses];
        for (int i=0; i<numCourses; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    private boolean topologicalSort(List<Integer>[] dag, boolean [] visited, boolean [] currV, int curr, Stack<Integer> stack) {
        visited[curr] = true;
        currV[curr] = true;
        if (dag[curr] != null)
            for (int n: dag[curr])
                if ((!visited[n] && topologicalSort(dag, visited, currV, n, stack)) || currV[n])
                    return true;
        currV[curr] = false;
        stack.add(curr);
        return false;
    }

}
