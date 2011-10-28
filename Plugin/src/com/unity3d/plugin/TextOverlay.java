package com.unity3d.plugin;

import com.unity3d.player.UnityPlayer;

import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TextOverlay {
    private static TextView textView;

    public static void install(final int ox, final int oy, final int width, final int height) {
        if (textView != null) return;

        UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
            public void run() {
                // レイアウトをでっち上げる。
                RelativeLayout layout = new RelativeLayout(UnityPlayer.currentActivity);
                UnityPlayer.currentActivity.addContentView(layout, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
                layout.setGravity(Gravity.TOP);
                // テキストビューの挿入。
                textView = new TextView(UnityPlayer.currentActivity);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, height);
                params.leftMargin = ox;
                params.topMargin = oy;
                layout.addView(textView, params);
            }
        });
    }

    public static void setText(final String text, final int size) {
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
            public void run() {
                textView.setTextSize(size);
                textView.setText(text);
            }
        });
    }
}
