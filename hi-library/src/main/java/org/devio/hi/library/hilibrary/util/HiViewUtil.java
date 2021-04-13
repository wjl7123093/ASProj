package org.devio.hi.library.hilibrary.util;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import java.util.ArrayDeque;
import java.util.Deque;

public class HiViewUtil {

    /**
     * 获取指定类型的子View
     * @param group viewGroup
     * @param cls   如：RecyclerView.class
     * @param <T>
     * @return  指定类型的View
     */
    public static <T> T findTypeView(@Nullable ViewGroup group, Class<T> cls) {
        if (group == null) {
            return null;
        }
        // Deque 双端队列
        // ArrayDeque 不是线程安全的
        // ArrayDeque 不可以存取 null 元素。系统可以根据某个位置是否为 null 来判断元素是否存在
        // 当作为栈使用时，性能比 Stack 好，作为队列时，性能比 LinkedList 好
        // 【ArrayDeque使用详解】https://blog.csdn.net/skh2015java/article/details/74840513
        Deque<View> deque = new ArrayDeque<>();
        deque.add(group);
        while (!deque.isEmpty()) {
            View node = deque.removeFirst(); // 删除第一个元素，并返回删除元素的值,如果元素为null，将抛出异常
            if (cls.isInstance(node)) {
                return cls.cast(node);  // 强制类型转换
            } else if (node instanceof ViewGroup) {
                ViewGroup container = (ViewGroup) node;
                for (int i = 0, count = container.getChildCount(); i < count; i++) {
                    deque.add(container.getChildAt(i));
                }
            }
        }
        return null;
    }
}
