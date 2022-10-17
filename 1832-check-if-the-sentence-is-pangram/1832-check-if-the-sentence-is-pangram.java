class Solution {
    public boolean checkIfPangram(String sentence) {
        int [] counter = new int[26];
        for(char c: sentence.toCharArray()) {
            counter[c - 'a']++;
        }
        
        for(int count:counter) {
            if(count == 0) return false;
        }
        
        return true;
    }
}