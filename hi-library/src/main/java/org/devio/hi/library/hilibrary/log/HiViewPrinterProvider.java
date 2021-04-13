package org.devio.hi.library.hilibrary.log;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.devio.hi.library.hilibrary.util.HiDisplayUtil;

public class HiViewPrinterProvider {
    private FrameLayout rootView;
    private View floatingView;
    private boolean isOpen;
    private FrameLayout logView;
    private RecyclerView recyclerView;

    public HiViewPrinterProvider(FrameLayout rootView, RecyclerView recyclerView) {
        this.rootView = rootView;
        this.recyclerView = recyclerView;
    }

    private static final String TAG_FLOATING_VIEW = "TAG_FLOATING_VIEW";
    private static final String TAG_LOG_VIEW = "TAG_LOG_VIEW";
    /**
     * 显示 Log 悬浮按钮
     */
    public void showFloatingView() {
        if (rootView.findViewWithTag(TAG_FLOATING_VIEW) != null) {
            return;
        }
        FrameLayout.LayoutParams params =
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.BOTTOM|Gravity.END;
        View floatingView = getFloatingView();
        floatingView.setTag(TAG_FLOATING_VIEW);
        floatingView.setBackgroundColor(Color.BLACK);
        floatingView.setAlpha(0.8f);
        params.bottomMargin = HiDisplayUtil.dp2px(100, recyclerView.getResources());
        rootView.addView(getFloatingView(), params);
    }

    /**
     * 获取 Log 悬浮按钮
     */
    private View getFloatingView() {
        if (floatingView != null) {
            return floatingView;
        }
        TextView textView = new TextView(rootView.getContext());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOpen) {
                    showLogView();
                }
            }
        });
        textView.setText("HiLog");
        textView.setTextColor(Color.WHITE);

        return floatingView = textView;
    }

    /**
     * 关闭 Log 悬浮按钮
     */
    public void closeFloatingView() {
        rootView.removeView(getFloatingView());
    }

    /**
     * 展示LogView
     */
    private void showLogView() {
        if (rootView.findViewWithTag(TAG_LOG_VIEW) != null) {
            return;
        }
        FrameLayout.LayoutParams params =
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, HiDisplayUtil.dp2px(160, rootView.getResources()));
        params.gravity = Gravity.BOTTOM;
        View logView = getLogView();
        logView.setTag(TAG_LOG_VIEW);
        rootView.addView(getLogView(), params);
        isOpen = true;
    }

    /**
     * 获取LogView
     */
    private View getLogView() {
        if (logView != null) {
            return logView;
        }
        FrameLayout logView = new FrameLayout(rootView.getContext());
        logView.setBackgroundColor(Color.BLACK);
        logView.addView(recyclerView);
        FrameLayout.LayoutParams params =
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.END;
        TextView closeView = new TextView(rootView.getContext());
        closeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeLogView();
            }
        });
        closeView.setText("Close");
        closeView.setTextColor(Color.WHITE);
        logView.addView(closeView, params);
        return this.logView = logView;
    }

    /**
     * 关闭 LogView
     */
    private void closeLogView() {
        isOpen = false;
        rootView.removeView(getLogView());
    }

}
