package com.example.android.zhetai.androidlearning.Utils;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class EasySchedulers {
    private EasySchedulers() {
    }

    public static Scheduler io() {
        return io.reactivex.schedulers.Schedulers.io();
    }

    public static Scheduler computation() {
        return io.reactivex.schedulers.Schedulers.computation();
    }

    public static Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
