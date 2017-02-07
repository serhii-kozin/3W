package www.a3w.persone;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by sergej on 07.02.17.
 */

public class PersoneImpl implements Persone {

    private String mName;
    private int mType;
    private Calendar mDate;

    public PersoneImpl(String name, int type, Calendar date) {
        mName = name;
        mType = type;
        mDate = date;
    }

    @Override
    public void setName(String name) {
        mName = name;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public void setType(int type) {
        mType = type;
    }

    @Override
    public int getType() {
        return mType;
    }

    @Override
    public void setDate(Calendar date) {
        mDate = date;
    }

    @Override
    public Calendar getDate() {
        return mDate;
    }
}
