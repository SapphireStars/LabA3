package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;


import android.graphics.Canvas;
import android.graphics.RectF;

public class ColumnLayout extends BaseVisualElement {

    public ColumnLayout(float x,float y,float w,float h){
        super(x,y,w,h);
    }

    @Override
    public void doLayout(){
        float y=0;
        for(int i=0;i<getNumChildren();i++){
            VisualElement child = children.get(i);
            child.setX(getW()/2-child.getW()/2);
            child.setY(y);
            y+=child.getH();
        }
        for (int i = 0; i < children.size(); i++) {
            VisualElement child = children.get(i);
            child.doLayout();
        }
    }

    @Override
    public void draw(Canvas oncanvas){
        oncanvas.save();
        oncanvas.clipRect(new RectF(0,0,getW(),getH()));
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
