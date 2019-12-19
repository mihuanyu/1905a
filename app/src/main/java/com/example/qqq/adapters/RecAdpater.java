package com.example.qqq.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.qqq.R;
import com.example.qqq.bean.ItemData;
import java.util.List;

public class RecAdpater extends RecyclerView.Adapter {
    private Context context;
    private List<ItemData.DataBean.BannerBean> data;
    private boolean flag;


    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public RecAdpater(Context context,List<ItemData.DataBean.BannerBean> data) {
        this.context = context;
        this.data = data;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_rec, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        Glide.with(context).load(data.get(position).getImage_url()).into(holder1.mImage);
        holder1.mTitle.setText(data.get(position).getContent());
        if(flag){
            holder1.mCheck.setVisibility(View.VISIBLE);
        } else{
            holder1.mCheck.setVisibility(View.GONE);
        }
        if(data.get(position).getB()!=null){
            holder1.mCheck.setChecked(data.get(position).getB());
        }
        holder1.mCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                data.get(position).setB(b);
            }
        });
    }

    public void delete(){
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getB()!=null&&data.get(i).getB()){
                data.remove(i);
                i--;
            }
        }
        notifyDataSetChanged();
    }
    public void select(Boolean b){
        for (int i = 0; i < data.size(); i++) {
            data.get(i).setB(b);
        }
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return data.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImage;
        private TextView mTitle;
        private CheckBox mCheck;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mTitle = itemView.findViewById(R.id.title);
            mCheck = itemView.findViewById(R.id.check);
        }
    }
}
