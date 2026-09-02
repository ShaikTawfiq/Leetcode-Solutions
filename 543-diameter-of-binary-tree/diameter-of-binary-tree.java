class Solution {
    private int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    private int depth(TreeNode root){
        if(root == null) 
        return 0;
        int L= depth(root.left), R= depth(root.right);
        max = Math.max(max, L+R);
        return 1 + Math.max(L,R);
            }
}