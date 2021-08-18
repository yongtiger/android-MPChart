
package cc.brainbook.android.mpchart.app.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;

import cc.brainbook.android.mpchart.components.MarkerView;
import cc.brainbook.android.mpchart.data.BarEntry;
import cc.brainbook.android.mpchart.data.Entry;
import cc.brainbook.android.mpchart.highlight.Highlight;
import cc.brainbook.android.mpchart.utils.MPPointF;
import cc.brainbook.android.mpchart.utils.Utils;
import cc.brainbook.android.mpchart.app.R;

/**
 * Custom implementation of the MarkerView.
 *
 * @author Philipp Jahoda
 */
@SuppressWarnings("unused")
@SuppressLint("ViewConstructor")
public class StackedBarsMarkerView extends MarkerView {

    private TextView tvContent;

    public StackedBarsMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);

        tvContent = findViewById(R.id.tvContent);
    }

    // runs every time the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {

        if (e instanceof BarEntry) {

            BarEntry be = (BarEntry) e;

            if(be.getYVals() != null) {

                // draw the stack value
                tvContent.setText(Utils.formatNumber(be.getYVals()[highlight.getStackIndex()], 0, true));
            } else {
                tvContent.setText(Utils.formatNumber(be.getY(), 0, true));
            }
        } else {

            tvContent.setText(Utils.formatNumber(e.getY(), 0, true));
        }

        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }
}
