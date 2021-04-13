package org.devio.hi.library.hilibrary.log;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * 日志信息Model
 */
public class HiLogMo {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.CHINA);
    public long timeMills;
    public int level;
    public String tag;
    public String log;

    public HiLogMo(long timeMills, int level, String tag, String log) {
        this.timeMills = timeMills;
        this.level = level;
        this.tag = tag;
        this.log = log;
    }

    public String flattendLog() {
        return getFlattend() + "\n" + log;
    }

    // 格式化日志数据
    public String getFlattend() {
        return format(timeMills) + '|' + level + '|' + tag + "|:";
    }

    public String format(long timeMills) {
        return sdf.format(timeMills);
    }
}
