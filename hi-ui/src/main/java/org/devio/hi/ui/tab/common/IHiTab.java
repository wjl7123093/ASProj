package org.devio.hi.ui.tab.common;

import androidx.annotation.NonNull;
import androidx.annotation.Px;

/**
 * HiTab 对外接口
 * @param <D> 数据
 */
public interface IHiTab<D> extends IHiTabLayout.OnTabSelectedListener<D> {
    void setHiTabInfo(@NonNull D data);

    /**
     * 动态修改某个 item 大小
     * @param height
     */
    void resetHight(@Px int height);
}
