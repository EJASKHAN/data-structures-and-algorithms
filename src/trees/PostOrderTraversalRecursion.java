package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ejaskhan
 **/
public class PostOrderTraversalRecursion {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        node3.right = node4;
        root.left = null;
        root.right = node3;

        postOrderTraversal(root).stream().forEach(ele -> System.out.println(ele));

    }

    public static List<Integer> postOrderTraversal(TreeNode root) {

        List<Integer> returnList = new ArrayList<>();
        postOrderHelper(root, returnList);
        return returnList;
    }

    public static void postOrderHelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            postOrderHelper(node.left, list);
        }

        if (node.right != null) {
            postOrderHelper(node.right, list);
        }
        list.add(node.val);

    }
}


