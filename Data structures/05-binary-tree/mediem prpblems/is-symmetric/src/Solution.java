import java.util.Objects;

class Solution {

    // O(n). Think like preorder traversal
    boolean is_mirror(TreeNode first, TreeNode second) {
        if (first ==null && second ==null)
            return true;

        if (( first==null && second!=null) || (first!=null && second==null) || !Objects.equals(first.data.num, second.data.num))
            return false;	// one subtree only or different values

        // 2 trees will have 4 sub-trees. We need to make sure of 2 mirroring
        return is_mirror(first.left, second.right) && is_mirror(first.right, second.left);
    }


    boolean isSymmetric(TreeNode root) {
        if(root ==null)
            return true;

        return is_mirror(root.left, root.right);
    }
};
