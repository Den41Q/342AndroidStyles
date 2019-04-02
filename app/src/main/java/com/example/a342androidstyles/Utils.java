package com.example.a342androidstyles;

import android.content.Intent;

public class Utils {
    private static int sTheme;

    public final static int MARGIN_1 = 0;
    public final static int MARGIN_2 = 1;
    public final static int MARGIN_3 = 2;

    public static void changeToTheme(MainActivity activity, int theme) {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    public static void onActivityCreateSetTheme(MainActivity activity) {
        switch (sTheme) {
            default:
            case MARGIN_1:
                activity.setTheme(R.style.Margin1);
                break;
            case MARGIN_2:
                activity.setTheme(R.style.Margin2);
                break;
            case MARGIN_3:
                activity.setTheme(R.style.Margin3);
                break;
        }
    }
}
