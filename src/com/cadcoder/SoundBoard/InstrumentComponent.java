package com.cadcoder.SoundBoard;

import android.graphics.PointF;
import android.graphics.RectF;

public class InstrumentComponent extends Audible {

    private RectF _hitBounds;
    private int _resourceId = 0;

    public InstrumentComponent(RectF bounds) {
        setBounds(bounds);
    }

    public InstrumentComponent(RectF bounds, int resId) {
        setBounds(bounds);
        setResourceId(resId);
    }

    public RectF getBounds() {
        return _hitBounds;
    }

    public void setBounds(RectF bounds) {
        _hitBounds = bounds;
    }

    public boolean hitTest(PointF point) {
        return getBounds().contains(point.x, point.y);
    }

    public void setResourceId(int resId) {
        _resourceId = resId;
    }

    public int getResourceId() {
        return _resourceId;
    }
}
