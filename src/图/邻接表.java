package 图;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Auther: dyh
 * Date: 2020/5/24 11:30
 * Description:
 */
public class 邻接表 {
    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};   //顶点
        Edge[] edges = {                                   //边
                // 起点      终点    权
                new Edge('A', 'B', 12),
                new Edge('A', 'F', 16),
                new Edge('A', 'G', 14),
                new Edge('B', 'C', 10),
                new Edge('B', 'F',  7),
                new Edge('C', 'D',  3),
                new Edge('C', 'E',  5),
                new Edge('C', 'F',  6),
                new Edge('D', 'E',  4),
                new Edge('E', 'F',  2),
                new Edge('E', 'G',  8),
                new Edge('F', 'G',  9),
        };

        LinkGraph graph=new LinkGraph(vexs,edges);
        graph.dfs();
        graph.BFS();
//        System.out.println(graph);
    }
    //作为某个点的邻接点的顶点信息
   static class Node{
        int index;  //顶点的序号
        int weight;  //以该顶点为终点的边的权值
        Node nextNode; //指向下一个顶点
    }

    //输入的所有顶点的类型，是任意一条链表的起点
    static class Vertex{
        char data;        //顶点值
        Node firstEdge;  //指向第一条边
    }

    //边的类型
    static class Edge{
        char start;  //起点
        char end;    //终点
        int weight;  //边的权值
        public Edge(char start,char end,int weight) {
            this.start=start;
            this.end=end;
            this.weight=weight;
        }
    }
    static class LinkGraph{
        public LinkGraph(){}

        public  Vertex[] vertex;
        public int[] parent;
        public  LinkGraph(char[] vert, Edge[] edge){
            //读入顶点，并初始化
            vertex = new Vertex[vert.length];
            parent = new int[vert.length];
            for (int i = 0; i < vertex.length; i++) {
                vertex[i]=new Vertex();
                vertex[i].data=vert[i];
                vertex[i].firstEdge=null;
            }

            for (int i = 0; i < edge.length; i++) {
                char start=edge[i].start;
                char end=edge[i].end;
                //获取顶点对应的序号
                int p1=getPosition(start);
                int p2=getPosition(end);
                //1.把p2连接在以p1为头的链表中
                Node node1=new Node();
                node1.index=p2;
                node1.weight=edge[i].weight;
                linkedLast(p1,node1);
                //2.因为是无向图，所以还需要把p1连接在以p2为头的链表中
                Node node2=new Node();
                node2.index=p1;
                node2.weight=edge[i].weight;
                linkedLast(p2,node2);
            }


        }
        //获取某个顶点对应的序号
        public int getPosition(char v) {
            for(int i=0;i<vertex.length;i++) {
                if(vertex[i].data==v) {
                    return i;
                }
            }
            //不存在这样的顶点则返回-1
            return -1;
        }
        //尾插法，将顶点连接到链表的尾巴
        public void linkedLast(int index,Node node) {
            if(vertex[index].firstEdge==null) {
                vertex[index].firstEdge=node;
            }else {
                Node tmp=vertex[index].firstEdge;
                while(tmp.nextNode!=null) {
                    tmp=tmp.nextNode;
                }
                tmp.nextNode=node;
            }
        }

        //深度优先搜索
        public void dfs(){
            boolean[] visited=new boolean[vertex.length];  //默认为false;
            int[] path=new int[vertex.length];  //记录遍历的顶点序号
            int index=0;//path[]的索引
            Stack<Integer> stack = new Stack<>();
            visited[0]=true;
            stack.push(0);
            path[index++]=0;
            while(!stack.isEmpty()) {
                int v=getUnVisitedAdjVertex(stack.peek(),visited);
                //如果不存在没有访问的邻接点，就出栈，原路返回
                if(v==-1) {
                    stack.pop();
                }
                //否则，存在还没有访问过的邻接点，入栈，并标注已访问
                else {
                    path[index++]=v;  //访问邻接点
                    visited[v]=true;  //标志已访问
                    stack.push(v);    //入栈
                }
            }

            //打印DFS路径
            System.out.println("DFS路径:");
            for(int i=0;i<path.length;i++) {
                System.out.print(vertex[path[i]].data+" ");
            }
        }
        //查找某个点的还没有被访问的邻接点的序号
        public int getUnVisitedAdjVertex(int v,boolean[] visited) {
            Node tmp=vertex[v].firstEdge;
            //如果存在邻接点
            while(tmp!=null) {
                //并且邻接点还没有访问过，就返回该邻接点的序号
                if(visited[tmp.index]==false) {
                    return tmp.index;
                }
                tmp=tmp.nextNode;
            }
            //不存在没有被访问的邻接点
            return -1;
        }
        //广度优先搜索，从第一个顶点开始遍历
        public void BFS() {
            boolean[] visited=new boolean[vertex.length];  //默认为false;
            int[] path=new int[vertex.length];  //记录遍历的顶点序号
            int index=0;  //path[]的索引
            ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);
            visited[0]=true;
            queue.add(0);
            path[index++]=0;
            while(!queue.isEmpty()) {
                int v=getUnVisitedAdjVertex(queue.peek(), visited);
                //如果不存在没有访问的邻接点，就出队
                if(v==-1) {
                    queue.remove();
                }
                //否则，存在还没有访问过的邻接点，入队，并标注已访问
                else {
                    path[index++]=v;  //访问邻接点
                    visited[v]=true;  //标志已访问
                    queue.add(v);     //入队
                }
            }

            //打印BFS路径
            System.out.println("BFS路径:");
            for(int i=0;i<path.length;i++) {
                System.out.print(vertex[path[i]].data+" ");
            }
        }

    }



}
