package com.imoc.firstappdemo.demo.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author jianghua
 * @date 2021/01/29
 */
public class FrequencyController implements Runnable {

    private boolean end = false;

    private Semaphore semaphore;

    private int count;

    public FrequencyController(int count) {
        this.semaphore = new Semaphore(count);
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println("开始释放信号量!!");
        while (!end) {
            try {
                Thread.sleep(10000);
                int c = count - semaphore.availablePermits();
                if (c > 0) {
                    semaphore.release(c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("信号量释放结束!!");
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}