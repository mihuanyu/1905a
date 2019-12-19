package com.example.qqq.view;

import com.example.qqq.bean.ItemData;

import java.util.List;

public interface NetView {
    void setData(List<ItemData.DataBean.BannerBean> data);
    void showToast(String str);
}
