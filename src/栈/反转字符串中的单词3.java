package 栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * Auther: dyh
 * Date: 2020/8/30 09:07
 * Description:给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 * <p>
 * 提示：
 * <p>
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 反转字符串中的单词3 {

    public static void main(String[] args) {
        Stack<String> strings = new Stack<>();
        strings.push("a");
        strings.push("b");
        System.out.println(strings.peek());
        System.out.println(strings.peek());
        String peek = strings.peek();
        char a='a';
        System.out.println(peek.equals(a+""));
        System.out.println();
        String s = "Let's take LeetCode contest";
        String s1 = reverseWords2(s);
        System.out.println(s1);

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }


    public static String reverseWords(String s) {
        String[] word = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length; i++) {
            if (i > 0) {
                sb.append(" ").append(new StringBuilder(word[i]).reverse());
            } else {
                sb.append(new StringBuilder(word[i]).reverse());
            }
        }
        return sb.toString();
    }

    public static String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int i=0;
        while (i<length){
            int start=i;//每个单词开始位置
            while (i<length&&s.charAt(i)!=' '){
                //遍历直到遇到空格
                i++;
            }
            for(int p=start;p<i;p++){
                sb.append(s.charAt(start+i-1-p));
            }
            while (i<length&&s.charAt(i)==' '){
                i++;
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
