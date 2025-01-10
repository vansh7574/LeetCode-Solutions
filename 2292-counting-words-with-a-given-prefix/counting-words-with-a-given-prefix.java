public class Trie{
  
  class Node 
  {
    Node[] links;
    int count = 0;

    Node() 
    {
        links = new Node[26];
        int count = 0;
    }

  }
  Node root;
  Trie()
  {
    root = new Node();
  }

  void addWord(String word)
  {
    Node pointer = root;
    for(char ch : word.toCharArray())
    {
        if(pointer.links[ch - 'a'] == null)
        {
            pointer.links[ch - 'a'] = new Node();
            
        }
        pointer = pointer.links[ch - 'a'];
        pointer.count++;    
    }
  }

  int countWords(String prefix)
  {
    Node pointer = root;
    
    for(char ch : prefix.toCharArray())
    {
        if(pointer.links[ch -'a'] == null)
        {
            return 0;
        }
        
        
        pointer = pointer.links[ch - 'a'];

            
    }
    return pointer.count;
  }

}


class Solution {
    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        for(String word : words)
        {
            trie.addWord(word);

        }

        return trie.countWords(pref);
    }
}