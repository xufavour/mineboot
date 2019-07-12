package com.nightstory.mineboot.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: putao
 * @Date: 2019/4/12
 */
public class ForkDemo {

    public static List<Integer> thList = new ArrayList<>();

    public static void main(String[] args) {
        int max = 310568;
        List<Long> idList = new ArrayList<>(310568);
        for(int i =0; i < max ; i ++ ){
            idList.add((long) i);
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool(7);
        StatisticTask task = new StatisticTask(0,310568,idList);
        Future<Integer> result = forkJoinPool.submit(task);
        Integer integer = new Integer(0);
        try {
            integer = result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(thList.size());
        for(int i : thList){
            System.out.println(i);
        }
    }

    static class StatisticTask extends RecursiveTask<Integer> {

        private static final int MAX_SIZE = 1000;
        private int start;
        private int end;
        List<Long> idList;

        public StatisticTask(int start, int end, List<Long> idList) {
            this.start = start;
            this.end = end;
            this.idList = idList;
        }

        @Override
        protected Integer compute() {
            if(end - start < MAX_SIZE){
                System.out.println("thread : " + Thread.currentThread().getId() + "------start id:" + start + "," + end);
                List<Long> list = new ArrayList<>(1024);
                for(int i = start; i < end; i++){
                    list.add(idList.get(i));
                }
                thList.add(list.size());
                int tagAddCount = 1;
                System.out.println("thread : " + Thread.currentThread().getId() + "------end   id:" + start + "," + end);
                return tagAddCount;
            }else {
                int middle = (start + end) /2;
                StatisticTask left = new StatisticTask(start,middle,idList);
                StatisticTask right = new StatisticTask(middle,end,idList);
                left.fork();
                right.fork();
                return left.join() + right.join();
            }
        }
    }
}
