package com.example.jitender.recyclerview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class MyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<String> myDataset = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            myDataset.add(i + "");
        }

        RecyclerView.Adapter adapter = new MyCustomAdapter(MyActivity.this, myDataset);
        recyclerView.setAdapter(adapter);
    }
}
