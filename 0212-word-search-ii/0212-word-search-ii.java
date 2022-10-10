class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List <String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                traverse(result, root, board, i, j);
            }
        }
        
        return result;
    }
    
    public void traverse(List<String> result, TrieNode root, char[][] board, int i, int j) {
        char c = board[i][j];
        if (c == '#' || root.next[c - 'a'] == null) return;
        root = root.next[c - 'a'];
        
        if(root.word != null) {
            result.add(root.word);
            root.word = null;
        }
        
        board[i][j] = '#';
        if (i > 0) traverse(result, root, board, i - 1, j);
        if (i < board.length - 1) traverse(result, root, board, i + 1, j);
        if (j < board[0].length - 1) traverse(result, root, board, i, j + 1);
        if (j > 0) traverse(result, root, board, i, j - 1);
        board[i][j] = c;
    }
    
    public TrieNode buildTrie (String [] words) {
        TrieNode root = new TrieNode();
        
        for (String word:words) {
            TrieNode p = root;
            for (char ch: word.toCharArray()) {
                int i = ch - 'a';
                if (p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = word;
        }
        
        return root;
    }
}

class TrieNode {
    TrieNode [] next = new TrieNode[26];
    String word;
}