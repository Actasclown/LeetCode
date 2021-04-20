package com.aac.q0589.narytreepreordertraversal;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import com.aac.datastructure.Node;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> preorder(Node root) {
        if(root == null)
            return new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        res.add(root.val);
        for(Node child : root.children) {
            List<Integer> tmp = preorder(child);
            for(int i : tmp) {
                res.add(i);
            }
        }
        return res;
    }
}