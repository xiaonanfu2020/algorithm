/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTrees(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    private TreeNode buildTrees(int[] inorder,int[] postorder,int s1,int e1,int s2,int e2) {
        if(s1>e1 || s2>e2) {
            return null;
        }
        int index = findRoot(inorder,s1,e1,postorder[e2]);
        if (index ==-1) {
            return null;
        }
        //后序遍历的尾为树的根节点
        TreeNode root = new TreeNode(postorder[e2]);
        // 找到中序遍历中根节点所在位置
        
        // root拆分后 中序遍历和后序遍历的 左右子树长度应该是一样的
        // 根节点的左子树 中序遍历从s1 到 index-1，后序遍历的是 s2到 中序左子树长度
        root.left = buildTrees(inorder,postorder,s1,index-1,s2,s2+index-1-s1);
        //根节点的柚子树  中序遍历从index+1 到 e1, 后序遍历是  中序左子树长度+1
        root.right = buildTrees(inorder, postorder, index+1, e1, s2+index-s1, e2-1);
        return root;
    }

    private int findRoot(int[] inorder,int s1,int e1,int target) {
        for(int i=s1;i<=e1;i++) {
            if(inorder[i] == target){
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

