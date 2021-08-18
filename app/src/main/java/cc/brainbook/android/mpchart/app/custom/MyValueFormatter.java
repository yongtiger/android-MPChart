package cc.brainbook.android.mpchart.app.custom;

import cc.brainbook.android.mpchart.data.Entry;
import cc.brainbook.android.mpchart.formatter.IValueFormatter;
import cc.brainbook.android.mpchart.utils.ViewPortHandler;

import java.text.DecimalFormat;

public class MyValueFormatter implements IValueFormatter
{

    private final DecimalFormat mFormat;

    public MyValueFormatter() {
        mFormat = new DecimalFormat("###,###,###,##0.0");
    }

    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        return mFormat.format(value) + " $";
    }
}
