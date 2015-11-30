package se.jayway.databinding;

import java.text.DateFormat;

/**
 * Created by carl on 11/30/15.
 */
public class StringUtil {

    public static String format(long millis) {
        return DateFormat.getTimeInstance().format(millis);
    }

}
