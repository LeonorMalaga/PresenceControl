package com.presencecontrol.m2m.m2m_presencecontrol.Activitys;

/**
 * Created by root on 29/01/15.
 */
import java.io.Serializable;
import android.bluetooth.BluetoothDevice;
public class MyBledevice implements Serializable {
    BluetoothDevice device=null;
    int rssi=0;
    public MyBledevice(BluetoothDevice mdevice, int mRssi){
        device=mdevice;
        rssi=mRssi;
    }
}
