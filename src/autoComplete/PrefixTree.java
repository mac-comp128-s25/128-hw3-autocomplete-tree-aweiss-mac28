package autoComplete;

import java.util.ArrayList;
import java.util.Map;

/**
 * A prefix tree used for autocompletion. The root of the tree just stores links to child nodes (up to 26, one per letter).
 * Each child node represents a letter. A path from a root's child node down to a node where isWord is true represents the sequence
 * of characters in a word.
 */
public class PrefixTree {
    private TreeNode root; 

    // Number of words contained in the tree
    private int size;

    public PrefixTree(){
        root = new TreeNode();
    }

    /**
     * Adds the word to the tree where each letter in sequence is added as a node
     * If the word, is already in the tree, then this has no effect.
     * @param word
     */
    public void add(String word){
        ArrayList<Character> charList = convertToChar(word);
        TreeNode traversalNode = root;
        for(char chars:charList){
            TreeNode newNode = new TreeNode();
            newNode.letter = chars;
            if(!traversalNode.children.containsKey(chars)){
            traversalNode.children.put(newNode.letter, newNode);
            traversalNode = traversalNode.children.get(newNode.letter);
            }
            else{
                traversalNode.children.get(newNode.letter);
            }
        }
        if(traversalNode.isWord==false){
            traversalNode.isWord = true;
            size++;
        }
    }

    /**
     * Checks whether the word has been added to the tree
     * @param word
     * @return true if contained in the tree.
     */
    public boolean contains(String word){
        TreeNode traversalNode = root;
        ArrayList<Character> charList = convertToChar(word);
        for(char chars:charList){
            if(traversalNode.children.containsKey(chars)){
                traversalNode = traversalNode.children.get(chars);
            }
        }
        return traversalNode.isWord;
    }

    /**
     * Finds the words in the tree that start with prefix (including prefix if it is a word itself).
     * The order of the list can be arbitrary.
     * @param prefix
     * @return list of words with prefix
     */
    public ArrayList<String> getWordsForPrefix(String prefix){
        //TODO: complete me
        /*
         * notes for later:
         * traverse down to the place where the prefix ends
         * for each node that exists connected to it:
         * traverse down to the bottom of each, splitting off when necessary
         */
        return null;
    }

    /**
     * @return the number of words in the tree
     */
    public int size(){
        return size;
    }
    /*
     * Converts a string into an ArrayList of characters
     * @param word
     * @return list of characters in word
     */
    private ArrayList<Character> convertToChar(String word){
        ArrayList<Character> charList = new ArrayList<>();
        for(int i = 0; i<word.length(); i++){
            charList.add(word.charAt(i));
        }
        return charList;
    }
    
}
