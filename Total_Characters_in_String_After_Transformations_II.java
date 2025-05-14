import java.util.*;

class Solution {
    static final int MOD = (int)1e9 + 7;
    static final int SIZE = 26;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[] freq = new long[SIZE];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        long[][] mat = new long[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            int count = nums.get(i);
            for (int j = 0; j < count; j++) {
                mat[(i + 1 + j) % SIZE][i] = (mat[(i + 1 + j) % SIZE][i] + 1) % MOD;
            }
        }

        long[][] matT = matrixPower(mat, t);

        long[] result = new long[SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result[i] = (result[i] + matT[i][j] * freq[j]) % MOD;
            }
        }

        long total = 0;
        for (int i = 0; i < SIZE; i++) {
            total = (total + result[i]) % MOD;
        }

        return (int)total;
    }

    private long[][] matrixPower(long[][] base, int exp) {
        long[][] res = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) res = multiply(res, base);
            base = multiply(base, base);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        long[][] res = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int k = 0; k < SIZE; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < SIZE; j++) {
                    res[i][j] = (res[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return res;
    }
}
