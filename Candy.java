class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] children = new int[n];

        // Initialize all to 1
        for (int i = 0; i < n; i++) {
            children[i] = 1;
        }

        // Left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                children[i] = children[i - 1] + 1;
            }
        }

        // Right to left (use max)
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                children[i] = Math.max(children[i], children[i + 1] + 1);
            }
        }

        int numberOfCandies = 0;
        for (int i = 0; i < n; i++) {
            numberOfCandies += children[i];
        }

        return numberOfCandies;
    }
}
