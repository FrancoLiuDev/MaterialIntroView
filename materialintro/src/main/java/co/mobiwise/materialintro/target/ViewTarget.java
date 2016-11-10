package co.mobiwise.materialintro.target;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

import co.mobiwise.materialintro.view.CircleTargetView;
import co.mobiwise.materialintro.view.ImagePosView;

/**
 * Created by mertsimsek on 25/01/16.
 */
public class ViewTarget implements Target{

    private ImagePosView view;

    CircleTargetView targetView;

    public ViewTarget(ImagePosView view ) {
        this.view = view;
        targetView= view;
    }

    @Override
    public Point getPoint() {

        int[] location = new int[2];
        targetView.getTargetLocationInWindow(location);
        //return new Point(location[0] + (targetView.getTargetWidth() / 2), location[1] + (targetView.getTargetHeight() / 2));
        return new Point(location[0] + 0, location[1] + 0);
    }

    @Override
    public void setPoint(Point pos, int radius) {
        targetView.setTargetLocationInWindow(pos,radius);
    }



    @Override
    public Rect getRect() {
        int[] location = new int[2];
        targetView.getTargetLocationInWindow(location);
        return new Rect(
                location[0],
                location[1],
                location[0] + targetView.getTargetWidth(),
                location[1] + targetView.getTargetHeight()
        );
    }

    @Override
    public View getView() {
        return view;
    }

}
