package 查找;

/**
 * Auther: dyh
 * Date: 2020/6/5 21:48
 * Description:
 */
public class 二分查找 {
    public static void main(String[] args) {
            int[] arr={1,2,3,4,5,6,7,8,9};
            int  k=3;
        int search = search(arr, k);
        System.out.println(search);
    }

    public static int search(int[] arr,int k){
        int low=0; int high=arr.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==k){
                return mid;
            }else if(arr[mid]<k){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return 0;
    }
}
