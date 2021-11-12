import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list2.add("1111");
        list2.add("1111");
        list2.add("1111");
        list.add(list2);
        list.add(list2);
        System.out.println(list.size());
        System.out.println(list2.size());
    }
}
