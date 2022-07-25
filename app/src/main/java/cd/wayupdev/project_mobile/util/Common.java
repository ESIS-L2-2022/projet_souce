package cd.wayupdev.project_mobile.util;

import android.content.Context;
import android.widget.Toast;

public class Common {
    public static void myTost(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
