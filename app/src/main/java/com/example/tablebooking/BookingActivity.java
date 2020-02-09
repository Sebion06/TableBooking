package com.example.tablebooking;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class BookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        //creating the gridview
        final ImageAdapter ia = new ImageAdapter(this);
        final GridView gridview = (GridView) findViewById(R.id.gridview);

        //gridview.setAdapter(new ImageAdapter(this));
        gridview.setAdapter(ia);
        gridview.getSelector().setAlpha(0);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {


                //get it's position and check if the right kind of table

                final int pos=position;
                Integer[] array = ia.getmThumbIds();
                if (array[position] == R.drawable.table_black) {
                    gridview.getSelector().setAlpha(255);
                    Toast.makeText(com.example.tablebooking.BookingActivity.this, "" + position, Toast.LENGTH_SHORT).show();


                    final Button button = (Button) findViewById(R.id.actBooking_bookButton);
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            //verify if the right table is still selected by checking the alpha and we kill it afterwards

                            if(gridview.getSelector().getAlpha()==255) {
                                gridview.getSelector().setAlpha(0);
                                Toast.makeText(com.example.tablebooking.BookingActivity.this, "Your table has been booked!", Toast.LENGTH_LONG).show();     //yay!

                                //ia is the new image adapter that.. adapts to the changes
                                //changing the table to a "booked" and red one (that's also not clickable

                                ia.mThumbIds[pos]=R.drawable.table_red;


                                //set the new adapter with the booked tables for the gridview and refresh the whole thing
                                gridview.setAdapter(ia);
                                ia.notifyDataSetChanged();
                                gridview.invalidateViews();

                            }
                        }
                    });

                } else {

                    //if it's not the right kind of table after a click, we do a little trick and we kill the little prick and by that I mean the Alpha

                    gridview.getSelector().setAlpha(0);
                }
            }
        });

    }
}