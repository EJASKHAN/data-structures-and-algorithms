package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ejaskhan
 **/
public class InOrderRecursion {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1); //1
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(5);

        TreeNode node7 = new TreeNode(6);
        TreeNode node8 = new TreeNode(7);

        node4.left = node7;
        node4.right = node8;

        node3.left = node5;
        node3.right = node6;

        root.left= node3;
        root.right= node4;


        System.out.println("\nRecursion----------------");
        inOrderTraversal(root).stream().forEach(ele -> System.out.print("-> "+ele));

        System.out.println("\nIterative--------------------");
        TreeTraversal.inorderTraversal(root).stream().forEach(ele -> System.out.print("->"+ele));

    }

    public static List<Integer> inOrderTraversal(TreeNode root) {

        List<Integer> returnList = new ArrayList<>();
        inOrderHelper(root, returnList);
        return returnList;
    }

    public static void inOrderHelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            inOrderHelper(node.left, list);
        }
        list.add(node.val);

        if (node.right != null) {
            inOrderHelper(node.right, list);
        }
    }
}
