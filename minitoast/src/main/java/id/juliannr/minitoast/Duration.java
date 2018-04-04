package id.juliannr.minitoast;

import android.widget.Toast;

/**
 * Created by juliannr on 03/04/18.
 */

public enum Duration {
    LONG, SHORT;

    public int getDuration(Duration duration){
        switch (duration){
            case SHORT:
                return Toast.LENGTH_SHORT;
            case LONG:
                return Toast.LENGTH_LONG;
        }
        return Toast.LENGTH_SHORT;
    }
}
