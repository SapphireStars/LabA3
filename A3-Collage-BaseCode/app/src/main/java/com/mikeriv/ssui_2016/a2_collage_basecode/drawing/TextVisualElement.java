package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;

public class TextVisualElement extends BaseVisualElement {
    //TextVisualElement(60, 60,TEST_TEXT, Typeface.DEFAULT_BOLD, 25f)
    private Typeface typeFace;
    private String text;
    private float fontSize;
    private float width;
    private float height;

    public TextVisualElement(float xLoc, float yLoc, String text, Typeface typeFace, float fontSize) {
        super(xLoc, yLoc, 0, 0);
        this.typeFace = typeFace;
        this.fontSize = fontSize;
        this.text = text;
    }
    @Override
    public void draw(Canvas oncanvas){
        Paint paint = new Paint();
        paint.setTextSize(this.fontSize);
        paint.setTypeface(typeFace);
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        this.width = rect.width();//文本的宽度
        this.height = rect.height();//文本的高度
        oncanvas.save();
        oncanvas.translate(this.getX(), this.getY());
        oncanvas.drawText(this.text,this.getX(), this.getY(), paint);
        oncanvas.clipRect(0,0,this.getW(),this.getH());
        oncanvas.restore();
    }
}
