package life.car.CustomViews;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

/**
 * Created by AliReza on 5/23/2018.
 */

public class MyEditText extends AppCompatEditText {

    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public String text(){
        return getText().toString() ;
    }

}
