package org.devio.hi.library.hilibrary.log;

/**
 * 线程信息格式化器
 */
public class HiThreadFormatter implements HiLogFormatter<Thread> {

    @Override
    public String format(Thread data) {
        return "Thread:"  + data.getName();
    }
}
