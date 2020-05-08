package 二叉树;

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
        tree.InOrderTraverse(tree);

    }
    T data;
    BinaryTree<T>  left;
    BinaryTree<T>  right;

    BinaryTree(T data, BinaryTree<T> left, BinaryTree<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    //先序遍历
    public void InOrderTraverse(BinaryTree tree){
        if(tree!=null){
            //访问根节点
            System.out.println(tree.data);
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
            InOrderTraverse(tree.left);
            //访问根节点
            System.out.println(tree.data);
            //中序遍历右子树
            InOrderTraverse(tree.right);
        }
    }

    //后续遍历

    public void InOrderTraverse3(BinaryTree tree){
        if(tree!=null){
            InOrderTraverse(tree.left);
            InOrderTraverse(tree.right);
            System.out.println(tree.data);
        }
    }
}
