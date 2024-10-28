package Threads1.cas.print;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import static Threads1.cas.util.logger.log;

public class Myp2 {//메인은 인풋.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printer2 p = new printer2();
        Thread t1 = new Thread(p);
        t1.start();
        while(true){
            log("출력할 문자를 넣으시오 : ");
            String c=sc.next();
            if(c.equals("q")){
                Thread.yield();
                t1.interrupt();
                break;
            }
            p.jobQ(c);
        }

    }

    static class printer2 implements Runnable {
        //스테틱에서는 아웃풋
        private final Queue<String> queue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                if (queue.isEmpty()) {
                    continue;
                }
                try {
                    String c = queue.poll();
                    log("출력시작 : " + c + "대기문서" + queue);
                    Thread.sleep(3000);
                    log("출력완료 : " + c);
                } catch (InterruptedException e) {
                    log("인터럽트 발생");
                    break;
                }


            }
            log("프린터 종료");

        }

        void jobQ(String c) {
            queue.add(c);
        }
    }}
