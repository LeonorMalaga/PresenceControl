package com.presencecontrol.m2m.m2m_presencecontrol.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by leonorMartinezMesas on 20/01/15.
 * This class represent a BLE device
 * identificate by the bluettoth adress(with ejem:<Adress>:AE1234CD,<device_name>:"LUIS", <RSSI>:"-51dBm")
 */
public class Device implements Serializable {
    private String mdate = null;//The date at which the class is generate
    private String mDeviceId = null;// lE1234CD
    private String mDeviceName = null;//"LUIS"
    private String latitude=null;
    private String longitude=null;
    private String mDeviceSpecification = null;//message to show
    private List<Payload> mPayloadList = new LinkedList<Payload>();//List of measures values with his date and type(dBm) of value(-51)
    /**
     * Constructor
     */
    public Device(String mDeviceId, String latitude, String longitude) {
        this.mDeviceId = mDeviceId;
        this.mDeviceName="Anonymous";
        this.latitude=latitude;
        this.longitude=longitude;
        this.mdate = String.valueOf(System.currentTimeMillis());
    }
    public Device(String mDeviceId, String latitude, String longitude,String mDeviceName) {
        this.mDeviceId = mDeviceId;
        this.mDeviceName=mDeviceName;
        this.latitude=latitude;
        this.longitude=longitude;
        this.mdate = String.valueOf(System.currentTimeMillis());
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Device(String mDeviceId, String latitude, String longitude,String mDeviceName, String mDeviceSpecification) {
        this.mDeviceId = mDeviceId;
        this.mDeviceName=mDeviceName;
        this.latitude=latitude;
        this.longitude=longitude;
        this.mDeviceSpecification = mDeviceSpecification;
        this.mdate = String.valueOf(System.currentTimeMillis());
    }
    /**
     * Metod
     * /
     /**GETTER-SETTER
     *  I build all getter and setter, except set mDeviceId,because,it is the identifier
     * public void setmDeviceId(String mDeviceId) {
     *this.mDeviceId = mDeviceId;
     *}
     */
    public String getDate() {
        return mdate;
    }

    public void setDate(String mdate) {
        this.mdate = mdate;
    }
    public String getDeviceId() {
        return mDeviceId;
    }

    public String getDeviceSpecification() {
        return mDeviceSpecification;
    }

    public void setDeviceSpecification(String mDeviceSpecification) {
        this.mDeviceSpecification = mDeviceSpecification;
    }

    public List<Payload> getPayloadList() {
        return mPayloadList;
    }

    public void setPayloadList(List<Payload> mPayloadList) {
        this.mPayloadList = mPayloadList;
    }
    /*
*OTHER
*/
    public void addPayload(Payload payload) {
        mPayloadList.add(payload);
    }
    public Payload getPayload(int i) {
        return mPayloadList.get(i);
    }
    public int getPayloadListSize(){
        return mPayloadList.size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device)) return false;

        Device device = (Device) o;

        if (!mDeviceId.equals(device.mDeviceId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return mDeviceId.hashCode();
    }
}
