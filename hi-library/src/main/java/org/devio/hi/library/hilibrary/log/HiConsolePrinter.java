package org.devio.hi.library.hilibrary.log;

import android.util.Log;

import androidx.annotation.NonNull;

import static org.devio.hi.library.hilibrary.log.HiLogConfig.MAX_LEN;

/**
 * 控制台打印器
 */
public class HiConsolePrinter implements HiLogPrinter {
    @Override
    public void print(@NonNull HiLogConfig config, int level, String tag, @NonNull String printString) {
        int len = printString.length();
        int countOfSub = len / MAX_LEN; // 计算打印长度是设定最大值的多少倍
        if (countOfSub > 0) {   // >0,则每行按照MAX_LEN长度打印，然后换行继续打印
            int index = 0;
            for (int i = 0; i < countOfSub; i++) {
                Log.println(level, tag, printString.substring(index, index + MAX_LEN));
                index += MAX_LEN;
            }
            if (index != len) { // 打印最后一行内容
                Log.println(level, tag, printString.substring(index, len));
            }
        } else {
            Log.println(level, tag, printString);
        }
    }
}
