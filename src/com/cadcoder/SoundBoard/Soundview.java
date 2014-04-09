package com.cadcoder.SoundBoard;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SoundView extends View {

    private Boolean _paintRegions = false;

    private SoundStrategy _soundStrategy;

    public SoundView(Context context) {
        super(context);
    }

    public SoundView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SoundView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private SoundStrategy getSoundStrategy() {
        if (_soundStrategy == null) {
            _soundStrategy = new DrumKitSoundStrategy();
            _soundStrategy.init(this);
        }
        return _soundStrategy;
    }

    private void setSoundStrategy(SoundStrategy strategy) {
        _soundStrategy = strategy;
        _soundStrategy.init(this);
    }


    public void setDrawRegions(Boolean doPaint) {
        _paintRegions = doPaint;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                getSoundStrategy().onTouch(event.getX(), event.getY());
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                for (int i = 1; i < event.getPointerCount(); i++) {
                    int index = event.findPointerIndex(event.getPointerId(i));
                    getSoundStrategy().onTouch(event.getX(index), event.getY(index));
                }
                break;
        }
        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        getSoundStrategy().init(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (_paintRegions) {
            getSoundStrategy().paintRegions(canvas);
        }
    }
}
