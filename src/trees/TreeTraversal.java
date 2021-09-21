package trees;

import javax.transaction.TransactionRequiredException;
import java.util.*;

/**
 * @author Ejaskhan
 **/
public class TreeTraversal {


    /**
     * logic:
     * step 1: push the node to stack
     * step 2:  loop till the stack is empty: pop the node ,
     * print the value,
     * push thr right and left node
     * end
     **/
    public static List<Integer> preOrderTraversalUsingStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        if (root == null) {
            return list;
        }

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode ele = stack.pop();
            list.add(ele.val);

            //add left and right child
            if (ele.right != null) {
                stack.push(ele.right);
            }
            if (ele.left != null) {
                stack.push(ele.left);
            }
        }

        return list;
    }

    /**
     * step1: set the root as current
     * step2: loop till the current node is null and stack is empty:
     * loop till the left of current is null
     * push the current
     * set the current as current.left
     * end
     * step3: pop from the stack and set it as current //here we are already traversed the left of the node
     * print the value of the node.
     * set current.right as current.
     * <p>
     * <p>
     * 1
     * 2 				3
     * 4 		5 		6		7
     * <p>
     * 9
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        if (root == null) {
            throw new NullPointerException();
        }
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {


            if (current != null) {
                stack.push(current);
                current = current.left;

            } else {
                current = stack.pop();
                list.add(current.val);
                current = current.right;
            }
/* //this will also work
             while(current !=null)
            {
                stack.push(current);
                current =current.left;

            }
            current = stack.pop();
            list.add(current.val);
            current= current.right;*/

        }
        return list;
    }


    /**
     * The ArrayDeque class is the resizable array implementation of the Deque interface
     * and LinkedList class is the list implementation
     * <p>
     * pre-order traversal with right child visited first and then inserting into stack in reverse order
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversalUsingTwoStacks(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        LinkedList<Integer> list = new LinkedList<>();


        if (root == null) {
            return list;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode popedNode = stack.pop();
            list.addFirst(popedNode.val);
            if (popedNode.left != null)
                stack.push(popedNode.left);
            if (popedNode.right != null)
                stack.push(popedNode.right);
        }

        return list;

    }


}
