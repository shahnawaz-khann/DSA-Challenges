class Solution {
    public int totalFruit(int[] nums) { //i changes fruits[] to nums[]
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int max = 0;

        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while(map.size() > 2) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}