package com.example.qqq.presenter;

import com.example.qqq.NetCallBack;
import com.example.qqq.bean.ItemData;
import com.example.qqq.model.NetModel;
import com.example.qqq.view.NetView;

import java.util.List;

public class NetPresenter implements NetCallBack {
    private NetModel model;
    private NetView view;

    public NetPresenter(NetView view) {
        this.view = view;
        model = new NetModel();
    }
    public void getData(){
        model.getData(this);
    }

    @Override
    public void onSussess(List<ItemData.DataBean.BannerBean> data) {
        view.setData(data);
    }

    @Override
    public void onFail(String str) {
        view.showToast(str);
    }
}
