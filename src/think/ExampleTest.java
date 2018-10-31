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

    /**
     * 这是一个问题我也不知道
     */
    private static void say() {
        System.out.println("hello world");
    }
}
