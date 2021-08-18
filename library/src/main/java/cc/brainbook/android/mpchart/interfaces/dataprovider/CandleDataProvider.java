package cc.brainbook.android.mpchart.interfaces.dataprovider;

import cc.brainbook.android.mpchart.data.CandleData;

public interface CandleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    CandleData getCandleData();
}
