package com.example.mycarrepairlog;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private List<AutoModel> allAutosList;
    ConstraintLayout lvItemView;

    public List<AutoModel> getAllAutosList() {
        return allAutosList;
    }

    public void setAllAutosList(List<AutoModel> allAutosList) {
        this.allAutosList = allAutosList;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtViewRecordID, txtViewBrand, txtViewModel, txtViewYear;
        private ImageView ivEdit, ivAddLog;

        public ViewHolder(View v) {
            super(v);
            lvItemView = (ConstraintLayout) v.findViewById(R.id.lvItemView);
            ivEdit = (ImageView) v.findViewById(R.id.ivEdit);
            ivAddLog = (ImageView) v.findViewById(R.id.ivAddLog);
            txtViewRecordID = (TextView) v.findViewById(R.id.txtViewRecordID);
            txtViewBrand = (TextView) v.findViewById(R.id.txtViewBrand);
            txtViewModel = (TextView) v.findViewById(R.id.txtViewModel);
            txtViewYear  = (TextView) v.findViewById(R.id.txtViewYear);
        }

        public TextView getTxtViewRecordID() { return txtViewRecordID; }
        public TextView getTxtViewBrand() { return txtViewBrand; }
        public TextView getTxtViewModel() { return txtViewModel; }
        public TextView getTxtViewYear() { return txtViewYear; }
    }

    public CustomAdapter(List<AutoModel> allAutosList) {

        this.allAutosList = allAutosList;
    }


        @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {


            // Create a new view.
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_view, viewGroup, false);

            return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getTxtViewRecordID().setText(String.valueOf(allAutosList.get(position).getID()));
        viewHolder.getTxtViewBrand().setText(allAutosList.get(position).getBrand());
        viewHolder.getTxtViewModel().setText(allAutosList.get(position).getModel());
        viewHolder.getTxtViewYear().setText(String.valueOf(allAutosList.get(position).getYear()));

        viewHolder.ivEdit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Log.d(TAG, "Element " + position + " clicked.");
                int recordID = Integer.parseInt((String) viewHolder.getTxtViewRecordID().getText());
                String autoBrand = (String) viewHolder.getTxtViewBrand().getText();
                String autoModel = (String) viewHolder.getTxtViewModel().getText();
                int autoYear = Integer.parseInt((String) viewHolder.getTxtViewYear().getText());

                Toast.makeText(view.getContext(), "Hello " + recordID + " , " +
                        autoBrand + " , " + autoModel + " , " + autoYear, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, UpdateCarActivity.class);
                intent.putExtra("autoBrand", autoBrand );
                intent.putExtra("autoModel", autoModel);
                intent.putExtra("autoYear", autoYear);
                intent.putExtra("ID", recordID);
                context.startActivity(intent);
            }
        });

        viewHolder.ivAddLog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            Context context = view.getContext();
            int recordID = Integer.parseInt((String) viewHolder.getTxtViewRecordID().getText());
            String autoBrand = (String) viewHolder.getTxtViewBrand().getText();
            String autoModel = (String) viewHolder.getTxtViewModel().getText();
            int autoYear = Integer.parseInt((String) viewHolder.getTxtViewYear().getText());

            Toast.makeText(view.getContext(), "Hello " + recordID + " , " +
                    autoBrand + " , " + autoModel + " , " + autoYear, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, AddRecordActivity.class);
            intent.putExtra("autoBrand", autoBrand );
            intent.putExtra("autoModel", autoModel);
            intent.putExtra("autoYear", autoYear);
            intent.putExtra("ID", recordID);
            context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allAutosList.size();
    }
}
