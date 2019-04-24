package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class SimpleFrame extends BaseVisualElement {
    public SimpleFrame(float xLoc, float yLoc, float width, float height) {
        super(xLoc, yLoc, width, height);
    }
    @Override
    public void draw(Canvas oncanvas){
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(1);
        oncanvas.save();
        oncanvas.translate(this.getX(),this.getY());
        oncanvas.drawLine(0,0,this.getW(),0,paint);
        oncanvas.drawLine(0,0,0,this.getH(),paint);
        oncanvas.drawLine(this.getW(),0,this.getW(),this.getH(),paint);
        oncanvas.drawLine(0,this.getH(),this.getW(),this.getH(),paint);
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
