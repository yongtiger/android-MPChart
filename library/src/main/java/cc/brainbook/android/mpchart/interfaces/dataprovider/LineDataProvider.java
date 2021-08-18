package cc.brainbook.android.mpchart.interfaces.dataprovider;

import cc.brainbook.android.mpchart.components.YAxis;
import cc.brainbook.android.mpchart.data.LineData;

public interface LineDataProvider extends BarLineScatterCandleBubbleDataProvider {

    LineData getLineData();

    YAxis getAxis(YAxis.AxisDependency dependency);
}
