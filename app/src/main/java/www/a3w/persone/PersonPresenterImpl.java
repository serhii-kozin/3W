package www.a3w.persone;

import android.content.Context;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by sergej on 07.02.17.
 */

public class PersonPresenterImpl implements PersonePresenter {

    private PersoneView mPersoneView;
    private PersoneModel mPersoneModel;
    private Context mContext;
    private List<Persone> mPersone;

    public PersonPresenterImpl(PersoneView personeView, Context context) {
        mPersone = new ArrayList<>();
        mPersoneView = personeView;
        mContext = context;
        mPersoneModel = new PersoneModelImpl(context);
    }

    @Override
    public void checkPersone(String name, int type, Calendar calendar) {
        if ("".equals(name)) {
            mPersoneView.setNameError();
        }else if(type == -1){
            mPersoneView.setTypeError();
        }else if(calendar == null){
            mPersoneView.setDateError();
        }else{
            mPersone.add(new PersoneImpl(name,type,calendar));
            mPersoneModel.addPersone(mPersone.get(mPersone.size()));
        }
    }

    @Override
    public List<Persone> getPersones() {
        mPersone = mPersoneModel.readAll();
        return mPersone;
    }

}
