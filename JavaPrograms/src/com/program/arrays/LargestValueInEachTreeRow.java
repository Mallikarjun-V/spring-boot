package com.program.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * You need to find the largest value in each row of a binary tree.
 * 
 * Example
 * 
 * input: 1 | | 3 2 | | | 5 3 9
 * 
 * output: [1, 3, 9]
 * 
 * @author MALLIKARJUN
 *
 */
public class LargestValueInEachTreeRow {
    
    /**
     * Definition for a binary tree node
     * 
     * @author MALLIKARJUN
     *
     */
    static class TreeNode {
        int      value;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            value = x;
        }
    }
    
    static List<Integer> largestValues(TreeNode root) {
        List<Integer> larget_vals = new ArrayList<>();
        helper_methd(root, larget_vals, 0);
        return larget_vals;
    }
    
    private static void helper_methd(TreeNode root, List<Integer> larget_vals, int level) {
        if (root == null)
            return;
        if (level == larget_vals.size()) {
            larget_vals.add(root.value);
        } else {
            larget_vals.set(level, Math.max(larget_vals.get(level), root.value));
        }
        helper_methd(root.left, larget_vals, level + 1);
        helper_methd(root.right, larget_vals, level + 1);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        
        root.right.right = new TreeNode(9);
        
        List<Integer> larhet_values = largestValues(root);
        System.out.println(larhet_values);
    }
}
