package se.jayway.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.HashMap;

public class Data extends BaseObservable {

    static public HashMap<String, String> map;

    static {
        map = new HashMap<String, String>();
        map.put("0", "dies Sōlis");
        map.put("1", "dies Lūnae");
        map.put("2", "dies Martis");
        map.put("3", "dies Mercuriī");
        map.put("4", "dies Iovis");
        map.put("5", "dies Veneris");
        map.put("6", "dies Saturnī");
    }

    public long time = 0;
    public String shortTime = "0";

    @Bindable
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
        setShortTime(time);
        notifyPropertyChanged(se.jayway.databinding.BR.time);
    }

    @Bindable
    public String getShortTime() {
        return shortTime;
    }

    public void setShortTime(long time) {
        this.shortTime = Integer.toString((int) (time / 1000 % 8));
        notifyPropertyChanged(se.jayway.databinding.BR.shortTime);
    }
}
