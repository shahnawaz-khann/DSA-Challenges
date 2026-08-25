class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        boolean isOdd = false;
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for(char c : map.keySet()) {
            if(map.get(c) % 2 == 0) {
                count += map.get(c);
            }
            else {
                count += map.get(c) - 1;
                isOdd = true;
            }
        }
        return isOdd ? count + 1 : count;
    }
}