package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.RectF;

public class NinePartImage extends BaseVisualElement {
    NinePatch patches;
    public NinePartImage(float x, float y, float w, float h, NinePatch patches){
        super(x,y,w,h);
        this.patches=patches;
    }

    @Override
    public void draw(Canvas oncanvas){
        patches.draw(oncanvas,new RectF(0,0,getW(),getH()));
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
