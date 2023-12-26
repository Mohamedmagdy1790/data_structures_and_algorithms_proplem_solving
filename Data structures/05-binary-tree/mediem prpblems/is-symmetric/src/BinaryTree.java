// The BinaryTree class

import java.util.Scanner;
public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }
    public BinaryTree(Scanner in) {
        root = buildTree(in);
    }

    public static TreeNode buildTree(Scanner in) {
        Integer num = in.nextInt();
        if (num.equals(-1)) return null;
        TreeNode p = new TreeNode(new NodeData(num));
        p.left = buildTree(in);
        p.right = buildTree(in);
        return p;
    } //end buildTree

    public void preOrder() {
        preOrderTraversal(root);
    }
    public void preOrderTraversal(TreeNode node) {
        if (node!= null) {
            node.data.visit();
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    } //end preOrderTraversal

    public void inOrder() {
        inOrderTraversal(root);
    }

    public void inOrderTraversal(TreeNode node) {
        if (node!= null) {
            inOrderTraversal(node.left);
            node.data.visit();
            inOrderTraversal(node.right);
        }
    } //end inOrderTraversal

    public void postOrder() {
        postOrderTraversal(root);
    }

    public void postOrderTraversal(TreeNode node) {
        if (node!= null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            node.data.visit();
        }
    } //end postOrderTraversal

} //end class BinaryTree
