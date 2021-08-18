
package cc.brainbook.android.mpchart.app.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import cc.brainbook.android.mpchart.components.MarkerView;
import cc.brainbook.android.mpchart.data.Entry;
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
public class RadarMarkerView extends MarkerView {

    private final TextView tvContent;
    private final DecimalFormat format = new DecimalFormat("##0");

    public RadarMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);

        tvContent = findViewById(R.id.tvContent);
        tvContent.setTypeface(Typeface.createFromAsset(context.getAssets(), "OpenSans-Light.ttf"));
    }

    // runs every time the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        tvContent.setText(String.format("%s %%", format.format(e.getY())));

        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight() - 10);
    }
}
