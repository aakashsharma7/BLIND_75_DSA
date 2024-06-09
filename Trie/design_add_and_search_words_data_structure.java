class WordDictionary {
      // TrieNode class definition
    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26]; // 26 letters in the English alphabet
            isEndOfWord = false;
        }
    }

    // Root of the Trie
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    // Helper function to search in the Trie recursively
    private boolean searchInNode(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char c = word.charAt(index);
        if (c == '.') {
            // If the character is '.', check all possible nodes at this level
            for (TrieNode child : node.children) {
                if (child != null && searchInNode(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            // If the character is not '.', proceed with the normal letter
            int charIndex = c - 'a';
            return searchInNode(word, index + 1, node.children[charIndex]);
        }
    }

    // For testing purposes
    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad")); // false
        System.out.println(obj.search("bad")); // true
        System.out.println(obj.search(".ad")); // true
        System.out.println(obj.search("b..")); // true
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
