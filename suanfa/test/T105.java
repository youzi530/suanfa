package suanfa.test;

import java.util.HashMap;
import java.util.Map;

public class T105 {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        Map<Integer,Integer> inMap = new HashMap<>(inLen);
        for (int i = 0; i < inLen; i++) {
            inMap.put(inorder[i],i);
        }

        return build(preorder,0,preLen-1 ,inMap,0,inLen-1);
    }

    private TreeNode build(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> inMap, int inLeft, int inRight) {
        if(preLeft > preRight || inLeft > inRight){
            return null;
        }

        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);
        int pIndex = inMap.get(rootValue);

        root.left = build(preorder,preLeft +1, pIndex - inLeft + preLeft,inMap,inLeft,pIndex-1);
        root.right = build(preorder,(pIndex - inLeft + preLeft+1), preRight, inMap, (pIndex+1), inRight);
        return root;
    }
}
