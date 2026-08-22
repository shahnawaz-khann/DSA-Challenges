class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] freq = new int[26];

        for(int i=0; i<magazine.length(); i++) {
            if(i < ransomNote.length()) {
                freq[ransomNote.charAt(i) - 'a']--;
            }
            freq[magazine.charAt(i) - 'a']++;
        }
        for(int x : freq) {
            if(x <= -1) {
                return false;
            }
        }
        return true;
    }
}