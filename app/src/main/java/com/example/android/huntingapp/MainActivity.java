package com.example.android.huntingapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantityDucks = 0;
    int quantityGeese = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        RelativeLayout main_view = (RelativeLayout) findViewById(R.id.main_view);

        switch(item.getItemId()) {
            case R.id.menu_red:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                main_view.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu_green:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                main_view.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.menu_yellow:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                main_view.setBackgroundColor(Color.YELLOW);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * This method is called when the plus button for ducks is clicked.
     */
    public void increaseDucks(View view) {
        if (quantityDucks == 6) {
            Toast.makeText(MainActivity.this, getString(R.string.increase_toast_message), Toast.LENGTH_SHORT).show();
            return;
        }
        quantityDucks = quantityDucks + 1;
        displayQuantityDucks(quantityDucks);
    }

    /**
     * This method is called when the minus button for ducks is clicked.
     */
    public void decreaseDucks(View view) {
        if (quantityDucks == 0) {
            //decreaseToastMessage(getBaseContext());
            Toast.makeText(MainActivity.this, getString(R.string.decrease_toast_message), Toast.LENGTH_SHORT).show();
            return;
        }
        quantityDucks = quantityDucks - 1;
        displayQuantityDucks(quantityDucks);
    }

    /**
     * This method displays the number of ducks taken.
     */
    public void displayQuantityDucks(int quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.ducks_quantity_text_view);
        quantityTextView.setText("" + quantityDucks);
    }

    /**
     * This method is called when the plus button for geese is clicked.
     */
    public void increaseGeese(View view) {
        if (quantityGeese == 3) {
            Toast.makeText(MainActivity.this, getString(R.string.increase_toast_message), Toast.LENGTH_SHORT).show();
            return;
        }
        quantityGeese = quantityGeese + 1;
        displayQuantityGeese(quantityGeese);
    }

    /**
     * This method is called when the minus button for geese is clicked.
     */
    public void decreaseGeese(View view) {
        if (quantityGeese == 0) {
            Toast.makeText(MainActivity.this, getString(R.string.decrease_toast_message), Toast.LENGTH_SHORT).show();
            return;
        }
        quantityGeese = quantityGeese - 1;
        displayQuantityGeese(quantityGeese);
    }

    /**
     * This method displays the number of geese taken.
     */
    public void displayQuantityGeese(int quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.geese_quantity_text_view);
        quantityTextView.setText("" + quantityGeese);
    }
}
