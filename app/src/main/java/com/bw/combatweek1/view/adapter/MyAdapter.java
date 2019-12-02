package com.bw.combatweek1.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.combatweek1.R;
import com.bw.combatweek1.model.ShopBean;
import com.bw.combatweek1.util.NetUtil;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<ShopBean.DataBean> list;

    public MyAdapter(List<ShopBean.DataBean> data) {

        this.list = data;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(parent.getContext(), R.layout.item_my, null);
            viewHolder.imageView = convertView.findViewById(R.id.img);
            viewHolder.textView = convertView.findViewById(R.id.tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ShopBean.DataBean dataBean = list.get(position);
        viewHolder.textView.setText(dataBean.getGoods_name());
        NetUtil.getInstance().getPhoto(dataBean.getGoods_thumb(),viewHolder.imageView);
        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
