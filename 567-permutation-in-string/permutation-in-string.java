class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i=0; i<s1.length(); i++) {
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int window = s1.length();

        for(int right = 0; right < s2.length(); right++) {
            char ch = s2.charAt(right);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);

            if(right - left + 1 > window) {
                map2.put(s2.charAt(left), map2.get(s2.charAt(left)) - 1);
                if(map2.get(s2.charAt(left)) == 0) {
                    map2.remove(s2.charAt(left));
                }
                left++;
            }
            if(right - left + 1 == window && map1.equals(map2)) {
                return true;
            }

        }
        return false;
    }
}