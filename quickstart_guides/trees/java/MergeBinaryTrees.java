/*
 *   Title: Merge binary trees.
 *
 * Problem:
 *   Given two binary trees and imagine that when you put one of them to cover
 *   the other, some nodes of the two trees are overlapped while the others are
 *   not.
 *
 *   You need to merge them into a new binary tree. The merge rule is that if two
 *   nodes overlap, then sum node values up as the new value of the merged node.
 *   Otherwise, the NOT null node will be used as the node of new tree.
 *
 *   Execution: javac MergeBinaryTrees.java && java MergeBinaryTrees
 */
import java.util.*;


class MergeBinaryTrees {

    public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
   }

    public TreeNode mergeBinaryTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeBinaryTrees(t1.left, t2.left);
        t1.right = mergeBinaryTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String args[])
    {
        MergeBinaryTrees mbt = new MergeBinaryTrees();

        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(3);
        tree1.right = new TreeNode(2);
        tree1.left.left = new TreeNode(5);

        TreeNode tree2 = new TreeNode(2);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(3);
        tree2.left.right = new TreeNode(4);
        tree2.right.right = new TreeNode(7);

        System.out.println(mbt.mergeBinaryTrees(tree1, tree2));

        System.out.println("Passed all test cases");
    }
}