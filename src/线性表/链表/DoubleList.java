package 线性表.链表;

/**
 * Auther: dyh
 * Date: 2020/4/8 20:26
 * Description:双向链表
 */
public class DoubleList {
    public static void main(String[] args) {


    }
    private Node first;
    private Node last;
    private int size;
    private static  class Node{
        Node prev;
        Node next;
        Object data;

        public  Node(Node prev,Object data,Node next){
            this.prev=prev;
            this.next=next;
            this.data=data;
        }

    }

    public void  add(int index,Object data ){
        check(index);
        Node node = getNode(index);
        //尾部插入
        if(index==size){

        }else {

        }
    }

    //根据位置获取node
    private Node getNode(int index) {

       if(index<(size>>1)){
           Node x = this.first;
           for(int i=0;i<index;i++){
               x=x.next;
           }
           return x;
       }else {
           Node x = this.last;
           for(int i=size-1;i>index;i--){
               x=x.prev;
           }
           return x;
       }

    }

    private void check(int index) {
        if(index<0|| index>size){
            throw new RuntimeException("插入位置错误");
        }


    }


}
