package com.presencecontrol.m2m.m2m_presencecontrol.model;

import java.io.Serializable;

/**
 * Created by M2M_Ericcson on 24/10/2014.
 * This class represent resource value with his date and type of value
 * Ejem for gps sensor latitude: -34,5 type Integer at date:24/10/2014
 */
public class Payload implements Serializable {
    private String mdate = null;//The date at which the value was obtained
    private String mtype = null;//type of value, example Integer, double, String, Long ..ect
    private String mvalue = null;//The value collected by the sensor
    /**
     * Constructor
     */
    public Payload( String type, String value) {
        this.mdate =String.valueOf(System.currentTimeMillis());
        this.mtype = type;
        this.mvalue = value;
    }
    public Payload(String date, String type, String value) {
        this.mdate = date;
        this.mtype = type;
        this.mvalue = value;
    }

    /**
     * Metod
     */
    /**GETTER-SETTER
     *This object can´t change after it was created, y will implement only getter
     */
    public String getDate() {
        return mdate;
    }

    public String getType() {
        return mtype;
    }

    public String getValue() {
        return mvalue;
    }
    /*
  *OTHER
  */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payload)) return false;
        Payload payload = (Payload) o;
        if (!mdate.equals(payload.mdate)) return false;
        if (!mtype.equals(payload.mtype)) return false;
        if (!mvalue.equals(payload.mvalue)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = mdate.hashCode();
        result = 31 * result + mtype.hashCode();
        result = 31 * result + mvalue.hashCode();
        return result;
    }
}