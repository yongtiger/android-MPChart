
package cc.brainbook.android.mpchart.app.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;

import cc.brainbook.android.mpchart.components.MarkerView;
import cc.brainbook.android.mpchart.data.Entry;
import cc.brainbook.android.mpchart.formatter.IAxisValueFormatter;
import cc.brainbook.android.mpchart.highlight.Highlight;
import cc.brainbook.android.mpchart.utils.MPPointF;
import cc.brainbook.android.mpchart.app.R;

import java.text.DecimalFormat;

/**
 * Custom implementation of the MarkerView.
 *
 * @author Philipp Jahoda
 */
@SuppressLint("ViewConstructor")
public class XYMarkerView extends MarkerView {

    private final TextView tvContent;
    private final IAxisValueFormatter xAxisValueFormatter;

    private final DecimalFormat format;

    public XYMarkerView(Context context, IAxisValueFormatter xAxisValueFormatter) {
        super(context, R.layout.custom_marker_view);

        this.xAxisValueFormatter = xAxisValueFormatter;
        tvContent = findViewById(R.id.tvContent);
        format = new DecimalFormat("###.0");
    }

    // runs every time the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {

        tvContent.setText(String.format("x: %s, y: %s", xAxisValueFormatter.getFormattedValue(e.getX(), null), format.format(e.getY())));

        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }
}
