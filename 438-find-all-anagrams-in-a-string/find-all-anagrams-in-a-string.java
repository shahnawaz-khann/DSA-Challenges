class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        if(s.length() < p.length()) {
            return list;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        for(char c : p.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<p.length(); i++) {
            char c = s.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        for(int i = p.length(); i<s.length(); i++) {
            if(map1.equals(map2)) {
                list.add(left);
            }
            map2.put(s.charAt(left), map2.getOrDefault(s.charAt(left), 0) - 1);
            if(map2.get(s.charAt(left)) == 0) {
                map2.remove(s.charAt(left));
            }
            left++;
            map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);
        }
        //final last check
        if(map1.equals(map2)) {
            list.add(left);
        }
        return list;
    }
}