package com.example.qqq;

import com.example.qqq.bean.ItemData;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String BASE_URL="https://cdwan.cn/";
    @GET("api/index")
    Observable<ItemData> getData();
}
