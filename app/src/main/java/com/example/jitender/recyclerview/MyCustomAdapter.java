package com.example.jitender.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jitender on 22/07/14.
 */
public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.ViewHolder> implements View.OnClickListener,
        View.OnLongClickListener {

    private ArrayList<String> mDataset;
    private static Context sContext;

    public MyCustomAdapter(Context context, ArrayList<String> myDataset) {
        mDataset = myDataset;
        sContext = context;
    }

    @Override
    public MyCustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);

        ViewHolder holder = new ViewHolder(v);
        holder.mNameTextView.setOnClickListener(MyCustomAdapter.this);
        holder.mNameTextView.setOnLongClickListener(MyCustomAdapter.this);

        holder.mNameTextView.setTag(holder);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mNameTextView.setText(mDataset.get(position));
        Random randomGenerator = new Random();
        int red = randomGenerator.nextInt(255);
        int green = randomGenerator.nextInt(255);
        int blue = randomGenerator.nextInt(255);
        holder.mNameTextView.setTextColor(Color.argb(255, red, blue, green));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public void onClick(View view) {
        ViewHolder holder = (ViewHolder) view.getTag();
        if (view.getId() == holder.mNameTextView.getId()) {
            Toast.makeText(sContext, holder.mNameTextView.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onLongClick(View view) {
        ViewHolder holder = (ViewHolder) view.getTag();
        if (view.getId() == holder.mNameTextView.getId()) {
            mDataset.remove(holder.getPosition());

            notifyDataSetChanged();

            Toast.makeText(sContext, "Item " + holder.mNameTextView.getText() + " has been removed from list",
                    Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mNameTextView;

        public ViewHolder(View v) {
            super(v);
            mNameTextView = (TextView) v.findViewById(R.id.textView);
        }
    }


}
