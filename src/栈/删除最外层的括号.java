package 栈;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Auther: dyh
 * Date: 2020/8/30 17:36
 * Description:
 */
public class 删除最外层的括号 {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses2("(()())(())"));
    }


    public static String removeOuterParentheses(String S) {
        HashMap<Integer,List<String>> map= new HashMap();
        StringBuilder result= new StringBuilder();
        int left=0;
        int right=0;
        int num=1;
        for(int i=0;i<S.length();i++){
            List<String> list=  map.get(num);
            if(list==null){
                list=new ArrayList<String>();
                map.put(num,list);
            }
            if(S.charAt(i)=='('){
                left++;
                list.add("(");
            }
            if(S.charAt(i)==')'){
                right++;
                list.add(")");
            }
            if(left==right){
                num+=1;
                left=right=0;
            }
        }
        for(Map.Entry<Integer,List<String>> entry:map.entrySet()){
            List<String> list=  entry.getValue();
            list.remove(list.size()-1);
            list.remove(0);
            for(String s:list){
                result.append(s);
            }
        }
        return result.toString();
    }


    public static String removeOuterParentheses2(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
//        System.out.println(removeOuterParentheses2("(()())(())"));
        for (char c : S.toCharArray()) {
            if (c == ')') --level;
            if (level >= 1) sb.append(c);
            if (c == '(') ++level;
        }
        return sb.toString();

    }
}
