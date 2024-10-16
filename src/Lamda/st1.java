package Lamda;

import java.util.ArrayList;
import java.util.List;

public class st1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(6);
        list.add(4);
        list.stream().filter(x -> x % 2 == 0).forEach(System.out::println);
    }
}
