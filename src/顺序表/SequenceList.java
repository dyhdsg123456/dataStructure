package 顺序表;

/**
 * Auther: dyh
 * Date: 2020/3/28 21:26
 * Description:
 */
public class SequenceList implements SList {

    public static void main(String[] args) {
        SequenceList sequenceList = new SequenceList();

        sequenceList.insert(0,1);
        sequenceList.insert(1,2);
        sequenceList.insert(2,3);
        sequenceList.insert(3,4);
        sequenceList.insert(4,5);
//        sequenceList.insert(3,8);
//        sequenceList.insert(0,9);

//        System.out.println(  sequenceList.get(3));
//        System.out.println(  sequenceList.getindex(2));
   sequenceList.remove(4);
//        System.out.println(  sequenceList.getindex(8));
        sequenceList.listSeq();
    }
    private int length;
    private Object[] data;
    private int maxsize=5;
    public SequenceList(){
        initSlist();
    }
    @Override
    public void clear() {
        for (int i = 0; i < data.length; i++) {
           data[i]=null;
        }
        length=0;
    }

    @Override
    public Boolean isEmpty() {
        return length==0;
    }

    @Override
    public void initSlist() {
        length=0;
        data=new Object[maxsize];
    }

    @Override
    public Object get(int i) {
        if(i<0||i>length-1){
            System.out.println("参数错误");
            return null;
        }
        return data[i];
    }

    @Override
    public int getindex(Object o) {
        for (int i = 0; i < data.length; i++) {
          if (data[i]==o){
              return i;
          }
        }
        return 0;
    }

    @Override
    public void insert(int i, Object o) {
        if(i<0||i>length){
            System.out.println("参数错误");
            return;
        }
        if(length==maxsize){
            System.out.println("容量不足");
            return;
        }
        if(i!=length){
        for (int j = length-1; j>=i; j--) {
               data[j+1]=data[j];
        }
        }

        data[i]=o;
        length++;
    }

    @Override
    public void remove(int i) {
        if(i<0||i>length-1){
            System.out.println("参数错误");
            return;
        }
        if(i!=length-1){
        for (int j = i; j <length-1; j++) {
            data[j]=data[j+1];
        }

        }

        data[length-1]=null;
        length--;
    }


    private void listSeq(){
        for (Object datum : data) {
            System.out.print(datum+" ");
        }
        System.out.println("长度="+length);
    }
}
