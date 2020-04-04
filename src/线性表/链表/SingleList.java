package 线性表.链表;

/**
 * Auther: dyh
 * Date: 2020/3/31 22:49
 * Description:
 */
public class SingleList {
    public static void main(String[] args) {
        Node node = new Node(2, null);
        SingleList singleList = new SingleList();
        singleList.initSingleList();
        singleList.add(1,1);
        singleList.add(2,2);
        singleList.add(3,3);
        singleList.add(4,5);
        singleList.add(5,8);
        singleList.printList();
        System.out.println(singleList.size);
        singleList.remove(1);
        System.out.println(singleList.size);
//        System.out.println(singleList.getNode(10));
//        System.out.println( singleList.getindex(0));
        singleList.printList();


    }

    private  Node head;
    private int size;
    private static class Node{
        Object data;
        Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    //头插法
    
    //尾插法


    public void initSingleList(){
       head = new Node(0,null);
        size++;
    }
    //根据值返回位置序号
    public int getindex(Object e){
        Node p=head;
        int j=0;
        while(p!=null&&p.data!=e){
            p=p.next;
            j++;
        }
        return p==null?-1:j;
    }
    public void remove(int i){
        if(i<1||i>size-1){
            System.out.println("非法参数");
            return;
        }
        int j=0;    Node p=head;
        //找到i-1个元素

        while(p.next!=null&&j<i-1){
            p=p.next;
            j++;
        }
        //将ai.next挂到i-1后面
        Node q = p.next ;
        p.next=q.next;
        //释放ai
   q=null;
   size--;
    }

    //按值查找
    public Node  getNode(Object e){
        Node p=head;
        while (p!=null&&p.data!=e){
            p=p.next;
        }
        return p;
    }

    //在第index之前插入元素
    public void add(int index,Object object){


        if(index<1||index>size){
            System.out.println("插入位置错误");
            return;
        }
        //找到第i-1个节点
        int j=0;
        Node p=head;
       while(p!=null && j<index-1){
           p=p.next;
           j++;
       }

        //将node节点的next设置为 i-1个节点的next
        Node node = new Node(object,p.next);
       p.next=node;
        //将i-1节点的next设置为node
    size++;
    }

    public Boolean isEmpty(){
        return head.next==null;
    }

    public void printList(){
        if(isEmpty()){
            System.out.println("[]");
        }else {
            StringBuilder sb = new StringBuilder("[");
            Node p=head;
            while (p!=null){
                sb.append(p.data+" , ");
                p=p.next;
            }
            sb.append(" ]");
            System.out.println(sb.toString());
        }

    }
}
