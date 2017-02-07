package www.a3w.persone;

import java.util.Calendar;

/**
 * Created by sergej on 07.02.17.
 */

public interface Persone {

    void setName(String name);

    String getName();

    void setType(int type);

    int getType();

    void setDate(Calendar date);

    Calendar getDate();

}
