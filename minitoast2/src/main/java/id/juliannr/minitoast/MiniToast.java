package id.juliannr.minitoast;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by juliannr on 03/04/18.
 */

public class MiniToast extends LinearLayout {
    private static MiniToast    instance;
    private        TextView     text;
    private        LinearLayout rootLayout;
    private        View         layout;
    private        Type         type;
    private        int          duration;
    private        Toast        toast;
    private        int          position;
    private        boolean      typeChoosed = false;

    private MiniToast(Context context) {
        super(context);
        text = findViewById(R.id.toast);
        rootLayout = findViewById(R.id.root_layout);
        duration = Toast.LENGTH_SHORT;
        position = Gravity.BOTTOM;
    }

    public static MiniToast with(Context context){
        instance = new MiniToast(context);
        return instance;
    }

    public MiniToast text(String text){
        instance.text.setText(text);
        return instance;
    }

    public MiniToast textColor(@ColorRes int color){
        instance.text.setTextColor(getResources().getColor(color));
        return instance;
    }

    public MiniToast type(Type type){
        int color = type.getType(type);
        instance.text.setBackgroundColor(getResources().getColor(color));
        typeChoosed = true;
        return instance;
    }

    //custom color will not affect if type choosed
    public MiniToast customColor(@ColorRes int color){
        if(!typeChoosed){
            instance.text.setBackgroundColor(getResources().getColor(color));
        }
        return instance;
    }

    public MiniToast duration(Duration duration){
        instance.duration = duration.getDuration(duration);
        return instance;
    }

    public MiniToast position(Position position){
        instance.position = position.getPosition(position);
        return instance;
    }

    private void init(){
        instance.layout = inflate(getContext(), R.layout.mini_toast_layout, (ViewGroup)
                instance.rootLayout);
        instance.toast =  new Toast(getContext().getApplicationContext());
        instance.toast.setGravity(Gravity.FILL_HORIZONTAL | instance.position, 0, 0);
        instance.toast.setDuration(instance.duration);
        instance.toast.setView(instance.layout);
    }

    public void show(){
        init();
        instance.toast.show();
    }
}
