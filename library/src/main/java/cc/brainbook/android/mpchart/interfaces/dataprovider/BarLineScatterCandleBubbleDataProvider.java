package cc.brainbook.android.mpchart.interfaces.dataprovider;

import cc.brainbook.android.mpchart.components.YAxis.AxisDependency;
import cc.brainbook.android.mpchart.data.BarLineScatterCandleBubbleData;
import cc.brainbook.android.mpchart.utils.Transformer;

public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {

    Transformer getTransformer(AxisDependency axis);
    boolean isInverted(AxisDependency axis);
    
    float getLowestVisibleX();
    float getHighestVisibleX();

    BarLineScatterCandleBubbleData getData();
}
