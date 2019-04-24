package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

public class PileLayout extends BaseVisualElement {
    public PileLayout(float xLoc, float yLoc, float width, float height) {
        super(xLoc, yLoc, width, height);
    }
    @Override
    public void doLayout(){
        for(int i=0;i<getNumChildren();i++){
            VisualElement child = children.get(i);
            child.setX(this.getX());
            child.setY(this.getY());
        }
        for (int i = 0; i < children.size(); i++) {
            VisualElement child = children.get(i);
            child.doLayout();
        }
    }
}
