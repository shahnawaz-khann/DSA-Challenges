class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (a, b) -> {
            if(!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);
            }
            return a.compareTo(b);
        });

        List<String> ans = new ArrayList<>();
        for(int i=0; i<k; i++) {
            ans.add(list.get(i));
        }
        return ans;
    }
}