class Trie {
    
    boolean endOfWord; 
    Trie[] prefixTree;
    Trie head;
    
    public Trie() {
      endOfWord = false;
      prefixTree = new Trie[26];
                
    }
    
    public void insert(String word) {
        int size = word.length();
        if(prefixTree[word.charAt(0) - 'a'] == null){ prefixTree[word.charAt(0) - 'a'] = new Trie();}
        Trie pointer = prefixTree[word.charAt(0) - 'a'];
        for(int i = 1; i < size; i++){
            if(pointer.prefixTree[word.charAt(i) - 'a'] == null){ pointer.prefixTree[word.charAt(i) - 'a'] = new Trie(); }
            pointer = pointer.prefixTree[word.charAt(i) - 'a'];
        }
        pointer.endOfWord = true;
    }
    
    public boolean search(String word) {
       if(prefixTree[word.charAt(0)- 'a'] == null){return false;}
       else{
           int len = word.length();
           int counter = 1;
           Trie pointer = prefixTree[word.charAt(0) - 'a'];
           while( counter < len && pointer != null && (pointer.endOfWord != true ||  pointer.prefixTree[word.charAt(counter) - 'a'] != null)){ 
               pointer = pointer.prefixTree[word.charAt(counter) - 'a']; 
               counter++;
               }
           return (pointer != null && pointer.endOfWord == true && counter == len) ? true : false; 
       } 
    }
    
    public boolean startsWith(String prefix) {
        if(prefixTree[prefix.charAt(0) - 'a'] == null){return false;}
        else{
            int len = prefix.length();
            int counter = 1;
            Trie pointer = prefixTree[prefix.charAt(0) - 'a'];
            while(counter < len  && pointer != null && pointer.prefixTree[prefix.charAt(counter) - 'a'] != null){ 
               pointer = pointer.prefixTree[prefix.charAt(counter) - 'a']; 
               counter++;
               }
            return (counter >= len) ? true : false;    
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */