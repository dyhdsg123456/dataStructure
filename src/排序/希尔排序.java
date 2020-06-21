package 排序;

/**
 * Auther: dyh
 * Date: 2020/6/21 20:44
 * Description:分组快速排序
 */
public class 希尔排序 {
    public static void main(String[] args) {
        int[] ints = new int[]{12,2,3,4,11,6,5,4,88,1};
        shellSort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
    public static void shellSort(int[] arrays) {
        //step为步长，每次减为原来的一半
        for (int step = arrays.length/2;step>0; step/=2) {
            //开始进行插入排序，直至完毕
            for(int i=step;i<arrays.length;i++){
                int j=i;
                int temp=arrays[i];
                while (j-step>=0&&arrays[j-step]>temp){
                    arrays[j]=arrays[j-step];
                    j=j-step;
                }
                arrays[j]=temp;
            }

        }
    }
}
