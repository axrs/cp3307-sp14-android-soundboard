package com.cadcoder.SoundBoard;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Soundview extends View {

    private Boolean _paintRegions = true;

    private SoundStrategy _soundStrategy;

    public Soundview(Context context) {
        super(context);
    }

    public Soundview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Soundview(Context context, AttributeSet attrs, int defStyle) {
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
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getSoundStrategy().onTouch(event.getX(), event.getY());
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
