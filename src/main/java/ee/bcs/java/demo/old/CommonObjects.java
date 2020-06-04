import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonObjects {

    private static final List immutableList = new ArrayList();

    public static void main(String[] args) {
        immutableList.add("e");
        listSample();
        mapSample();
    }

    public static void listSample(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void mapSample(){
        Map<Long, String> map = new HashMap<>();
        map.put(1l, "esimene nod");
        map.put(28l, "järgmine node");
        System.out.println(map.get(28l));
    }
}
