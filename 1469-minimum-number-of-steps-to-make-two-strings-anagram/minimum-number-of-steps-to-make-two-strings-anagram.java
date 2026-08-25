class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for(char c : s.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for(char c : map2.keySet()) {
            int freqMap2 = map2.get(c);
            
            if(!map.containsKey(c)) {
                count += freqMap2;
            }
            else {
                int freqMap = map.get(c);
                count += Math.max(0, freqMap2 - freqMap);
            }
        }
        return count;
    }
}