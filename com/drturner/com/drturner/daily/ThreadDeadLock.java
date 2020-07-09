package com.drturner.com.drturner.daily;

import java.util.concurrent.*;

/**
 * ClassName: ThreadDeadLock
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/21
 * Version: 1.0
 */
public class ThreadDeadLock {
    private static ExecutorService executorService=Executors.newFixedThreadPool(8);
    static class LoadingFile implements Callable<String>{
        LoadingFile(){

        }

        @Override
        public String call() throws Exception {
            System.out.println("Loading...");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("File loading complete!");
            return "html";
        }
    }
    public static class RenderPage implements Callable<String>{
        @Override
        public String call() throws Exception {
            Future<String> header,footer;
            header =  executorService.submit(new LoadingFile());
            footer= executorService.submit(new LoadingFile());
            return header.get()+footer.get();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> submit = executorService.submit(new RenderPage());
        System.out.println(submit.get());
        executorService.shutdown();
    }
}
