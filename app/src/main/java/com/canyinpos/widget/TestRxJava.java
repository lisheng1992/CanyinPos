package com.canyinpos.widget;

import com.canyinpos.mvp.bean.FunctionBean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;


/**
 * 作者：Hao on 2017/8/25 11:34
 * 邮箱：shengxuan@izjjf.cn
 */

public class TestRxJava {

    private void testFrom() {
        Future<String> mFuture = Executors.newSingleThreadExecutor().submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "LINWINNER";
            }
        });
        Observable.from(mFuture).
                subscribe(new Action1<String>() {
            @Override
            public void call(String s) {

            }
        });
        List<FunctionBean> list = new ArrayList<>();
        Observable.from(list).subscribe(new Action1<FunctionBean>() {
            @Override
            public void call(FunctionBean functionBean) {

            }
        });
    }

    private void testMap() {
        List<FunctionBean> list = new ArrayList<>();
        Observable.from(list).map(new Func1<FunctionBean, String>() {
            @Override
            public String call(FunctionBean functionBean) {
                return functionBean.getFunctionName();
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {

            }
        });
        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hahah");
            }
        }).map(new Func1<String, FunctionBean>() {
            @Override
            public FunctionBean call(String s) {
                return null;
            }
        }).subscribe(new Action1<FunctionBean>() {
            @Override
            public void call(FunctionBean functionBean) {

            }
        });
    }

    private void testFlatMap() {
        final List<FunctionBean> list = new ArrayList<>();
        Observable.from(list).flatMap(new Func1<FunctionBean, Observable<?>>() {
            @Override
            public Observable<?> call(FunctionBean functionBean) {
                return Observable.from(list);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
    }

    private void testScan() {
        Observable.just(1,2,3,4,5)
                .scan(new Func2<Integer, Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer, Integer integer2) {
                        return integer+integer2;
                    }
                }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {

            }
        });
    }
}
