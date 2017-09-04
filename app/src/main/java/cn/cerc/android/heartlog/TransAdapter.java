package cn.cerc.android.heartlog;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jason<sz9214e@qq.com> on 2017/9/4.
 */

public class TransAdapter extends ArrayAdapter<TransRecord> {

    private int reosurce;

    public TransAdapter(@NonNull Context context, @LayoutRes int resource, List<TransRecord> objects) {
        super(context, resource, objects);
        this.reosurce = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View v = LayoutInflater.from(this.getContext()).inflate(this.reosurce, null);
        TextView lblDate = (TextView) v.findViewById(R.id.lblDate);
        TextView lblNum1 = (TextView) v.findViewById(R.id.lblNum1);
        TextView lblNum2 = (TextView) v.findViewById(R.id.lblNum2);
        TextView lblNum3 = (TextView) v.findViewById(R.id.lblNum3);

        TransRecord item = getItem(position);
        lblDate.setText(item.getDate());
        lblNum1.setText("收缩压：" + item.getNum1());
        lblNum2.setText("舒张压：" + item.getNum2());
        lblNum3.setText("心率：" + item.getNum3());
        return v;
    }
}
