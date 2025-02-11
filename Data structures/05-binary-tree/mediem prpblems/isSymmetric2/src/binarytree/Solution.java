package binarytree;


class Solution {

    boolean isSymmetric(TreeNode temp) {
        if (temp == null) return true;
        if (temp.right == null && temp.left == null) return true;
        if (temp.left == null || temp.right == null) return false;

        return parenthesize(temp.left, true).equals(parenthesize(temp.right, false));

    }

    public String parenthesize(TreeNode temp, boolean b) {
        if(temp==null) return "()";
        StringBuilder str =new StringBuilder();

        str.append("(").append(temp.data.str);

        if(b){
            if(temp.left!=null) str.append(parenthesize(temp.left,b));
            else str.append("()");

            if(temp.right!=null) str.append(parenthesize(temp.right,b));
            else str.append("()");

        }
        else{
            if(temp.right!=null) str.append(parenthesize(temp.right,b));
            else str.append("()");

            if(temp.left!=null) str.append(parenthesize(temp.left,b));
            else str.append("()");

        }

        str.append(")");

        return str.toString();
    }
}
