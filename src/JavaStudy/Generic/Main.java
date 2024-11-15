package JavaStudy.Generic;

public class Main {
    public static void main(String[] args) {
        List1<Integer> list = new GList1<>();
        list.push(1);
        list.push(2);
        list.push(3);
        int pop1 = list.pop();
        System.out.println(pop1);
        list.printList();
    }
}
