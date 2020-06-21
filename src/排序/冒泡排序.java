package 排序;

import static 排序.插入排序.sort;

/**
 * Auther: dyh
 * Date: 2020/6/21 21:13
 * Description:俩俩交换，大的放在后面，第一次排序后最大值已在数组末尾。
 * 因为俩俩交换，需要n-1趟排序，比如10个数，需要9趟排序
 * 代码实现要点：
 * 两个for循环，外层循环控制排序的趟数，内层循环控制比较的次数
 * 每趟过后，比较的次数都应该要减1
 * 优化：如果一趟排序后也没有交换位置，那么该数组已有序～
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        int[] ints = new int[]{12,2,3,4,11,6,5,4,88,1};
        sort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }


    }
    public static void sort( int[] arrays) {
        //外层循环是排序的趟数
        for(int i=0;i<arrays.length-1;i++){
            //每比较一趟就重新初始化为0
            int isChange = 0;
            for(int j=0;j<arrays.length-1-i;j++){
                if(arrays[j+1]<arrays[j]){
                    int temp=arrays[j];
                    arrays[j]=arrays[j+1];
                    arrays[j+1]=temp;
                    isChange=1;
                }
            }
            if(isChange==0){
                break;
            }
        }
    }
}
