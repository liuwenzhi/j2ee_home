package com.duomu;

/**
 * 二叉树节点类
 */
class Node{
    private int value;
    private Node left;
    private Node right;

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

}

public class Main {
    /**
     * 判断二叉树是否平衡的方法
     *
     * @param node 根节点
     */
    private static boolean pingheng(Node node){
        //没有左右孩子节点，返回true
        if(node.getLeft()==null&&node.getRight()==null){
            return true;
        }
        //只有一个子节点的情况，返回false
        if(node.getLeft()!=null&&node.getRight()==null||node.getLeft()==null&&node.getRight()!=null){
            return false;
        }
        //第一步：根节点左右节点相等
        if(node.getLeft().getValue()!=node.getRight().getValue()){
            return false;
        }else{
            //逐层遍历每一层
            diguipingheng(node.getLeft(),node.getRight());
        }
        //如果逐层遍历没有报false，则返回true
        return true;
    }

    private static boolean diguipingheng(Node node1,Node node2){
        //递归出口
        if(node1.getLeft()==null&&node1.getRight()==null||node2.getLeft()==null&&node2.getRight()==null){
            return true;
        }
        if(node1.getLeft()!=null&&node2.getRight()==null|| node1.getRight()!=null&&node2.getLeft()==null){
            return false;
        }
        if(node1.getLeft()==null&&node2.getRight()!=null||node1.getRight()==null&&node2.getLeft()!=null){
            return false;
        }
        //根节点是左右节点相等，判断其他节点是对称相等
        if(node1.getLeft().getValue()!=node2.getRight().getValue()){
            return false;
        }
        if(node1.getRight().getValue()!=node2.getLeft().getValue()){
            return false;
        }
        //使用递归方式分别遍历子树
        return diguipingheng(node1.getLeft(),node2.getRight()) && diguipingheng(node1.getRight(),node2.getLeft());

    }


    public static void main(String[] args){

    }


}
