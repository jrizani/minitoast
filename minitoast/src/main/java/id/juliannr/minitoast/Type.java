package id.juliannr.minitoast;

/**
 * Created by juliannr on 03/04/18.
 */

public enum Type {
    SUCCESS, ALERT, ERROR, INFO;

    public int getType(Type type){
        switch (type){
            case INFO:
                return R.color.info;
            case ALERT:
                return R.color.alert;
            case ERROR:
                return R.color.error;
            case SUCCESS:
                return R.color.success;
        }
        return R.color.success;
    }
}
