package co.mobiwise.materialintro.view;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.Size;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import co.mobiwise.materialintro.view.CircleTargetView;

/**
 * Created by francoliu on 10/11/2016.
 */

public class ImagePosView extends ImageView implements CircleTargetView {


    Point targetPos=new Point(100,100);


    public ImagePosView(Context context, AttributeSet attrs) {
        super(context,attrs);



    }
    public ImagePosView(Context context) {
        super(context);
    }

    @Override
    public void getTargetLocationInWindow(@Size(2) int[] location) {

        int[] locationPos={0,0};


        this.getLocationInWindow(locationPos);

        location[0]=locationPos[0]+targetPos.x;
        location[1]=locationPos[1]+targetPos.y;
    }

    @Override
    public void setTargetLocationInWindow(Point pos, int radius) {

        int[] locationPos = {0, 0};

        this.getLocationInWindow(locationPos);

        targetPos.x = pos.x - locationPos[0];
        targetPos.y = pos.y - locationPos[1];

        if ((targetPos.x+radius)> (this.getWidth()))
        {
            targetPos.x = this.getWidth()-radius;
        }

        if ((targetPos.x-radius)< (0))
        {
            targetPos.x = 0+radius;
        }

        if ((targetPos.y+radius)> (this.getHeight()))
        {
            targetPos.y = this.getHeight()-radius;
        }

        if ((targetPos.y-radius)< (0))
        {
            targetPos.y= 0 +radius;
        }


    }

    @Override
    public int getTargetHeight() {
        return getHeight();
    }

    @Override
    public int getTargetWidth() {
        return getWidth();
    }


    @Override
    public View getView() {
        return this;
    }
}
