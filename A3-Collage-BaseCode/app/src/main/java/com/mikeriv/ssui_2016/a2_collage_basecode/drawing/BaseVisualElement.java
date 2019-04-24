package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

public abstract class BaseVisualElement extends PrebaseVisualElement{
    private float x;
    private float y;
    private float w;
    private float h;
    protected ArrayList<VisualElement> children;
    protected VisualElement parents;
    @Override
    public void setX(float x){
        this.x=x;
    }

    @Override
    public void setY(float y){
        this.y=y;
    }

    @Override
    public float getX(){
        return x;
    }

    @Override
    public float getY(){
        return y;
    }

    @Override
    public void setH(float h){
        if(h>=0)
            this.h=h;
    }

    @Override
    public void setW(float W){
        if(W>=0)
            this.w=W;
    }

    @Override
    public float getH(){
        return h;
    }

    @Override
    public float getW(){
        return w;
    }

    @Override
    public VisualElement getParent(){
        return parents;
    }

    @Override
    public void setParent(VisualElement element){
        parents=element;
    }

    @Override
    public int getNumChildren(){
        return children.size();
    }

    @Override
    public VisualElement getChildAt(int index) {
        if (index >= 0 && index < getNumChildren())
            return children.get(index);
        else return null;
    }

    @Override
    public int findChild(VisualElement child){
        int r=-1;
        if(children.contains(child)) {
            for (int i = 0; i < children.size(); i++) {
                if (child == children.get(i)) {
                    r = i;
                    break;
                }
            }
        }
        return r;
    }

    @Override
    public void addChild(VisualElement child){
        children.add(child);
    }

    @Override
    public void removeChildAt(int index){
        if(index>=0&&index<getNumChildren())
            children.remove(index);
    }

    @Override
    public void removeChild(VisualElement child){
        if(children.contains(child)) {
            for (int i = 0; i < children.size(); i++) {
                if (child == children.get(i)) {
                    children.remove(i);
                    break;
                }
            }
        }
    }

    @Override
    public void moveChildFirst(VisualElement child){
        if(children.contains(child)){
            children.remove(child);
            children.add(0,child);
        }
    }

    @Override
    public void moveChildLast(VisualElement child){
        if(children.contains(child)){
            children.remove(child);
            children.add(child);
        }
    }

    @Override
    public void moveChildEarlier(VisualElement child){
        if(children.contains(child)){
            VisualElement e=children.get(children.size()-1);
            children.remove(children.size()-1);
            children.add(0,e);
        }
    }

    @Override
    public void moveChildLater(VisualElement child) {
        if (children.contains(child)) {
            VisualElement e = children.get(0);
            children.remove(0);
            children.add(e);
        }
    }

    @Override
    public void doLayout(){
        for(int i=0;i<children.size();i++){
            VisualElement child = children.get(i);
            child.doLayout();
        }
    }

    @Override
    public void draw(Canvas oncanvas){
        for(int i=0;i<children.size();i++) {
            VisualElement child=children.get(i);
            oncanvas.save();
            oncanvas.translate(child.getX(),child.getY());
            oncanvas.clipRect(0,0,child.getW(),child.getH());
            children.get(i).draw(oncanvas);
            oncanvas.restore();
        }
    }

    public BaseVisualElement(float xLoc, float yLoc, float width, float height){
        super(xLoc,yLoc,width,height);
        children = new ArrayList<>();
        parents=null;
    }
}
