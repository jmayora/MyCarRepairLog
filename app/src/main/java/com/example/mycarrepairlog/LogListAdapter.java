package com.example.mycarrepairlog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LogListAdapter extends RecyclerView.Adapter<LogListAdapter.ViewHolder>{

    private List<LogRecordModel> allLogRecordList;
    ConstraintLayout lvItemView;

    public LogListAdapter(List<LogRecordModel> allLogRecordList) {
        this.allLogRecordList = allLogRecordList;
    }

    public List<LogRecordModel> getAllLogRecordList() {
        return allLogRecordList;
    }

    public void setAllLogRecordList(List<LogRecordModel> allLogRecordList) {
        this.allLogRecordList = allLogRecordList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView txtViewDate1, txtViewDate2, txtViewKilometers1, txtViewKilometers2, txtViewDetail;


        public ViewHolder( View v) {
            super(v);
            txtViewDate1 = (TextView) v.findViewById(R.id.txtViewDate1);
            txtViewDate2 = (TextView) v.findViewById(R.id.txtViewDate2);
            txtViewKilometers1 = (TextView) v.findViewById(R.id.txtViewKilometers1);
            txtViewKilometers2  = (TextView) v.findViewById(R.id.txtViewKilometers2);
            txtViewDetail = (TextView) v.findViewById(R.id.txtViewDetail);
        }

        public TextView getTxtViewDate1() { return txtViewDate1; }
        public TextView getTxtViewDate2() { return txtViewDate2; }
        public TextView getTxtViewKilometers1() { return txtViewKilometers1; }
        public TextView getTxtViewKilometers2() { return txtViewKilometers2; }
        public TextView getTxtViewDetail() {return txtViewDetail;}
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.logrecord_view, viewGroup, false);

        return new LogListAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int position) {
        viewHolder.getTxtViewDate1().setText(String.valueOf(allLogRecordList.get(position).getDate1()));
        viewHolder.getTxtViewDate2().setText(allLogRecordList.get(position).getDate2());
        viewHolder.getTxtViewKilometers1().setText(allLogRecordList.get(position).getKilometers1());
        viewHolder.getTxtViewKilometers2().setText(String.valueOf(allLogRecordList.get(position).getKilometers2()));
        viewHolder.getTxtViewDetail().setText(allLogRecordList.get(position).getDetail());
    }

    @Override
    public int getItemCount() {
        return allLogRecordList.size();
    }


}
