package com.cadcoder.SoundBoard;

import android.content.Context;
import android.graphics.RectF;
import android.media.SoundPool;

/**
 * Created by Xander on 8/04/2014.
 */
public class DrumFactory {


    private static InstrumentComponent createComponent(float left, float top, float right, float bottom) {
        RectF bounds = new RectF(left, top, right, bottom);

        InstrumentComponent component = new InstrumentComponent(bounds);
        return component;
    }


    public static InstrumentComponent CreateSnare(Context context, float widthRatio, float heightRatio, SoundPool pool) {
        float left = 615 * widthRatio;
        float top = 665 * heightRatio;
        float right = (615 + 408) * widthRatio;
        float bottom = (665 + 391) * heightRatio;
        InstrumentComponent c = createComponent(left, top, right, bottom);
        int res = pool.load(context, R.raw.snare, 1);
        c.setResourceId(res);
        return c;
    }

    public static InstrumentComponent CreateFloorDrum(Context context, float widthRatio, float heightRatio, SoundPool pool) {
        float left = 1040 * widthRatio;
        float top = 832 * heightRatio;
        float right = (1040 + 172) * widthRatio;
        float bottom = (832 + 348) * heightRatio;
        InstrumentComponent c = createComponent(left, top, right, bottom);
        int res = pool.load(context, R.raw.kick, 1);
        c.setResourceId(res);
        return c;
    }


    public static InstrumentComponent CreateChina(Context context, float widthRatio, float heightRatio, SoundPool pool) {
        float left = 1576 * widthRatio;
        float top = 889 * heightRatio;
        float right = (1576 + 344) * widthRatio;
        float bottom = (889 + 551) * heightRatio;
        InstrumentComponent c = createComponent(left, top, right, bottom);
        int res = pool.load(context, R.raw.china, 1);
        c.setResourceId(res);
        return c;
    }

    public static InstrumentComponent CreateLowTom(Context context, float widthRatio, float heightRatio, SoundPool pool) {
        float left = 1144 * widthRatio;
        float top = 376 * heightRatio;
        float right = (1144 + 395) * widthRatio;
        float bottom = (376 + 387) * heightRatio;
        InstrumentComponent c = createComponent(left, top, right, bottom);
        int res = pool.load(context, R.raw.tom_low, 1);
        c.setResourceId(res);
        return c;
    }


    public static InstrumentComponent CreateSplash(Context context, float widthRatio, float heightRatio, SoundPool pool) {
        float left = 952 * widthRatio;
        float top = 94 * heightRatio;
        float right = (952 + 326) * widthRatio;
        float bottom = (94 + 310) * heightRatio;
        InstrumentComponent c = createComponent(left, top, right, bottom);
        int res = pool.load(context, R.raw.splash, 1);
        c.setResourceId(res);
        return c;
    }

    public static InstrumentComponent CreateMidTom(Context context, float widthRatio, float heightRatio, SoundPool pool) {
        float left = 794 * widthRatio;
        float top = 368 * heightRatio;
        float right = (794 + 309) * widthRatio;
        float bottom = (368 + 312) * heightRatio;
        InstrumentComponent c = createComponent(left, top, right, bottom);
        int res = pool.load(context, R.raw.tom_med, 1);
        c.setResourceId(res);
        return c;
    }


    public static InstrumentComponent CreateHiTom(Context context, float widthRatio, float heightRatio, SoundPool pool) {
        float left = 436 * widthRatio;
        float top = 443 * heightRatio;
        float right = (436 + 323) * widthRatio;
        float bottom = (443 + 271) * heightRatio;
        InstrumentComponent c = createComponent(left, top, right, bottom);
        int res = pool.load(context, R.raw.tom_high, 1);
        c.setResourceId(res);
        return c;
    }

    public static InstrumentComponent CreateCrash(Context context, float widthRatio, float heightRatio, SoundPool pool) {
        float left = 381 * widthRatio;
        float top = 0 * heightRatio;
        float right = (381 + 506) * widthRatio;
        float bottom = (0 + 440) * heightRatio;
        InstrumentComponent c = createComponent(left, top, right, bottom);
        int res = pool.load(context, R.raw.crash, 1);
        c.setResourceId(res);
        return c;
    }

    public static InstrumentComponent CreateHiHat(Context context, float widthRatio, float heightRatio, SoundPool pool) {
        float left = 42 * widthRatio;
        float top = 554 * heightRatio;
        float right = (42 + 410) * widthRatio;
        float bottom = (554 + 382) * heightRatio;
        InstrumentComponent c = createComponent(left, top, right, bottom);
        int res = pool.load(context, R.raw.hi_hat, 1);
        c.setResourceId(res);
        return c;
    }


    public static InstrumentComponent CreateRide(Context context, float widthRatio, float heightRatio, SoundPool pool) {
        float left = 1322 * widthRatio;
        float top = 101 * heightRatio;
        float right = (1322 + 573) * widthRatio;
        float bottom = (101 + 531) * heightRatio;
        InstrumentComponent c = createComponent(left, top, right, bottom);
        int res = pool.load(context, R.raw.ride, 1);
        c.setResourceId(res);
        return c;
    }

    public static InstrumentComponent CreateHiFloorTom(Context context, float widthRatio, float heightRatio, SoundPool pool) {
        float left = 1218 * widthRatio;
        float top = 770 * heightRatio;
        float right = (1218 + 432) * widthRatio;
        float bottom = (770 + 420) * heightRatio;
        InstrumentComponent c = createComponent(left, top, right, bottom);
        int res = pool.load(context, R.raw.tom_floor_high, 1);
        c.setResourceId(res);
        return c;
    }

    public static InstrumentComponent CreateLowFloorTom(Context context, float widthRatio, float heightRatio, SoundPool pool) {
        float left = 1229 * widthRatio;
        float top = 1218 * heightRatio;
        float right = (1229 + 426) * widthRatio;
        float bottom = (1218 + 315) * heightRatio;
        InstrumentComponent c = createComponent(left, top, right, bottom);
        int res = pool.load(context, R.raw.tom_floor_low, 1);
        c.setResourceId(res);
        return c;
    }

}
