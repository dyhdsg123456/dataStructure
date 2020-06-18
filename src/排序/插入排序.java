package 排序;

/**
 * Auther: dyh
 * Date: 2020/6/17 20:36
 * Description:
 */
public class 插入排序 {
    public static void main(String[] args) {
        int[] ints = new int[]{12,2,3,4,11,6,5,4,88,1};
        sort2(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    //直接插入排序
    public static void sort(int[] a){
        for (int i=1;i<a.length;i++){
            //进行排序的元素
            int current=a[i];
            //从i-1的位置开始比较
            int j=i-1;
            //插入的元素比比较的元素小，比较元素后移
            while(j>=0&&a[j]>current){
                a[j+1]=a[j];
                //比较前面一个
                j--;
            }
            //比较完毕 插入的元素放在第j个元素后面
            a[j+1]=current;
        }
    }
    //折半插入排序
    public static void sort2(int[] a){
        for (int i=1;i<a.length;i++){
            //进行排序的元素
           int current =a[i];
           int high=i-1;
           int low=0;
           //查找需要插入的位置
            while(low<=high){
                int mid=(low+high)/2;
                if(a[mid]>current){
                    high=mid-1;
                }else {
                    low=mid+1;
                }
            }

            for(int j=i-1;j>=high+1;j--){
                a[j+1]=a[j];
            }
            a[high+1]=current;
        }
    }
}
