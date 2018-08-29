package com.tmarat.instagramclient.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import com.tmarat.instagramclient.R;
import com.tmarat.instagramclient.model.Theme;

public class ThemeView extends View {

  private Paint boarderPaint;
  private Paint backgroundPaint;
  private Paint primaryPaint;
  private Paint primaryDarkPaint;
  private Paint accentPaint;
  private Paint actionPaint;

  private float stroke;

  private Theme theme =
      new Theme(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent);

  public ThemeView(Context context) {
    super(context);
    init();
  }

  public ThemeView(Context context,
      @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public ThemeView(Context context,
      @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  public void setTheme(Theme theme) {
    this.theme = theme;
    init();
  }

  private void init() {

    boarderPaint = new Paint();
    boarderPaint.setStyle(Paint.Style.STROKE);
    if (this.isSelected()) {
      boarderPaint.setColor(Color.BLUE);
    } else {
      boarderPaint.setColor(Color.GRAY);
    }

    backgroundPaint = new Paint();
    backgroundPaint.setStyle(Paint.Style.FILL);
    backgroundPaint.setColor(Color.WHITE);

    primaryPaint = new Paint();
    primaryPaint.setStyle(Paint.Style.FILL);
    primaryPaint.setColor(ContextCompat.getColor(getContext(), theme.getPrimaryColor()));

    primaryDarkPaint = new Paint();
    primaryDarkPaint.setStyle(Paint.Style.FILL);
    primaryDarkPaint.setColor(ContextCompat.getColor(getContext(), theme.getPrimaryDarkColor()));

    accentPaint = new Paint();
    accentPaint.setStyle(Paint.Style.FILL);
    accentPaint.setColor(ContextCompat.getColor(getContext(), theme.getAccentColor()));
    accentPaint.setAntiAlias(true);
    accentPaint.setDither(true);

    actionPaint = new Paint();
    actionPaint.setStyle(Paint.Style.FILL);
    actionPaint.setColor(Color.BLACK);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    final float height = getHeight();
    final float width = getWidth();
    stroke = height * 6 / 100f;
    final float statusbar = height * 12 / 100f;
    final float toolbar = height * 25 / 100f;
    final float actionbar = height * 12 / 100f;

    if (this.isActivated()) {
      boarderPaint.setColor(ContextCompat.getColor(getContext(), R.color.themeSelected));
    } else {
      boarderPaint.setColor(ContextCompat.getColor(getContext(), R.color.themeDeselected));
    }

    boarderPaint.setStrokeWidth(stroke);

    canvas.drawRect(0, 0, width, height, backgroundPaint);
    canvas.drawRect(0, 0, width, statusbar, primaryDarkPaint);
    canvas.drawRect(0, statusbar, width, toolbar, primaryPaint);
    canvas.drawRect(0,height - actionbar, width, height, actionPaint);
    canvas.drawCircle(width * 75 / 100f, height * 75 / 100f, height * 8 / 100, accentPaint);
    canvas.drawRect(0, 0, width, height, boarderPaint);
  }
}
