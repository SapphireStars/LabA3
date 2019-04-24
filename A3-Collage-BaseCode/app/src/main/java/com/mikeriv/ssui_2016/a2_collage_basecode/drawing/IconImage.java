package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class IconImage extends BaseVisualElement {
    private Bitmap image;
    public IconImage(float x,float y,Bitmap image){
        super(x,y,image.getWidth(),image.getHeight());
        Drawable drawable = new BitmapDrawable(image);
        this.image = Bitmap.createScaledBitmap(image,
                drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(),
                false);
    }

    @Override
    public void draw(Canvas oncanvas){
        Paint paint = new Paint();
        setW(image.getWidth());
        setH(image.getHeight());
        oncanvas.drawBitmap(image,0,0,paint);// 0 or getX()?
        for(int i=0;i<children.size();i++) {
            VisualElement child=children.get(i);
            oncanvas.save();
            oncanvas.translate(child.getX(),child.getY());
            oncanvas.clipRect(0,0,child.getW(),child.getH());
            children.get(i).draw(oncanvas);
            oncanvas.restore();
        }
    }

    @Override
    public boolean sizeIsIntrinsic(){
        return true;
    }

}
