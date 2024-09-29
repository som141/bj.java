package Threads1.cas.print;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static Threads1.cas.util.Sp.sleep;
import static Threads1.cas.util.logger.log;

public class MyP1 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        printer1 p = new printer1();
        Thread t1 = new Thread(p);
        t1.start();
        while(true) {
            log("프린터할 문서를 입력하시오. 종료(q): ");
            String input = sc.nextLine();
            if(input.equals("q")) {
                Thread.yield();
                t1.interrupt();
                break;
            }
            p.jobadd(input);
        }
    }
    static class printer1 implements Runnable {
            private final Queue<String> queue;
        public printer1() {
            this.queue = new ConcurrentLinkedQueue<String>();
        }

        @Override
        public void run() {
            while(!Thread.interrupted()) {
                if(queue.isEmpty()) {
                    continue;
                }
                try {
                    String s = queue.poll();
                    log("출력시작: " + s + ". 대기문서 : " + queue);
                    Thread.sleep(3000);
                    System.out.println(s);
                    log("출력 완료 : " + s);
                }catch (InterruptedException e){
                    log("인터럽트! ");
                    break;
                }
                }
            log("프린터 종료");

        }
        public void jobadd(String s){
            queue.add(s);
        }

    }
}
