import java.util.*;

class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        // Build graph only from i -> j where j > i to preserve subsequence order
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (groups[i] != groups[j] &&
                    words[i].length() == words[j].length() &&
                    isHammingOne(words[i], words[j])) {
                    graph[i].add(j);
                }
            }
        }

        // DP to find the longest path starting from each index
        int[] dp = new int[n];         // Length of longest path starting at i
        int[] next = new int[n];       // Next index in longest path
        Arrays.fill(dp, -1);
        Arrays.fill(next, -1);

        int maxLen = 0, start = 0;
        for (int i = 0; i < n; i++) {
            int len = dfs(i, graph, dp, next);
            if (len > maxLen) {
                maxLen = len;
                start = i;
            }
        }

        // Reconstruct the sequence
        List<String> result = new ArrayList<>();
        while (start != -1) {
            result.add(words[start]);
            start = next[start];
        }
        return result;
    }

    private int dfs(int i, List<Integer>[] graph, int[] dp, int[] next) {
        if (dp[i] != -1) return dp[i];

        int maxLen = 1;
        int bestNext = -1;

        for (int nei : graph[i]) {
            int len = 1 + dfs(nei, graph, dp, next);
            if (len > maxLen) {
                maxLen = len;
                bestNext = nei;
            }
        }

        dp[i] = maxLen;
        next[i] = bestNext;
        return dp[i];
    }

    private boolean isHammingOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}
