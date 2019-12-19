package com.example.qqq;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.qqq.adapters.RecAdpater;
import com.example.qqq.bean.ItemData;
import com.example.qqq.presenter.NetPresenter;
import com.example.qqq.view.NetView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NetView,View.OnClickListener{

    private Button bj;
    private Button remove;
    private Button all;
    private Button ok;
    private RecyclerView rec;
    private List<ItemData.DataBean.BannerBean> datas;
    private RecAdpater adpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetPresenter netPresenter = new NetPresenter(this);
        initView();
        netPresenter.getData();
    }

    private void initView() {
        bj = (Button) findViewById(R.id.bj);
        remove = (Button) findViewById(R.id.remove);
        all = (Button) findViewById(R.id.all);
        ok = (Button) findViewById(R.id.ok);
        rec = (RecyclerView) findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(this));
        datas = new ArrayList<>();
        adpater = new RecAdpater(this,datas);

        bj.setOnClickListener(this);
        remove.setOnClickListener(this);
        all.setOnClickListener(this);
        ok.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bj:
                adpater.setFlag(true);
                adpater.notifyDataSetChanged();
                break;
            case R.id.remove:
                adpater.delete();
                adpater.notifyDataSetChanged();
                break;
            case R.id.all:
                adpater.select(true);
                adpater.notifyDataSetChanged();
                break;
            case R.id.ok:
                adpater.setFlag(false);
                adpater.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void setData(List<ItemData.DataBean.BannerBean> data) {
        datas.addAll(data);
        rec.setAdapter(adpater);
        adpater.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, "数据为空", Toast.LENGTH_SHORT).show();
    }
}
