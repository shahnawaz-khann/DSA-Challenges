class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        boolean isOdd = false;
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for(int freq : map.values()) {
            if(freq % 2 == 0) {
                count += freq;
            }
            else {
                count += freq - 1;
                isOdd = true;
            }
        }
        return isOdd ? count + 1 : count;
    }
}