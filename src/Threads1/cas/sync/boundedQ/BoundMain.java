package Threads1.cas.sync.boundedQ;

import java.util.ArrayList;
import java.util.List;

import static Threads1.cas.util.Sp.sleep;
import static Threads1.cas.util.logger.log;

public class BoundMain{
    public static void main(String[] args) {
        BQ queue=new BQ6(2);
        ProducerFirst(queue);
//        ConsumerFirst(queue);
    }
    private static void ProducerFirst(BQ bq){
        log("생산자 먼저 실행"+bq.getClass().getSimpleName() +"==");
        List<Thread> threads=new ArrayList<>();
        ProducerStart(bq,threads);
        PrintQueue(bq,threads);
        ConsumerStart(bq,threads);
        PrintQueue(bq,threads);
        log("생산자 먼저 실행 종료"+bq.getClass().getSimpleName() +"==");

    }
    private static void ConsumerFirst(BQ bq){
        log("소비자 먼저 실행"+bq.getClass().getSimpleName() +"==");
        List<Thread> threads=new ArrayList<>();
        ConsumerStart(bq,threads);
        PrintQueue(bq,threads);
        ProducerStart(bq,threads);
        PrintQueue(bq,threads);
        log("소비자 먼저 실행 종료"+bq.getClass().getSimpleName() +"==");
    }
    private static void ProducerStart(BQ bq, List<Thread> threads){
        System.out.println();
        log("생산자 시작");
        for(int i=0;i<3;i++){
            Thread thread = new Thread(new ProducerTask(bq,"data"+i),"producer"+i);
            threads.add(thread);
            thread.start();
            sleep(1000);
        }
    }
    private static void ConsumerStart(BQ bq, List<Thread> threads){
        System.out.println();
        log("소비자 시작");
        for(int i=0;i<3;i++){
            Thread thread = new Thread(new ConsumerTask(bq),"consumer"+i);
            threads.add(thread);
            thread.start();
            sleep(1000);
        }
    }
    private static void PrintQueue(BQ bq, List<Thread> threads){
        System.out.println();
        log("현재 상태 출력, 큐 데이터: "+bq);
        for(Thread thread:threads){
            log(thread.getName()+" : "+thread.getState());
        }
    }


}
