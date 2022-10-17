class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean [] counter = new boolean[26];
        for(char c: sentence.toCharArray()) {
            counter[c - 'a'] = true;
        }
        
        for(boolean count:counter) {
            if(!count) return false;
        }
        
        return true;
    }
}