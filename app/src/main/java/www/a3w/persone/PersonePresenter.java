package www.a3w.persone;

import java.util.Calendar;
import java.util.List;

/**
 * Created by sergej on 07.02.17.
 */

public interface PersonePresenter {
    void checkPersone(String name, int type, Calendar calendar);

    List<Persone> getPersones();
}
