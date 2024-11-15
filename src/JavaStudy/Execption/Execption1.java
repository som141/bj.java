package JavaStudy.Execption;

public class Execption1 {
    public void  e1 () throws makeExecption {
        System.out.println("예외 발생");
        throw  new makeExecption();
    }
    public static void main(String[] args) throws InterruptedException {
//        runtime exeption
        Execption1 e1 = new Execption1();
        e1.e1();
        try {
            System.out.println(1 / 0);
        }catch (RuntimeException e) {
            System.out.println("runTimeException");
        }
        //    checked Exeption
        Thread.sleep(100);
//        try with resource : try에서 파일등의 자원을 사용할 때 (대부분의 스트림, 소켓은 autoCloseble을 구현하였음)
        resource1 resource1 = new resource1();
        try(resource1){

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("exception");
        }

    }
    static class resource1 implements AutoCloseable {
        void show(){
            System.out.println("show");
        }
        @Override
        public void close() throws Exception {
            System.out.println("close");
        }//리소스 구문에서 자동으로 해지됨그리고 이 메서드를 호출함.!
    }
    static class makeExecption extends RuntimeException {
        public makeExecption() {
            super("런타임 익셉션");
        }
    }



}
