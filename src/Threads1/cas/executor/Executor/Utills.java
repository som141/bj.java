package Threads1.cas.executor.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static Threads1.cas.util.logger.log;

public abstract class Utills {
    public static void printState(ExecutorService executor) {
        if(executor instanceof ThreadPoolExecutor poolExecutor) {//인스턴스오브로 poolexecutor을 체크해서 거기 안에있는 메서드를 확정적으로 사용가능하게 함.
            int pool=poolExecutor.getPoolSize();
            int active =poolExecutor.getActiveCount();
            int queuedTasks =poolExecutor.getQueue().size();
            long completedTask =poolExecutor.getCompletedTaskCount();
            log("[pool=" + pool + ", active=" + active + ", queuedTasks=" +
                    queuedTasks + ", completedTasks=" + completedTask + "]");
        }
        else {
            log(executor);
        }
        }
    public static void printState(ExecutorService executor,String taskName) {
        if(executor instanceof ThreadPoolExecutor poolExecutor) {//인스턴스오브로 poolexecutor을 체크해서 거기 안에있는 메서드를 확정적으로 사용가능하게 함.
            int pool=poolExecutor.getPoolSize();
            int active =poolExecutor.getActiveCount();
            int queuedTasks =poolExecutor.getQueue().size();
            long completedTask =poolExecutor.getCompletedTaskCount();
            log(taskName+": [pool=" + pool + ", active=" + active + ", queuedTasks=" +
                    queuedTasks + ", completedTasks=" + completedTask + "]");
        }
        else {
            log(executor);
        }
    }
    }


