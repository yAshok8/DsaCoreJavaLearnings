package leetcode;

import java.util.*;

class LC841KeysAndRooms {
    public static void main(String[] args) {
        System.out.println(canVisitAllRooms(getMeInput()));
    }

    private static List<List<Integer>> getMeInput() {
        List<List<Integer>> listOfLists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        List<Integer> list4 = new ArrayList<>();
        listOfLists.add(list1);
        listOfLists.add(list2);
        listOfLists.add(list3);
        listOfLists.add(list4);
        return listOfLists;
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        return traverse(rooms, new HashSet<>(), 0);
    }

    private static boolean traverse(List<List<Integer>> rooms, Set<Integer> visited, int currRoom) {
        if (visited.contains(currRoom)) {
            return false;
        }
        visited.add(currRoom);
        if (visited.size() == rooms.size()) {
            return true;
        }
        boolean ans = false;
        for (int key: rooms.get(currRoom))
            ans |= traverse(rooms, visited, key);
        return ans;
    }
}
