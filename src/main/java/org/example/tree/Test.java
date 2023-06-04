package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test {
    /**
     * largest element in tree
     * @param root TreeNode
     * @return int
     */
    static int largetElement(TreeNode<Integer> root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int ans=root.data;
        for(int i=0;i<root.children.size();i++){
            int largest=largetElement(root.children.get(i));
            if(largest>ans){
                ans=largest;
            }
        }
        return ans;
    }
    /**
     * count how many nodes are in tree
     * @param root TreeNode
     * @return int
     */
    static int numberOfNode(TreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int count=1;
        for(int i=0;i<root.children.size();i++){
            count+=numberOfNode(root.children.get(i));
        }
        return count;
    }
    /**
     * Teke tree input level wise
     * @return TreeNode
     */
    static TreeNode<Integer> takeInputLevelWise(){
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the root data: ");
        int n=s.nextInt();
        TreeNode<Integer> root=new TreeNode<>(n);
        Queue<TreeNode<Integer>> pendingNodes=new LinkedList<>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()){
            TreeNode<Integer> frontNode=pendingNodes.remove();
            System.out.print("Enter the number of children  " +frontNode.data +" : ");
            int noc=s.nextInt();
            for(int i=0;i<noc;i++){
                System.out.print("Enter the "+(i+1)+" th child of " +frontNode.data+" : ");
                int child=s.nextInt();
                TreeNode<Integer> childNode=new TreeNode<>(child);
                frontNode.children.add(childNode);
                pendingNodes.add(childNode);
            }
        }
        return root;
    }

    /**
     * print the tree level wise
     * @param root TreeNode
     */
    static void printLevelWise(TreeNode<Integer> root){
        if(root==null){
            return;
        }
        Queue<TreeNode<Integer>> pendingNodes=new LinkedList<>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()){
            TreeNode<Integer> front=pendingNodes.remove();
            System.out.print(front.data+": ");
            for (int i=0;i<front.children.size();i++){
                pendingNodes.add(front.children.get(i));
                if(i==front.children.size()-1){
                    System.out.print(front.children.get(i).data);
                }else {
                    System.out.print(front.children.get(i).data+",");
                }
            }
            System.out.println();
        }
    }
    /**
     * Take the tree input
     * @return TreeNode
     */
     static TreeNode<Integer>  takeInput(Scanner s){
        int n;
         System.out.print("Enter the next node :");
         n=s.nextInt();
         TreeNode<Integer> root=new TreeNode<Integer>(n);
         System.out.print("Enter the number of child of" +n +" : ");
         int noc=s.nextInt();
         for(int i=0;i<noc;i++){
             TreeNode<Integer> child=takeInput(s);
             root.children.add(child);
         }
         return root;
    }

    /**
     * print the tree
     * @param root void
     */
    static void printTree(TreeNode<Integer> root){
         String s=root.data+":";
         for(int i=0;i<root.children.size();i++){
             s+=root.children.get(i).data+",";
         }
        System.out.println(s);
        for(int i=0;i<root.children.size();i++){
           printTree(root.children.get(i));
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
//         TreeNode<Integer> root=takeInput(s);
//        System.out.println();
//        printTree(root);
        TreeNode<Integer> root=takeInputLevelWise();
        printLevelWise(root);
        System.out.println("Number of nodes is : "+numberOfNode(root));
        System.out.println("Largest Element : "+largetElement(root));
    }
}
