class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        int maxFreq = 0;
        int countMax = 0;

        for(int c : tasks) {
            freq[c - 'A']++;
        }

        for(int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        for(int f : freq) {
            if(f == maxFreq) {
                countMax++;
            }
        }

        int res = (maxFreq - 1) * (n + 1) + countMax;

        return Math.max(res, tasks.length);
    }
}