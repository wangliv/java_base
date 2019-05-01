package think;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ExampleTest {


    public static void main(String[] args) {

        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        final List<String> list = new ArrayList<>();
        list.add("wangli");
        list.add("zhangsan");
        for (String str:list)
        {
            System.out.println(str);
        }
    }

    private static void say() {
        System.out.println("hello world i want to do this");
    }
}
