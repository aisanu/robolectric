package org.robolectric.shadows;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

@SuppressWarnings({"UnusedDeclaration"})
@Implements(ScaleGestureDetector.class)
public class ShadowScaleGestureDetector {

  private MotionEvent onTouchEventMotionEvent;
  private ScaleGestureDetector.OnScaleGestureListener listener;
  private float scaleFactor = 1;
  private float focusX;
  private float focusY;

  @Implementation
  protected void __constructor__(
      Context context, ScaleGestureDetector.OnScaleGestureListener listener) {
    this.listener = listener;
  }

  @Implementation
  protected boolean onTouchEvent(MotionEvent event) {
    onTouchEventMotionEvent = event;
    return true;
  }

  public MotionEvent getOnTouchEventMotionEvent() {
    return onTouchEventMotionEvent;
  }

  public void reset() {
    onTouchEventMotionEvent = null;
    scaleFactor = 1;
    focusX = 0;
    focusY = 0;
  }

  public ScaleGestureDetector.OnScaleGestureListener getListener() {
    return listener;
  }

  public void setScaleFactor(float scaleFactor) {
    this.scaleFactor = scaleFactor;
  }

  @Implementation
  protected float getScaleFactor() {
    return scaleFactor;
  }

  public void setFocusXY(float focusX, float focusY) {
    this.focusX = focusX;
    this.focusY = focusY;
  }

  @Implementation
  protected float getFocusX() {
    return focusX;
  }

  @Implementation
  protected float getFocusY() {
    return focusY;
  }
}
