package com.example.tablebooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.Toast;

public class LayoutActivity extends AppCompatActivity {

    int touches=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        final GridView gridview = (GridView) findViewById(R.id.actbooking_tablesLayout);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.getSelector().setAlpha(0);
        final ImageAdapter ia = new ImageAdapter(this);

        final Button button1 = (Button) findViewById(R.id.actLayout_chairButton);
        final Button button2 = (Button) findViewById(R.id.actLayout_tableButton);
        final Button button3 = (Button) findViewById(R.id.actLayout_deleteButton);

        //button for adding chairs
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                touches=0;

                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                        /*
                        if(touches==0) {
                            ia.mThumbIds[position] = R.drawable.chair_black;
                            touches++;
                        }
                        if(touches==1) {
                            ia.mThumbIds[position] = R.drawable.chair_black_right;
                            touches++;
                        }
                        if(touches==2) {
                            ia.mThumbIds[position] = R.drawable.chair_black_down;
                            touches++;
                        }
                        if(touches==3) {
                            ia.mThumbIds[position] = R.drawable.chair_black_left;
                            touches=0;
                        }
                        */
                        //TODO: ^^^^^ THIS ^^^^^
                        ia.mThumbIds[position] = R.drawable.chair_black;

                        gridview.setAdapter(ia);
                        ia.notifyDataSetChanged();
                        gridview.invalidateViews();

                    }
                });
            }});


        //button for adding tables
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                        ia.mThumbIds[position]=R.drawable.table_black;
                        gridview.setAdapter(ia);
                        ia.notifyDataSetChanged();
                        gridview.invalidateViews();

                    }
                });

            }});


        //button for adding empty space (deleting)
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                        ia.mThumbIds[position]=R.drawable.empty;
                        gridview.setAdapter(ia);
                        ia.notifyDataSetChanged();
                        gridview.invalidateViews();

                    }
                });

            }});

    }
}
