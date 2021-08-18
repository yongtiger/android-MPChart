package cc.brainbook.android.mpchart.app.custom;

import cc.brainbook.android.mpchart.formatter.IFillFormatter;
import cc.brainbook.android.mpchart.interfaces.dataprovider.LineDataProvider;
import cc.brainbook.android.mpchart.interfaces.datasets.ILineDataSet;

/**
 * Created by Philipp Jahoda on 12/09/15.
 */
@SuppressWarnings("unused")
public class MyFillFormatter implements IFillFormatter
{

    private float fillPos;

    public MyFillFormatter(float fillPos) {
        this.fillPos = fillPos;
    }

    @Override
    public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
        // your logic could be here
        return fillPos;
    }
}
