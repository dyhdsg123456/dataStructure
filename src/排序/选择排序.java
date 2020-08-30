package 排序;

import java.util.Arrays;

/**
 * Auther: dyh
 * Date: 2020/6/28 20:51
 * Description:
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 6, 5, 3, 2, 8, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            int minindex=i;
            //取出最小元素下标
            for (int j = i+1; j < array.length; j++) {
                if(array[j]<array[minindex]){
                    minindex=j;
                }
            }
            //交换最小值
            int temp=array[minindex];
            array[minindex]=array[i];
            array[i]=temp;
        }
    }
}
