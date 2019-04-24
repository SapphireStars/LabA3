package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;

public class OvalClip extends BaseVisualElement {

    public OvalClip(float x, float y,float w, float h){
        super(x,y,w,h);
    }

    @Override
    public void draw(Canvas oncanvas){
        oncanvas.save();
        Path path = new Path();
        path.addOval(new RectF(0,0,getW(),getH()),Path.Direction.CCW);
        oncanvas.clipPath(path);
        for(int i=0;i<children.size();i++) {
            VisualElement child=children.get(i);
            oncanvas.save();
            oncanvas.translate(child.getX(),child.getY());
            oncanvas.clipRect(0,0,child.getW(),child.getH());
            children.get(i).draw(oncanvas);
            oncanvas.restore();
        }
        oncanvas.restore();
    }

}
