package com.example.bt_quatrinh_1;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;


import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;


import android.view.Menu;
import android.view.MenuItem;


import android.widget.SeekBar.OnSeekBarChangeListener;

public class Main4 extends AppCompatActivity implements OnSeekBarChangeListener {
    private SeekBar skcontrol;
    private View[] panels=new View[5];
    private int[] originalColor= new int[5];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layout);
        panels[0] = (View) findViewById(R.id.table1);
        panels[1] = (View) findViewById(R.id.table2);
        panels[2] = (View) findViewById(R.id.table3);
        panels[3] = (View) findViewById(R.id.table4);
        panels[4] = (View) findViewById(R.id.table5);
        skcontrol = (SeekBar)findViewById(R.id.seekbar3);
        skcontrol.setOnSeekBarChangeListener(this);



        getOriginalColors();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.more, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.more_info) {
            showMoreInfo();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {

        setPanelsColors(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {


    }

    public void showMoreInfo() {
        DialogFragment moreInfoFragment = new moreinfo();
        moreInfoFragment.show(getFragmentManager(), "moreInfo");
    }

    private void setPanelsColors(int progressChanged) {
        for (int i = 0; i < panels.length; i++) {
            int color = originalColor[i];
            if (color != 0xffffffff && color != 0xff888888) {
                int invertColor = (0xFFFFFF - color) | 0xFF000000;
                int r = (color >> 16) & 0x000000FF;
                int g = (color >> 8) & 0x000000FF;
                int b = (color >> 0) & 0x000000FF;
                int invr = (invertColor >> 16) & 0x000000FF;
                int invg = (invertColor >> 8) & 0x000000FF;
                int invb = (invertColor >> 0) & 0x000000FF;
                int newColor = Color.rgb(
                        (int) (r + ((invr - r) * (progressChanged / 100f))),
                        (int) (g + ((invg - g) * (progressChanged / 100f))),
                        (int) (b + ((invb - b) * (progressChanged / 100f))));
//				Log.i("R", " Red: " + Color.red(newColor));
//				Log.i("G", " Green: " + Color.green(newColor));
//				Log.i("B", " Blue: " + Color.blue(newColor));
//				Log.i("RI", " Red I: " + invr);
//				Log.i("GI", " Green I: " + invg);
//				Log.i("BI", " Blue I: " + invb);
//				Log.i("COLOR", "Color: id: " + i + " , " + newColor);
                panels[i].setBackgroundColor(newColor);
            }
        }
    }

    private void getOriginalColors() {
        for (int i = 0; i < panels.length; i++) {
            originalColor[i] = ((ColorDrawable) panels[i].getBackground())
                    .getColor();
        }
    }








}



