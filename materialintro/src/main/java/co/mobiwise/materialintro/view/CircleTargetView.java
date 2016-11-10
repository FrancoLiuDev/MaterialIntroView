package co.mobiwise.materialintro.view;

import android.graphics.Point;
import android.support.annotation.Size;
import android.view.View;

/**
 * Created by francoliu on 10/11/2016.
 */

public interface CircleTargetView {
    public void getTargetLocationInWindow(@Size(2) int[] location);
    public void setTargetLocationInWindow(Point pos,int radius);

    public int getTargetHeight();
    public int getTargetWidth();
    public View getView();
}
