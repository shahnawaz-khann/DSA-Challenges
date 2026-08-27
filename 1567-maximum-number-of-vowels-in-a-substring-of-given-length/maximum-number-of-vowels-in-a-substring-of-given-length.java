class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        int max = 0; int count = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if(isVowel(c)) {
                count++;
            }
            if(right - left + 1 > k) {
                if(isVowel(s.charAt(left))) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}