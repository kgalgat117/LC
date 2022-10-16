class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> mapping = new HashMap<String, ArrayList<String>>();
        
        for (int i =0; i < strs.length;i++) {
            char [] strArr = strs[i].toCharArray();
            Arrays.sort(strArr);
            String sorted = new String (strArr);
            
            ArrayList<String> group = mapping.getOrDefault(sorted, new ArrayList<String>());
            group.add(strs[i]);
            mapping.put(sorted, group);
        }
        
        return new ArrayList<>(mapping.values());
    }
}