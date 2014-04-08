package com.cadcoder.SoundBoard;

import android.media.SoundPool;
import android.util.Log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SoundThread extends Thread {

    private SoundPool _pool;
    public BlockingQueue<InstrumentComponent> _playList = new LinkedBlockingQueue<InstrumentComponent>();
    public boolean stop = false;

    public SoundThread(SoundPool soundPool) {
        this._pool = soundPool;
    }

    public void addComponent(InstrumentComponent component) {
        _playList.add(component);
    }

    @Override
    public void run() {
        try {
            InstrumentComponent instrumentComponent;
            while (!stop) {

                instrumentComponent = _playList.take();
                _pool.play(instrumentComponent.getResourceId(), 100, 100, 0, 0, 1);
            }

        } catch (InterruptedException e) {
            Log.e("SoundThread", e.toString());
        }
    }
}
