package 二叉树;

import java.util.List;
import java.util.Stack;

/**
 * Auther: dyh
 * Date: 2020/5/8 20:15
 * Description:
 */
public class BinaryTree<T> {
    public static void main(String[] args) {
        BinaryTree<Integer> right = new BinaryTree<Integer>(3,null,null);
        BinaryTree<Integer> left = new BinaryTree<Integer>(4,null,null);
        BinaryTree<Integer> tBinaryTree =  new BinaryTree<Integer>(1, left, right);
        BinaryTree<Integer> tree =  new BinaryTree<Integer>(4, tBinaryTree, right);
//        tree.InOrderTraverse2(tree);
//        System.out.println("==========");
//        tree.InOrderTraverse4(tree);
        BinaryTree<Object> tree1 = new BinaryTree<>();
        String[] data={"A","B","C","#","#","D","E","#","G","#","#","F","#","#","#"};
        tree1.create(data,tree1,0);
        tree1.InOrderTraverse(tree1);
    }
    T data;
    BinaryTree<T>  left;
    BinaryTree<T>  right;
    BinaryTree(){}

    BinaryTree(T data, BinaryTree<T> left, BinaryTree<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    //先序遍历
    public void InOrderTraverse(BinaryTree tree){
        if(tree!=null){
            //访问根节点
            System.out.print(tree.data);
            //先序遍历左子树
            InOrderTraverse(tree.left);
            //先序遍历右子树
            InOrderTraverse(tree.right);
        }
    }

    //中序遍历
    public void InOrderTraverse2(BinaryTree tree){
        if(tree!=null){
             //中序遍历左子树
            InOrderTraverse2(tree.left);
            //访问根节点
            System.out.print(tree.data);
            //中序遍历右子树
            InOrderTraverse2(tree.right);
        }
    }

    //后续遍历

    public void InOrderTraverse3(BinaryTree tree){
        if(tree!=null){
            InOrderTraverse3(tree.left);
            InOrderTraverse3(tree.right);
            System.out.println(tree.data);
        }
    }
    //非递归中序遍历
    public void InOrderTraverse4(BinaryTree tree){
        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        BinaryTree p=tree;
        while (p!=null||!stack.empty()){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }else {
                BinaryTree pop = stack.pop();
                System.out.println(pop.data);
                p=pop.right;
            }
        }
    }

    //先序遍历的顺序建立二叉树
    public  int create(String[] treedats,BinaryTree tree,int n){

        if("#".equals(treedats[n])){
            return n+1;
        }else {

            tree.data = treedats[n];
            tree.left=new BinaryTree<Integer>();
            int left = create(treedats, tree.left, n + 1);
            tree.right=new BinaryTree<Integer>();
            int right = create(treedats, tree.right, left);
            return right;
        }

    }

}
