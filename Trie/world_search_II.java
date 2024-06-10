class Solution {
    public List<String> findWords(char[][] board, String[] words) {
         List<String> result = new ArrayList<>();
        
        // Build the Trie
        TrieNode root = buildTrie(words);
        
        // Iterate through each cell in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        
        return result;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char c = board[i][j];
        
        // Check boundary conditions and if the cell has been visited
        if (c == '#' || node.next[c - 'a'] == null) return;
        
        // Move to the next Trie node
        node = node.next[c - 'a'];
        
        // If a word is found
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicate entries
        }
        
        // Mark the cell as visited
        board[i][j] = '#';
        
        // Explore the adjacent cells (up, down, left, right)
        if (i > 0) dfs(board, i - 1, j, node, result);
        if (j > 0) dfs(board, i, j - 1, node, result);
        if (i < board.length - 1) dfs(board, i + 1, j, node, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, result);
        
        // Restore the cell
        board[i][j] = c;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.next[index] == null) {
                    node.next[index] = new TrieNode();
                }
                node = node.next[index];
            }
            node.word = word;
        }
        return root;
    }
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
