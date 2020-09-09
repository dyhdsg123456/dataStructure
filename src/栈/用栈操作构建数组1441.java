package 栈;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Auther: dyh
 * Date: 2020/9/9 22:08
 * Description:给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
 *
 * 请使用下述操作来构建目标数组 target ：
 *
 * Push：从 list 中读取一个新元素， 并将其推入数组中。
 * Pop：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 *
 * 请返回构建目标数组所用的操作序列。
 *
 * 题目数据保证答案是唯一的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = [1,3], n = 3
 * 输出：["Push","Push","Pop","Push"]
 * 解释：
 * 读取 1 并自动推入数组 -> [1]
 * 读取 2 并自动推入数组，然后删除它 -> [1]
 * 读取 3 并自动推入数组 -> [1,3]
 * 示例 2：
 *
 * 输入：target = [1,2,3], n = 3
 * 输出：["Push","Push","Push"]
 * 示例 3：
 *
 * 输入：target = [1,2], n = 4
 * 输出：["Push","Push"]
 * 解释：只需要读取前 2 个数字就可以停止。
 * 示例 4：
 *
 * 输入：target = [2,3,4], n = 4
 * 输出：["Push","Pop","Push","Push","Push"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/build-an-array-with-stack-operations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 用栈操作构建数组1441 {


    public static void main(String[] args) {
        int[] target={2,3,4}; int n=4;
        List<String> strings = buildArray(target, n);
        for (String string : strings) {
            System.out.println(string);
        }
    }
    public static List<String> buildArray(int[] target, int n) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<String> result = new LinkedList<>();
        for (int i = target.length-1; i >=0; i--) {
            stack.push(target[i]);
        }
        for(int i=1;i<=n;i++){
            //推入数组
            if(!stack.isEmpty()&&stack.peek()==i){
                result.add("Push");
                stack.pop();
            }else if(!stack.isEmpty()&&stack.peek()!=i){
                //目标数组没有这个值 先推入再删除
                result.add("Push");
                result.add("Pop");
            }
        }
        return result;
    }
}
