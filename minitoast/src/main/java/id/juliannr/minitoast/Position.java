package id.juliannr.minitoast;

import android.view.Gravity;

/**
 * Created by juliannr on 03/04/18.
 */

public enum Position {
    TOP, BOTTOM;

    public int getPosition(Position position){
        switch (position){
            case TOP:
                return Gravity.TOP;
            case BOTTOM:
                return Gravity.BOTTOM;
        }
        return Gravity.BOTTOM;
    }
}
