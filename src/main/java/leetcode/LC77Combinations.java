package leetcode;

import java.util.ArrayList;
import java.util.List;

class LC77Combinations {

    public static void main(String[] args) {
        LC77Combinations obj = new LC77Combinations();
        System.out.println(obj.combine(6, 4));
    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        rec(n, k, 0, 0, new ArrayList<>());
        return ans;
    }

    private void rec(int n, int k, int I, int counter, List<Integer> list) {
        if (counter == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = I + 1; i <= n; i++) {
            list.add(i);
            rec(n, k, i, counter + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
