package DSA.hashtable;

import java.util.*;

public class FrequencyQuery {

    public static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> cf_map = new HashMap<>();
        Map<Integer, Set<Integer>> fc_set_map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (List<Integer> query: queries) {
            int op = query.get(0);
            int num = query.get(1);
            switch (op) {
                case 1:
                    insertNum(num, cf_map, fc_set_map);
                    break;
                case 2:
                    deleteNum(num, cf_map, fc_set_map);
                    break;
                case 3:        
                    checkNum(num, fc_set_map, res);
                    break;
                default: break;
            }
        }
        return res;
    }

    private static void insertNum(int num, Map<Integer, Integer> cf_map, Map<Integer, Set<Integer>> fc_set_map) {
        int numFreq = cf_map.getOrDefault(num, 0);
        int newFreq = numFreq + 1;
        cf_map.put(num, newFreq);
        Set<Integer> freqSet = fc_set_map.getOrDefault(newFreq, new HashSet<>());
        if (newFreq > 1) {
            Set<Integer> innerSet = fc_set_map.get(numFreq);
            innerSet.remove(num);
            if (innerSet.isEmpty()) {
                fc_set_map.remove(numFreq);
            }
        }
        freqSet.add(num);
        fc_set_map.put(newFreq, freqSet);
    }

    private static void deleteNum(int num,
                        Map<Integer, Integer> cf_map,
                        Map<Integer, Set<Integer>> fc_set_map) {
        Integer freq = cf_map.get(num);
        if (freq == null) {
            return;
        }
        Set<Integer> currentSet = fc_set_map.get(freq);
        if (currentSet != null) {
            currentSet.remove(num);
            if (currentSet.isEmpty()) {
                fc_set_map.remove(freq);
            }
        }
        int newFreq = freq - 1;
        if (newFreq == 0) {
            cf_map.remove(num);
        } else {
            cf_map.put(num, newFreq);
            fc_set_map.computeIfAbsent(newFreq, k -> new HashSet<>())
                    .add(num);
        }
    }

    private static void checkNum(int freq,
            Map<Integer, Set<Integer>> fc_set_map,
            List<Integer> res) {
        if (fc_set_map.containsKey(freq)) {
            res.add(1);
        } else {
            res.add(0);
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> queries = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(3, 2),
                Arrays.asList(1, 4),
                Arrays.asList(1, 5),
                Arrays.asList(1, 5),
                Arrays.asList(1, 4),
                Arrays.asList(3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 2)
        );

        List<Integer> ans = freqQuery(queries);

        for (Integer val : ans) {
            System.out.println(val);
        }
    }
}
