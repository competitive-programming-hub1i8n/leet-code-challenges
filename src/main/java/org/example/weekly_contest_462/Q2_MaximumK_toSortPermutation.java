package org.example.weekly_contest_462;

import java.util.*;

public class Q2_MaximumK_toSortPermutation {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        if (isSorted(nums)) return 0;
        int maxVal = n - 1;
        for (int k = maxVal; k >= 0; k--) {
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((nums[i] & nums[j]) == k) {
                        uf.union(i, j);
                    }
                }
            }
            if (canSort(nums, uf)) {
                return k;
            }
        }
        return 0;
    }

    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) return false;
        }
        return true;
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // compresión de caminos
            }
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return;
            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }

    private boolean canSort(int[] nums, UnionFind uf) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            groups.computeIfAbsent(root, v -> new ArrayList<>()).add(i);
        }

        for (List<Integer> indices : groups.values()) {
            List<Integer> valsOriginal = new ArrayList<>();
            List<Integer> valsSorted = new ArrayList<>();
            for (int idx : indices) {
                valsOriginal.add(nums[idx]);
                valsSorted.add(sorted[idx]);
            }
            Collections.sort(valsOriginal);
            Collections.sort(valsSorted);
            if (!valsOriginal.equals(valsSorted)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Q2_MaximumK_toSortPermutation obj = new Q2_MaximumK_toSortPermutation();
        System.out.println(obj.sortPermutation(new int[]{0,3,2,1}));
    }
}
