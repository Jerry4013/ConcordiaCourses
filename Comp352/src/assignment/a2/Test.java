package assignment.a2;

public class Test {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list.toString());
        list.add(3,"f");
        System.out.println(list.toString());
        list.remove(2);
        System.out.println(list.toString());
        list.add(0,"p");
        System.out.println(list.toString());
        list.add(0,"q");
        System.out.println(list.toString());
        list.remove(1);
        System.out.println(list.toString());
        list.remove("b");
        System.out.println(list.toString());
        System.out.println("The size now is: " + list.size());
        list.clear();
        System.out.println(list.toString());

    }
}
