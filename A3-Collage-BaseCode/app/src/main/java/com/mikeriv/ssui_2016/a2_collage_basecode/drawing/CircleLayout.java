package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import java.security.CryptoPrimitive;

public class CircleLayout extends BaseVisualElement {

    private float centerX,centerY;
    private float radius;

    public CircleLayout(float x,float y,float w,float h,float layoutCenterX,float layoutCenterY,float layoutRadius){
        super(x,y,w,h);
        centerX=layoutCenterX;
        centerY=layoutCenterY;
        radius=layoutRadius;
    }

    @Override
    public void doLayout(){
        if(getNumChildren()>0) {
            double interval = 2*Math.PI / getNumChildren();
            for (int i = 0; i < getNumChildren(); i++) {
                VisualElement child = getChildAt(i);
                getChildAt(i).setY(centerY - radius * (float) Math.cos(interval * i) - child.getSize().y / 2);
                getChildAt(i).setX(centerX + radius * (float) Math.sin(interval * i) - child.getSize().x / 2);
            }
            for (int i = 0; i < children.size(); i++) {
                VisualElement child = children.get(i);
                child.doLayout();
            }
        }
    }

}
