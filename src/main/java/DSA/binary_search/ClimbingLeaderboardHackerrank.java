package DSA.binary_search;

import java.util.*;

public class ClimbingLeaderboardHackerrank {

    public static List<Integer> climbingLeaderboard2Pointer(List<Integer> ranked, List<Integer> player) {
        List<Integer> res = new ArrayList<>();
        List<Integer> distinct = new ArrayList<>();
        for (int rank: ranked) {
            if (distinct.isEmpty() || distinct.get(distinct.size()-1) != rank) {
                distinct.add(rank);
            }
        }
        int index = distinct.size() - 1;
        for (int score: player) {
            while (index >= 0 && score >= distinct.get(index)) index--;
            res.add(index + 2);
        }
        return res;
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> rankMap = new HashMap<>();
        List<Integer> newRanked = new ArrayList<>();
        int rank = 1;

        for (int score : ranked) {
            if (!rankMap.containsKey(score)) {
                rankMap.put(score, rank++);
                newRanked.add(score);
            }
        }

        int rankedSize = newRanked.size();

        for (int score : player) {
            if (newRanked.get(0) < score) {
                ans.add(1);
                continue;
            }
            if (newRanked.get(rankedSize - 1) > score) {
                ans.add(rankMap.get(newRanked.get(rankedSize - 1)) + 1);
                continue;
            }
            int l = 0;
            int r = rankedSize - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (newRanked.get(mid) > score) {
                    if (newRanked.get(mid + 1) <= score) {
                        ans.add(rankMap.get(newRanked.get(mid + 1)));
                        break;
                    }
                    l = mid + 1;
                } else if (newRanked.get(mid) < score) {
                    if (newRanked.get(mid - 1) == score) {
                        ans.add(rankMap.get(newRanked.get(mid - 1)));
                        break;
                    }
                    r = mid - 1;
                } else {
                    ans.add(rankMap.get(score));
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //Hardcoded input
        //List<Integer> ranked = Arrays.asList(100, 100, 50, 40, 40, 20, 10);
        //List<Integer> player = Arrays.asList(5, 25, 50, 120);
        //List<Integer> result = climbingLeaderboard(ranked, player);

        // Hardcoded input
        List<Integer> ranked = Arrays.asList(100, 90, 90, 80, 75, 60);
        List<Integer> player = Arrays.asList(50, 65, 77, 90, 102);
        List<Integer> result1 = climbingLeaderboard(ranked, player);
        List<Integer> result2 = climbingLeaderboard2Pointer(ranked, player);
        System.out.println(result1);
        System.out.println(result2);
    }
}