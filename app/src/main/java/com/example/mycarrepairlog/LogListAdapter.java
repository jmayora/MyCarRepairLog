package com.example.mycarrepairlog;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LogListAdapter extends RecyclerView.Adapter<LogListAdapter.ViewHolder>{

    private List<LogRecordModel> allLogRecordList;

    public LogListAdapter(List<LogRecordModel> allLogRecordList) {
        this.allLogRecordList = allLogRecordList;
    }

    public void setAllLogRecordList(List<LogRecordModel> allLogRecordList) {
        this.allLogRecordList = allLogRecordList;
    }

    public List<LogRecordModel> getAllLogRecordList() {
        return allLogRecordList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView txtViewDate, txtViewKilometers, txtViewDetail;
        private final ImageButton ibtnEditRecord, ibtnDeleteRecord;

        public ViewHolder( View v) {
            super(v);
            txtViewDate = (TextView) v.findViewById(R.id.txtViewDate);
            txtViewKilometers = (TextView) v.findViewById(R.id.txtViewKilometers);
            txtViewDetail = (TextView) v.findViewById(R.id.txtViewDetail);
            ibtnEditRecord =  v.findViewById(R.id.ibtnEditRecord);
            ibtnDeleteRecord = v.findViewById(R.id.ibtnDeleteRecord);
        }

        public TextView getTxtViewDate() { return txtViewDate; }
        public TextView getTxtViewKilometers() { return txtViewKilometers; }
        public TextView getTxtViewDetail() {return txtViewDetail;}
        public ImageButton getIbtnEditRecord() {return ibtnEditRecord;}
        public ImageButton getIbtnDeleteRecord() {return ibtnDeleteRecord;}
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.logrecord_view, viewGroup, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int position) {
        int auto_ID = allLogRecordList.get(position).getID();
        viewHolder.getTxtViewDate().setText(allLogRecordList.get(position).getDate());
        viewHolder.getTxtViewKilometers().setText(String.valueOf(allLogRecordList.get(position).getKilometers()));
        viewHolder.getTxtViewDetail().setText(allLogRecordList.get(position).getDetail());

        viewHolder.getIbtnEditRecord().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = viewHolder.txtViewDate.getText().toString();
                String kilometers = viewHolder.txtViewKilometers.getText().toString();
                String detail = viewHolder.txtViewDetail.getText().toString();
                Context context = view.getContext();
                Intent intent = new Intent(context, EditLogRecordActivity.class);
                intent.putExtra("ID", auto_ID);
                intent.putExtra("date", allLogRecordList.get(position).getDate());
                intent.putExtra("kilometers", String.valueOf(allLogRecordList.get(position).getKilometers()));
                intent.putExtra("detail", allLogRecordList.get(position).getDetail());
                context.startActivity(intent);

            }
        });

        viewHolder.getIbtnDeleteRecord().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDBHelper myDBHelper = new MyDBHelper(view.getContext());
                boolean success = myDBHelper.deleteLogRecord(auto_ID, allLogRecordList.get(position).getDate());
                if (success) {
                    Toast.makeText(view.getContext(), "Log Record Deleted " , Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(view.getContext(), "Log Record Delete failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return allLogRecordList.size();
    }


}
