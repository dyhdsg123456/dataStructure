package 线性表.顺序表;

/**
 * Auther: dyh
 * Date: 2020/3/28 21:34
 * Description:
 */
public interface SList {
     void clear();
 Boolean isEmpty();
   void initSlist();

      Object get(int i);
    int getindex(Object o);
    void insert(int i,Object o);
   void remove (int i );

}
