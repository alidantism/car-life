package life.car.CustomViews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by AliReza on 5/23/2018.
 */

public class MyTextView extends AppCompatTextView {

    public MyTextView(Context context) {
        super(context);
        Typeface yekan = Typeface.createFromAsset(context.getAssets()
                , "fonts/yekan.ttf") ;
        this.setTypeface(yekan);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface yekan = Typeface.createFromAsset(context.getAssets()
                , "fonts/yekan.ttf") ;
        this.setTypeface(yekan);
    }
}
