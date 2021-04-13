package org.devio.hi.library.hilibrary.log;

public abstract class HiLogConfig {
    // 最大字符数
    static int MAX_LEN = 512;
    static HiThreadFormatter HI_THREAD_FORMATTER = new HiThreadFormatter();
    static HiStackTraceFormatter HI_STACK_TRACE_FORMATTER = new HiStackTraceFormatter();

    public JsonParser injectJsonParser() {
        return null;
    }

    // 默认全局标签
    public String getGlobalTag() {
        return "HiLog";
    }

    // 是否启用 HiLog，默认为 true
    public boolean enable() {
        return true;
    }

    // 是否包含线程信息
    public boolean includeThread() {
        return false;
    }

    // 堆栈深度
    public int stackTraceDepth() {
        return 5;
    }

    // 获取打印器
    public HiLogPrinter[] printers() {
        return null;
    }

    public interface JsonParser {
        String toJson(Object src);
    }

}
