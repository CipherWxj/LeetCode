package com.company.bishi.oukeyunlian;

public class Main3 {
    static char[] post;
    static char[] infix;
    static StringBuilder res;

    public static String preorderTraversal(String inorderTraversal, String postorderTraversal) {
        // write code here
        infix = new char[inorderTraversal.length()];
        for (int i = 0; i < inorderTraversal.length(); i++) {
            infix[i] = inorderTraversal.charAt(i);
        }
        post = new char[postorderTraversal.length()];
        for (int i = 0; i < postorderTraversal.length(); i++) {
            post[i] = postorderTraversal.charAt(i);
        }
        Node root = build(0, postorderTraversal.length() - 1, 0, inorderTraversal.length() - 1);
        preorder(root);
        return res.toString();
    }

    public static Node build(int hl, int hr, int zl, int zr) {
        if (hl > hr || zl > zr) return null;
        Node root = new Node();
        root.val = post[hr];
        for (int i = zl; i <= zr; i++) {
            if (infix[i] == post[hr]) {
                root.l = build(hl, hr - 1 - (zr - i), zl, i - 1);
                root.r = build(hr - (zr - i), hr - 1, i + 1, zr);
                break;
            }
        }
        return root;
    }

    public static void preorder(Node root) {
        if (root == null) return;
        ;
        res.append(root.val);
        preorder(root.l);
        preorder(root.r);
    }

    public static void main(String[] args) {
        String s1 = "BADC";
        String s2 = "BDCA";
        System.out.println(preorderTraversal(s1, s2));
    }
}

class Node {
    Node l;
    Node r;
    char val;
}
