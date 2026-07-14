class Solution {
    public String frequencySort(String s) {
        char[] str = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for(char c : str) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());

        list.sort(
            (a, b) -> map.get(b) - map.get(a)
        );

        StringBuilder sb = new StringBuilder();

        for(char c : list) {
            for(int i=0; i<map.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}