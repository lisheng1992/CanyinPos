package com.canyinpos.application;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;

import com.canyinpos.BuildConfig;
import com.socks.library.KLog;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;

/**
 * 作者：Hao on 2017/8/22 11:19
 * 邮箱：shengxuan@izjjf.cn
 */

public class ZmhApplication extends LitePalApplication {
    private RefWatcher refWatcher;
    @Override
    public void onCreate() {
        super.onCreate();
        initLeakCanary();
        initActivityLifecycleLogs();
        LitePal.initialize(this);
        initStrictMode();
        KLog.init(BuildConfig.DEBUG);
    }

    private void initLeakCanary() {
        if (BuildConfig.DEBUG) {
            refWatcher = LeakCanary.install(this);
        } else {
            refWatcher = installLeakCanary();
        }
    }

    /**
     * release版本使用此方法
     */
    protected RefWatcher installLeakCanary() {
        return RefWatcher.DISABLED;
    }

    private void initActivityLifecycleLogs() {
        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                KLog.v("=========", activity + "  onActivityCreated");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                KLog.v("=========", activity + "  onActivityStarted");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                KLog.v("=========", activity + "  onActivityResumed");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                KLog.v("=========", activity + "  onActivityPaused");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                KLog.v("=========", activity + "  onActivityStopped");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                KLog.v("=========", activity + "  onActivitySaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                KLog.v("=========", activity + "  onActivityDestroyed");
            }
        });
    }

    private void initStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                    new StrictMode.ThreadPolicy.Builder()
                            .detectAll()
                            .penaltyDialog() // 弹出违规提示对话框
                            .penaltyLog() // 在logcat中打印违规异常信息
                            .build());
            StrictMode.setVmPolicy(
                    new StrictMode.VmPolicy.Builder()
                            .detectAll()
                            .penaltyLog()
                            .build());
        }
    }

    public static RefWatcher getRefWatcher(Context context) {
        ZmhApplication application = (ZmhApplication) context.getApplicationContext();
        return application.refWatcher;
    }
}
