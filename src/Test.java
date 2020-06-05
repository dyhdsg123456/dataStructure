import java.util.*;

/**
 * Auther: dyh
 * Date: 2020/3/29 19:43
 * Description:
 */
public class Test {
    public static void main(String[] args) {
//        LinkedList<Object> objects = new LinkedList<>();
//        objects.add("123");
//        objects.add("456");
//        objects.add("789");
//        objects.add("95453");
//        Object o = objects.get(1);
//        ArrayList<Object> objects1 = new ArrayList<>();
//        System.out.println(16>>3);
//        HashMap<Object, Object> map = new HashMap<>();
        Stack<Integer> objects = new Stack<>();
        objects.push(1);
        objects.push(2);
        objects.push(3);
        Integer pop = objects.pop();
        System.out.println(pop);
        System.out.println(objects);
        System.out.println(22/3);
        System.out.println(22%3);

    }
}
