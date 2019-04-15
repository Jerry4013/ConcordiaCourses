package chapter16;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayListCapacity {
    public static void main(String[] args)throws Exception {
        ArrayList<String> list = new ArrayList<>(1000);
        for (int i = 0; i < 1501; i++){
            list.add(String.valueOf(i));
        }
        System.out.println(findCapacity(list));
    }


    static <T> int findCapacity(ArrayList<T> al) throws Exception {

        Field field = ArrayList.class.getDeclaredField("elementData");

        field.setAccessible(true);

        return ((Object[]) field.get(al)).length;

    }
}
