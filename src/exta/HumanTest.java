package exta;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class HumanTest {

    public static void main(String[] args) {
        //Human.test();
        System.out.println(Human.str) ;
    }


    /**
     * Human 工厂
     * @param size
     * @return
     */
    private static List<Human> facotry(int size){
        if(size <= 0 ){
            return null;
        }
        List<Human> list = new ArrayList<>();
        for(int i = 0;i<size;i++){
            list.add(new Human());
        }
        return list;
    }
}
