package com.cadcoder.SoundBoard;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xander on 8/04/2014.
 */
public class DrumKitSoundStrategy implements SoundStrategy {

    private View _view;

    private SoundPool _soundPool;
    private SoundThread _soundThread;

    //Drum Kit Image Size
    private static final int DEFAULT_WIDTH = 1920;
    private static final int DEFAULT_HEIGHT = 1440;

    //Scaling ratio for accurate hit tests
    private float _heightRatio = 1.0f;
    private float _widthRatio = 1.0f;
    private static Paint _PEN;

    private static final String TAG = "DrumKitSoundStrategy";

    private List<InstrumentComponent> _components;

    private List<InstrumentComponent> getComponents() {
        if (_components == null) {
            _components = new ArrayList<InstrumentComponent>();
        }
        return _components;
    }

    private SoundPool getSoundPool() {
        if (_soundPool == null) {
            _soundPool = new SoundPool(12, AudioManager.STREAM_MUSIC, 0);
        }
        return _soundPool;
    }

    private SoundThread getSoundThread() {
        if (_soundThread == null) {
            _soundThread = new SoundThread(getSoundPool());
            _soundThread.start();
        }
        return _soundThread;
    }

    private static Paint GetPen() {
        if (_PEN == null) {
            _PEN = new Paint();
            _PEN.setColor(Color.RED);
            _PEN.setAntiAlias(true);

            _PEN.setStrokeWidth(2);
            _PEN.setStyle(Paint.Style.STROKE);
            _PEN.setStrokeJoin(Paint.Join.ROUND);
            _PEN.setStrokeCap(Paint.Cap.ROUND);
        }
        return _PEN;
    }

    @Override
    public void paintRegions(Canvas canvas) {

        for (InstrumentComponent component : getComponents()) {
            canvas.drawRect(component.getBounds(), GetPen());
        }
    }

    @Override
    public void onTouch(float x, float y) {
        PointF p = new PointF(x, y);

        for (InstrumentComponent c : getComponents()) {
            if (c.hitTest(p)) {
                Log.d(TAG, "Hit");
                getSoundThread()._playList.add(c);
                break;
            }
        }
    }

    @Override
    public void init(View view) {
        _view = view;
        view.setBackgroundResource(R.drawable.drums);
        calculateViewRatio();
        clearComponents();
        createComponents();
    }


    private void clearComponents() {
        _components = null;
    }

    private void createComponents() {
        getComponents().add(DrumFactory.CreateSnare(_view.getContext(), _widthRatio, _heightRatio, getSoundPool()));
        getComponents().add(DrumFactory.CreateHiHat(_view.getContext(), _widthRatio, _heightRatio, getSoundPool()));
        getComponents().add(DrumFactory.CreateRide(_view.getContext(), _widthRatio, _heightRatio, getSoundPool()));
        getComponents().add(DrumFactory.CreateCrash(_view.getContext(), _widthRatio, _heightRatio, getSoundPool()));
        getComponents().add(DrumFactory.CreateSplash(_view.getContext(), _widthRatio, _heightRatio, getSoundPool()));
        getComponents().add(DrumFactory.CreateChina(_view.getContext(), _widthRatio, _heightRatio, getSoundPool()));
        getComponents().add(DrumFactory.CreateHiTom(_view.getContext(), _widthRatio, _heightRatio, getSoundPool()));
        getComponents().add(DrumFactory.CreateMidTom(_view.getContext(), _widthRatio, _heightRatio, getSoundPool()));
        getComponents().add(DrumFactory.CreateLowTom(_view.getContext(), _widthRatio, _heightRatio, getSoundPool()));
        getComponents().add(DrumFactory.CreateHiFloorTom(_view.getContext(), _widthRatio, _heightRatio, getSoundPool()));
        getComponents().add(DrumFactory.CreateLowFloorTom(_view.getContext(), _widthRatio, _heightRatio, getSoundPool()));
        getComponents().add(DrumFactory.CreateFloorDrum(_view.getContext(), _widthRatio, _heightRatio, getSoundPool()));
    }

    private void calculateViewRatio() {
        _heightRatio = (float) _view.getHeight() / DEFAULT_HEIGHT;
        _widthRatio = (float) _view.getWidth() / DEFAULT_WIDTH;
    }
}
