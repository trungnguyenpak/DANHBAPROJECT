package com.trungnguyeen.danhba.model;

/**
 * Created by trungnguyeen on 9/15/17.
 */

public class Contact {
    private boolean isMale;
    private String mName;
    private String mPhoneNumber;

    public Contact(boolean isMale, String mName, String mPhoneNumber) {
        this.isMale = isMale;
        this.mName = mName;
        this.mPhoneNumber = mPhoneNumber;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }
}
