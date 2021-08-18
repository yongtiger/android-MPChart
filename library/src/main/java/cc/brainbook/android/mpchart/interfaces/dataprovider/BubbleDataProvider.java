package cc.brainbook.android.mpchart.interfaces.dataprovider;

import cc.brainbook.android.mpchart.data.BubbleData;

public interface BubbleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    BubbleData getBubbleData();
}
