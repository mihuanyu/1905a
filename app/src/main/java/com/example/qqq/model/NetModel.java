package com.example.qqq.model;

import com.example.qqq.ApiService;
import com.example.qqq.NetCallBack;
import com.example.qqq.bean.ItemData;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetModel {

    public void getData(final NetCallBack netCallBack) {

        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiServer = build.create(ApiService.class);
        Observable<ItemData> data = apiServer.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ItemData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ItemData itemData) {
                        if(itemData!=null){
                            netCallBack.onSussess(itemData.getData().getBanner());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        netCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
