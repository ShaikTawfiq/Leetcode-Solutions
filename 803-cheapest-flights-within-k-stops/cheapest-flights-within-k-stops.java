 import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] p = new int[n];
        Arrays.fill(p, (int) 1e9);
        p[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = p.clone();
            for (int[] f : flights)
                if (p[f[0]] != (int) 1e9)
                    temp[f[1]] = Math.min(temp[f[1]], p[f[0]] + f[2]);
            p = temp;
        }

        return p[dst] == (int) 1e9 ? -1 : p[dst];
    }
}