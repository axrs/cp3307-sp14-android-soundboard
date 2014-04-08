package com.cadcoder.SoundBoard;

import android.graphics.Canvas;
import android.view.View;

public interface SoundStrategy {
    void paintRegions(Canvas canvas);

    void onTouch(float x, float y);

    void init(View view);
}
