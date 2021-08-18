package cc.brainbook.android.mpchart.interfaces.dataprovider;

import cc.brainbook.android.mpchart.data.ScatterData;

public interface ScatterDataProvider extends BarLineScatterCandleBubbleDataProvider {

    ScatterData getScatterData();
}
