package cc.brainbook.android.mpchart.app.custom;

import android.graphics.Canvas;
import android.graphics.Paint;

import cc.brainbook.android.mpchart.interfaces.datasets.IScatterDataSet;
import cc.brainbook.android.mpchart.renderer.scatter.IShapeRenderer;
import cc.brainbook.android.mpchart.utils.ViewPortHandler;

/**
 * Custom shape renderer that draws a single line.
 * Created by philipp on 26/06/16.
 */
public class CustomScatterShapeRenderer implements IShapeRenderer
{

    @Override
    public void renderShape(Canvas c, IScatterDataSet dataSet, ViewPortHandler viewPortHandler,
                            float posX, float posY, Paint renderPaint) {

        final float shapeHalf = dataSet.getScatterShapeSize() / 2f;

        c.drawLine(
                posX - shapeHalf,
                posY - shapeHalf,
                posX + shapeHalf,
                posY + shapeHalf,
                renderPaint);
    }
}
