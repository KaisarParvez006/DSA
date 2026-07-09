//c
class Solution {

    public int findJudge(int n, int[][] trust) {

        //for storing how many people trust each person
        int[] inDegree = new int[n + 1];

        //for-> how many people each person trusts
        int[] outDegree = new int[n + 1];

        for (int[] edge : trust) {

            int from = edge[0];
            int to = edge[1];

            outDegree[from]++;
            inDegree[to]++;
        }

        for (int i = 1; i <= n; i++) {

            if (inDegree[i] == n - 1 && outDegree[i] == 0) 
                return i;
        }
        return -1;
    }
}