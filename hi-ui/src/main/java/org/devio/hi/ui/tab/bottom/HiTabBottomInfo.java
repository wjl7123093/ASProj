package org.devio.hi.ui.tab.bottom;

import android.graphics.Bitmap;
import android.graphics.Color;

import androidx.fragment.app.Fragment;

/**
 * BottomTab 实体
 * @param <Color>
 */
public class HiTabBottomInfo<Color> {
    public enum TabType {   // 图标类型
        BITMAP, ICON
    }

    public Class<? extends Fragment> fragment;  // 内容页对象，方便创建内容页Fragment
    public String name;
    public Bitmap defaultBitmap;
    public Bitmap selectedBitmap;
    public String iconFont;
    /**
     * Tips: 在 Java 代码中直接设置 iconfont 字符串无效，需要定义在 string.xml
     */
    public String defaultIconName;
    public String selectedIconName;
    public Color defaultColor;
    public Color tintColor;
    public TabType tabType;

    // Bitmap
    public HiTabBottomInfo(String name, Bitmap defaultBitmap, Bitmap selectedBitmap) {
        this.name = name;
        this.defaultBitmap = defaultBitmap;
        this.selectedBitmap = selectedBitmap;
        this.tabType = TabType.BITMAP;
    }

    // Iconfont
    public HiTabBottomInfo(String name, String iconFont, String defaultIconName, String selectedIconName, Color defaultColor, Color tintColor) {
        this.name = name;
        this.iconFont = iconFont;
        this.defaultIconName = defaultIconName;
        this.selectedIconName = selectedIconName;
        this.defaultColor = defaultColor;
        this.tintColor = tintColor;
        this.tabType = TabType.ICON;
    }
}
