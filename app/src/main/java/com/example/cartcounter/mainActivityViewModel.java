package com.example.cartcounter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class mainActivityViewModel extends ViewModel {

    private static MutableLiveData<Integer> mCount;

    public static MutableLiveData<Integer> getCount()
    {
        if(mCount==null)
        {
            mCount=new MutableLiveData<>();
            mCount.setValue(0);
        }
        return mCount;
    }

    public static void setCount()
    {
        if(mCount.getValue()!=null)
        {
            mCount.setValue(mCount.getValue()+1);
        }
    }

}
