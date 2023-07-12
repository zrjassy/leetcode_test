package com.Learn.JavaLearn;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-05-26 09:11
 **/
public class test6 {
    public static void main(String[] args) {

    }

    static class Trie {
        private boolean isLast;
        private Trie[] children;

        public Trie() {
            children = new Trie[26];
            isLast = false;
        }

        public void insert(String word) {
            Trie node = this;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch -'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isLast = true;
        }

        public boolean search(String word) {
            Trie node = startsWithPrefix(word);
            return node != null && node.isLast;
        }

        public boolean startsWith(String prefix) {
            return startsWithPrefix(prefix) != null;
        }

        public Trie startsWithPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);

                if (node.children[ch - 'a'] == null) {
                    return null;
                }
                node = node.children[ch - 'a'];
            }
            return node;
        }
    }
}
