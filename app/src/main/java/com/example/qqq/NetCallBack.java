package com.example.qqq;

import com.example.qqq.bean.ItemData;

import java.util.List;

public interface NetCallBack {
    void onSussess(List<ItemData.DataBean.BannerBean> data);
    void onFail(String str);
}
