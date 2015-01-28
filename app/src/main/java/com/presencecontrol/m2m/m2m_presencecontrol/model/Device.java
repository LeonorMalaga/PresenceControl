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
    private int _id;
    private int projecto_id;
    private String mdate = null;//The date at which the class is generate
    private String mDeviceAddress = null;// lE1234CD
    private String mDeviceName = null;//"LUIS"
    private String latitude=null;
    private String longitude=null;
    private String mDeviceSpecification = null;//message to show
//    private List<Payload> mPayloadList = new LinkedList<Payload>();//List of measures values with his date and type(dBm) of value(-51)

    @Override
    public String toString() {
        return "Name:"+mDeviceName+" address:"+mDeviceAddress+" latitude:"+latitude+" longitude:"+longitude;
    }

    /**
     * Constructor
     */
    public Device(){}

    public Device(String mDeviceAddress, String latitude, String longitude) {
        this.mDeviceAddress = mDeviceAddress;
        this.mDeviceName="Anonymous";
        this.latitude=latitude;
        this.longitude=longitude;
        this.mdate = String.valueOf(System.currentTimeMillis());
    }
    public Device(String mDeviceAddress, String latitude, String longitude,String mDeviceName) {
        this.mDeviceAddress = mDeviceAddress;
        this.mDeviceName=mDeviceName;
        this.latitude=latitude;
        this.longitude=longitude;
        this.mdate = String.valueOf(System.currentTimeMillis());
    }
    public Device(int idprojecto, String mDeviceAddress, String latitude, String longitude) {
        this.mDeviceAddress = mDeviceAddress;
        this.mDeviceName="Anonymous";
        this.latitude=latitude;
        this.longitude=longitude;
        this.mdate = String.valueOf(System.currentTimeMillis());
    }
    public Device(int idprojecto, String mDeviceAddress, String latitude, String longitude,String mDeviceName) {
        this.mDeviceAddress = mDeviceAddress;
        this.mDeviceName=mDeviceName;
        this.latitude=latitude;
        this.longitude=longitude;
        this.mdate = String.valueOf(System.currentTimeMillis());
    }

    /**GETTER-SETTER*/
    public int getprojecto_id() {
        return projecto_id;
    }

    public void setprojecto_id(int projecto_id) {
        this.projecto_id = projecto_id;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
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

    public Device(String mDeviceAddress, String latitude, String longitude,String mDeviceName, String mDeviceSpecification) {
        this.mDeviceAddress = mDeviceAddress;
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
     *  I build all getter and setter, except set mDeviceAddress,because,it is the identifier
     * public void setmDeviceAddress(String mDeviceAddress) {
     *this.mDeviceAddress = mDeviceAddress;
     *}
     */
    public String getDate() {
        return mdate;
    }

    public void setDate(String mdate) {
        this.mdate = mdate;
    }
    public String getDeviceId() {
        return mDeviceAddress;
    }

    public String getDeviceSpecification() {
        return mDeviceSpecification;
    }

    public void setDeviceSpecification(String mDeviceSpecification) {
        this.mDeviceSpecification = mDeviceSpecification;
    }

    public String getmDeviceName() {
        return mDeviceName;
    }

    public void setmDeviceName(String mDeviceName) {
        this.mDeviceName = mDeviceName;
    }

    public String getmDeviceAddress() {
        return mDeviceAddress;
    }

    public void setmDeviceAddress(String mDeviceAddress) {
        this.mDeviceAddress = mDeviceAddress;
    }
//
//    public List<Payload> getPayloadList() {
//        return mPayloadList;
//    }
//
//    public void setPayloadList(List<Payload> mPayloadList) {
//        this.mPayloadList = mPayloadList;
//    }
    /*
*OTHER
*/
//    public void addPayload(Payload payload) {
//        mPayloadList.add(payload);
//    }
//    public Payload getPayload(int i) {
//        return mPayloadList.get(i);
//    }
//    public int getPayloadListSize(){
//        return mPayloadList.size();
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device)) return false;

        Device device = (Device) o;

        if (!mDeviceAddress.equals(device.mDeviceAddress)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return mDeviceAddress.hashCode();
    }
}
