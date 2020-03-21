package com.example.concurrent;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedTask implements Delayed{
    long time = System.currentTimeMillis();

    public DelayedTask(long time) {
        this.time = time;
    }

    @Override
    public int compareTo(Delayed o) {
        if(this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS))
            return -1;
        else if(this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS))
            return 1;
        else
            return 0;
    }

    //元素进入队列后，先进行排序，然后，只有getDelay也就是剩余时间为0的时候，该元素才有资格被消费者从队列中取出来，所以构造函数一般都有一个时间传入。
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(time - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public String toString() {
        return "" + time;
    }


}
