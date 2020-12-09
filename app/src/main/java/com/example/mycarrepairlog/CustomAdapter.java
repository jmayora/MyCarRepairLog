package com.example.mycarrepairlog;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private String[] mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });
            textView = (TextView) v.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public CustomAdapter(String[] dataSet) {
        mDataSet = dataSet;
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
        viewHolder.getTextView().setText(mDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
