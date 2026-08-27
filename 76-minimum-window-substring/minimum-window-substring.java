class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }
        int[] mapS = new int[128];
        int[] mapT = new int[128];

        for(char c : t.toCharArray()) {
            mapT[c]++;
        }

        int minWindow = Integer.MAX_VALUE;
        int left = 0;
        int minStart = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            mapS[c]++;

            while(contains(mapS, mapT)) {
                if(right - left + 1 < minWindow) {
                    minWindow = right - left + 1;
                    minStart = left;
                }
                mapS[s.charAt(left++)]--;
            }
        }
        return minWindow == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minWindow);
    }
    private boolean contains(int[] mapS, int[] mapT) {
        for(int i=0; i<128; i++) {
            if(mapT[i] > mapS[i]) {
                return false;
            }
        }
        return true;
    }
}