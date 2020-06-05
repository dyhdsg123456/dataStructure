package leetCode排序;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Auther: dyh
 * Date: 2020/6/3 20:25
 * Description:
 */
public class 上升下降字符串 {
    public static void main(String[] args) {
        String s="aaaabbbbcccc";
        String b="leetcode";
        int[] arr=new int[26];
        arr[1]=arr[1]+1;
        System.out.println(arr);
        HashSet<Integer> result = new HashSet<>();

       
    }

    public static String sortString(String s) {
        int[] arr = new int[26];// 序号+97是字母，数值是剩余个数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 97]++;
        }
        // 统计完了所有的字符
        int left = s.length();
        StringBuffer sb = new StringBuffer();
        while (left > 0) {
            for (int i = 0; i < 26; i++) {
                if (arr[i] != 0) {
                    char c = (char) (i + 97);
                    sb.append(c);
                    arr[i]--;
                    left--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (arr[i] != 0) {
                    char c = (char) (i + 97);
                    sb.append(c);
                    arr[i]--;
                    left--;
                }
            }
        }
        return sb.toString();
    }

}
