package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ejaskhan
 **/
public class PreOrderRecursive {

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


        TreeNode sample = new TreeNode(); //2

        //3
        TreeNode root3 = new TreeNode(1);
        TreeNode r3node1 = new TreeNode();
        TreeNode r3node2 = new TreeNode(2);
        TreeNode r4node3 = new TreeNode(3);
        r3node2.right = r4node3;
        root3.left = null;
        root3.right = r3node2;


        preorderTraversal(root).stream().forEach(ele -> System.out.print(" " + ele));
        System.out.println();
        TreeTraversal.preOrderTraversalUsingStack(root3)
                .stream().forEach(ele -> System.out.print(" " + ele));

    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> returnList = new ArrayList<>();
        preOrderHelper(root, returnList);
        return returnList;
    }

    public static void preOrderHelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left != null) {
            preOrderHelper(node.left, list);
        }
        if (node.right != null) {
            preOrderHelper(node.right, list);
        }
    }
}

