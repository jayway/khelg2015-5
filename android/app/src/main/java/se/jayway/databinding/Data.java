package se.jayway.databinding;

import java.util.ArrayList;
import java.util.List;

public class Data {

    static public List<MyModel> list;

    static {
        list = new ArrayList<>();
        list.add(new MyModel("dies Lūnae"));
        list.add(new MyModel("dies Martis"));
        list.add(new MyModel("dies Mercuriī"));
        list.add(new MyModel("dies Iovis"));
        list.add(new MyModel("dies Veneris"));
        list.add(new MyModel("dies Saturnī"));
    }

}
