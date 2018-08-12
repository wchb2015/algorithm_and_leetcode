package com.wchb.leetcode;

import java.util.List;
import java.util.TreeMap;

/**
 * @date 8/11/18 2:35 PM
 */
public class FileSystem588Trie {

    private Node root;

    private class Node {

        public boolean isFile;
        public String path;

        public TreeMap<String, Node> next;

        public Node(String path, Boolean isFile) {
            this.path = path;
            this.isFile = isFile;
            next = new TreeMap<>();
        }

    }

    public FileSystem588Trie() {
        root = new Node("/", false);
    }

    public List<String> ls(String path) {

        return null;
    }

    public void mkdir(String path) {

    }

    public void addContentToFile(String filePath, String content) {

    }

    public String readContentFromFile(String filePath) {

        return null;
    }
}
