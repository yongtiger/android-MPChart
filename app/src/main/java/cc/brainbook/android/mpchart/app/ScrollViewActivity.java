
package cc.brainbook.android.mpchart.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import cc.brainbook.android.mpchart.charts.BarChart;
import cc.brainbook.android.mpchart.components.XAxis;
import cc.brainbook.android.mpchart.components.XAxis.XAxisPosition;
import cc.brainbook.android.mpchart.data.BarData;
import cc.brainbook.android.mpchart.data.BarDataSet;
import cc.brainbook.android.mpchart.data.BarEntry;
import cc.brainbook.android.mpchart.utils.ColorTemplate;
import cc.brainbook.android.mpchart.app.notimportant.DemoBase;

import java.util.ArrayList;

@SuppressWarnings("SameParameterValue")
public class ScrollViewActivity extends DemoBase {

    private BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_scrollview);

        setTitle("ScrollViewActivity");

        chart = findViewById(R.id.chart1);

        chart.getDescription().setEnabled(false);

        // scaling can now only be done on x- and y-axis separately
        chart.setPinchZoom(false);

        chart.setDrawBarShadow(false);
        chart.setDrawGridBackground(false);

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        chart.getAxisLeft().setDrawGridLines(false);

        chart.getLegend().setEnabled(false);

        setData(10);
        chart.setFitBars(true);
    }

    private void setData(int count) {

        ArrayList<BarEntry> values = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * count) + 15;
            values.add(new BarEntry(i, (int) val));
        }

        BarDataSet set = new BarDataSet(values, "Data Set");
        set.setColors(ColorTemplate.VORDIPLOM_COLORS);
        set.setDrawValues(false);

        BarData data = new BarData(set);

        chart.setData(data);
        chart.invalidate();
        chart.animateY(800);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.only_github, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.viewGithub: {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/com/xxmassdeveloper/mpchartexample/ScrollViewActivity.java"));
                startActivity(i);
                break;
            }
        }

        return true;
    }

    @Override
    public void saveToGallery() { /* Intentionally left empty */ }
}
