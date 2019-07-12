package com.nightstory.mineboot.java.inner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: putao
 * @Date: 2018/12/18
 */
public class MainTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
//        System.out.println(filtered.size());
        List<Long> list = new ArrayList<>();
        for(int i =0; i < 300000; i++){
            list.add((long) i);
        }
        Integer result = getResult(300000, list);
        System.out.println(result);
    }
    public static Integer getResult(int size,List<Long> idList)  {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        StatisticTask task = new StatisticTask(0,size,idList);
        Future<Integer> result = forkJoinPool.submit(task);
        Integer integer = new Integer(0);
        try {
            integer = result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return integer;
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
                System.out.println("thread : " + Thread.currentThread().getId() + "id:" + start + "," + end);
                List<Long> list = new ArrayList<>(1024);
                for(int i = start; i < end; i++){
                    list.add(idList.get(i));
                }
                int tagAddCount = 1;
                System.out.println("thread : " + Thread.currentThread().getId() + "------end id:" + start + "," + end);
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

