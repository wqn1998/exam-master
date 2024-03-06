package com.lititi.exams.web.datasource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author weiqineng * @version 1.0
 * @date 2024/2/29 15:33
 */
public class ThreadPoolManage {
  private static ThreadPoolManage instance;
  private ExecutorService executorService;

  private ThreadPoolManage(){
    this.executorService = Executors.newFixedThreadPool(5);
  }

  public static ThreadPoolManage getInstance(){
    if (instance == null){
      instance = new ThreadPoolManage();
    }
    return instance;
  }

  public void executeTask(Runnable task){
    this.executorService.execute(task);
  }

  public static void main(String[] args) {
    ThreadPoolManage threadPoolManage = ThreadPoolManage.getInstance();
    threadPoolManage.executeTask(() ->{
      System.out.println("线程执行");
    });
  }
}
