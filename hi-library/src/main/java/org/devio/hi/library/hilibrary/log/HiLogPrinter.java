package org.devio.hi.library.hilibrary.log;

import androidx.annotation.NonNull;

public interface HiLogPrinter {
    // 根据日志配置、级别、标签打印日志内容
    void print(@NonNull HiLogConfig config, int level, String tag, @NonNull String printString);
}
