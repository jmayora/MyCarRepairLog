package com.example.mycarrepairlog;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private List<AutoModel> allAutosList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtViewRecordID, txtViewBrand, txtViewModel, txtViewYear;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });
            txtViewRecordID = (TextView) v.findViewById(R.id.txtViewRecordID);
            txtViewBrand = (TextView) v.findViewById(R.id.txtViewBrand);
            txtViewModel = (TextView) v.findViewById(R.id.txtViewModel);
            txtViewYear  = (TextView) v.findViewById(R.id.txtViewYear);
        }

        public TextView getTxtViewRecordID() { return txtViewRecordID; }
        public TextView getTxtViewBrand() {
            return txtViewBrand;
        }
        public TextView getTxtViewModel() { return txtViewModel; }
        public TextView getTxtViewYear() { return txtViewYear; }
    }

    public CustomAdapter(List<AutoModel> allAutosList) {

        this.allAutosList = allAutosList;
    }


        @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

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
    }

    @Override
    public int getItemCount() {
        return allAutosList.size();
    }
}
