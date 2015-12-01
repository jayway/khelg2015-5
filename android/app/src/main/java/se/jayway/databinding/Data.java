package se.jayway.databinding;

import java.util.HashMap;

public class Data {

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
    public String index = "0";

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
        setIndex(time);
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(long time) {
        this.index = Integer.toString((int) (time / 1000 % 8));
    }
}
