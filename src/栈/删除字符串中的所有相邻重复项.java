package 栈;

import java.util.Stack;

/**
 * Auther: dyh
 * Date: 2020/9/4 21:07
 * Description:给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 删除字符串中的所有相邻重复项 {
    public static void main(String[] args) {
        String abbaca = removeDuplicates("abbaca");
        System.out.println(abbaca);
        StringBuilder stringBuilder = new StringBuilder("12341");
        StringBuilder replace = stringBuilder.replace(0, 2, "");
        System.out.println(replace);
    }

    public static String removeDuplicates(String S) {
        Stack<Character> result = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char target = S.charAt(i);
            if (result.isEmpty() || result.peek() != target) {
                result.push(target);
            } else {
                result.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character s : result) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static String removeDuplicates2(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (true) {
            boolean flag = true;
            for (int i = 1; i < sb.length(); i++) {
                if (sb.charAt(i) == sb.charAt(i - 1)) {
                    sb.replace(i - 1, i + 1, "");
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return sb.toString();
    }
}
