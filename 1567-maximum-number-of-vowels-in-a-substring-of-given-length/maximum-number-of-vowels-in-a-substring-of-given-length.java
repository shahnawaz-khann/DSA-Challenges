class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        int max = 0; int count = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if("aeiou".indexOf(c) != -1) {
                count++;
            }
            if(right - left + 1 > k) {
                if("aeiou".indexOf(s.charAt(left)) != -1) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}