package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class SolidBackDrop extends BaseVisualElement {
    private int color;
    public SolidBackDrop(float xLoc, float yLoc, float width, float height, int color) {
        super(xLoc, yLoc, width, height);
        this.color = color;
    }

    @Override
    public void draw(Canvas oncanvas){
        Paint paint = new Paint();
        paint.setColor(color);
        oncanvas.save();
        oncanvas.translate(this.getX(), this.getY());
        oncanvas.drawRect(0, 0, this.getW(), this.getH(), paint);
        oncanvas.clipRect(0,0,this.getW(),this.getH());
        oncanvas.restore();
        for(int i=0;i<children.size();i++) {
            VisualElement child=children.get(i);
            oncanvas.save();
            oncanvas.translate(child.getX(),child.getY());
            oncanvas.clipRect(0,0,child.getW(),child.getH());
            children.get(i).draw(oncanvas);
            oncanvas.restore();
        }
    }
}
