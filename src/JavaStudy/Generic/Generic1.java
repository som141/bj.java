package JavaStudy.Generic;

public class Generic1 {
    public static void main(String[] args) {
        cup<Integer> cup = new cup<Integer>();
        cup.setTea(1);
        System.out.println(cup.getTea());
        cup2<Integer,String> cup2= new cup2<>(11,"김선달");
        System.out.println(cup2);
    }
    static class cup<T>{
        private T tea;

        public T getTea() {
            return tea;
        }
        public void setTea(T tea) {
            this.tea = tea;
        }
    }
    static class cup2<k,V>{
        private k key;
        private V value;

        public cup2(k key, V value) {
            this.key = key;
            this.value = value;
        }
        public k getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "cup2 [key=" + key + ", value=" + value + "]";
        }
    }
}
