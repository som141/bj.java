package ex1;

public class ex1 {//인자 전달 방식 공부임,
    int num;

    public ex1(int num) {
        this.num = num;
    }
    static class increase{
        void plus(ex1 e){
            e.num++;
        }
        void minus(int n){
            n++;
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        ex1 obj = new ex1(5);
        increase obj1 = new increase();
        obj1.minus(obj.num);
        System.out.println(obj.num);
    }
}
