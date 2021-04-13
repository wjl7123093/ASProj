package org.devio.hi.ui.tab.common;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

/**
 * TabLayout 接口
 * @param <Tab> 底部/顶部 Tab
 * @param <D> 数据
 */
public interface IHiTabLayout<Tab extends ViewGroup, D> {
    Tab findTab(@NonNull D data);   // 根据数据查找对应Tab
    // 添加监听器
    void addTabSelectedChangeListener(OnTabSelectedListener<D> listener);
    // 设置默认选中
    void defaultSelected(@NonNull D defaultInfo);
    // 初始化
    void inflateInfo(@NonNull List<D> infoList);

    interface OnTabSelectedListener<D> {
        /**
         * Tab 选中时触发
         * @param index 选中 Tab 索引 （Kotlin 中可以用 _ 代替）
         * @param prevInfo 上一个 Tab（Kotlin 中可以用 _ 代替）
         * @param nextInfo 下一个 Tab
         */
        void onTabSelectedChange(int index, @Nullable D prevInfo, @NonNull D nextInfo);
    }
}
