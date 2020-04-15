package 线性表.链表;

/**
 * Auther: dyh
 * Date: 2020/3/31 22:49
 * Description:
 */
public class SingleList {
    public static void main(String[] args) {
//        Node node = new Node(2, null);
        SingleList singleList = new SingleList();
//        singleList.initSingleList();
//        singleList.add(1,1);
//        singleList.add(2,2);
//        singleList.add(3,3);
//        singleList.add(4,5);
//        singleList.add(5,8);
//        singleList.printList();
//        System.out.println(singleList.size);
//        singleList.remove(1);
//        System.out.println(singleList.size);
//        System.out.println(singleList.getNode(10));
//        System.out.println( singleList.getindex(0));
//        singleList.printList();
//    singleList.createList_Head(4);
//        SingleList a = new SingleList();
//        a.initSingleList();
//        a.add(1,2);
//        a.add(2,4);
//        a.add(3,6);
//        SingleList b = new SingleList();
//        b.initSingleList();
//        b.add(1,1);
//        b.add(2,3);
//        b.add(3,5);
//        SingleList c = new SingleList();
//        c.initSingleList();
//        SingleList mergeList = a.MergeList(a, b, c);
//     mergeList.printList();

    }

    private  Node head;
    private int size;
    private static class Node{
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }
    //将2个有序单链表合并为一个有序单链表
    public SingleList MergeList(SingleList a,SingleList b,SingleList c){
        Node nodec = c.head;
        Node nodeA = a.head;
        Node nodeB = b.head;
        //遍历取小的,退出条件为一个链表取完了
        while (nodeA!=null&&  nodeB!=null){
            if(nodeA.data>=nodeB.data){
                nodec.next=nodeB;
                nodec=nodec.next;
                nodeB=nodeB.next;
            }else {
                nodec.next=nodeA;
                nodec=nodec.next;
                nodeA=nodeA.next;
            }

            nodec.next=nodeA==null?nodeB:nodeA;
        }


        return c;
    }

    //头插法创建有n个元素的链表
    public void createList_Head(int n){
        Node node = new Node(0,null);
        for(int i=1;i<n;++i){
            Node p = new Node(i, null);
            //将头结点后面的元素挂到新节点后面
              p.next= node.next;
              node.next=p;
        }
        StringBuilder sb = new StringBuilder("[");
        while (node!=null){
            sb.append(node.data+" , ");
            node=node.next;
        }
        sb.append(" ]");
        System.out.println(sb.toString());

    }
    //尾插法


    public void initSingleList(){
       head = new Node(0,null);
        size++;
    }
    //根据值返回位置序号
    public int getindex(int e){
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
    public Node  getNode(int e){
        Node p=head;
        while (p!=null&&p.data!=e){
            p=p.next;
        }
        return p;
    }

    //在第index之前插入元素
    public void add(int index,int object){


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
