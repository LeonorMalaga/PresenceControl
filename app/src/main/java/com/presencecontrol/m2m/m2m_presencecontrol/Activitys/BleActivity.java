package com.presencecontrol.m2m.m2m_presencecontrol.Activitys;

/**
 * Created by leonor martinez mesas on 29/01/15.
 */

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.presencecontrol.m2m.m2m_presencecontrol.R;
import com.presencecontrol.m2m.m2m_presencecontrol.model.DMConstants;

import java.util.ArrayList;

public class BleActivity extends Activity {
    //-------------------attributes-------------------------//
    private static final int RESULT_SETTINGS = 223456567;
    private BluetoothAdapter mBluetoothAdapter = null;
    private boolean mScanning = false;
    private Handler mHandler = new Handler();
    private ListAdapter mLeDeviceListAdapter;
    private static final long SCAN_TIMEOUT = 5000;

    static class ViewHolder {
        public TextView text;
    }

    // Device scan callback.
    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(final BluetoothDevice device, int rssi,
                             byte[] scanRecord) {
            Log.v("--------------DEVICE FAUND-------------------", device.getAddress().toString()+", rss1="+rssi);
            final MyBledevice mydevice=new MyBledevice(device,rssi);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    mLeDeviceListAdapter.addDevice(device);
                    mLeDeviceListAdapter.myaddDevice(mydevice);
                    mLeDeviceListAdapter.notifyDataSetChanged();
                }
            });
        }
    };


    //---------------------Principal Methods---------------//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.phone_sensor_ble);
        // Initializes Bluetooth adapter.
        final BluetoothManager BluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = BluetoothManager.getAdapter();
        mLeDeviceListAdapter = new ListAdapter();
        ListView listView = (ListView) this.findViewById(R.id.deviceList);
        listView.setAdapter(mLeDeviceListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_dm_interface, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_settings:
                Intent i = new Intent(this, SettingsActivity.class);
                startActivityForResult(i, RESULT_SETTINGS);
                break;

        }

        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SETTINGS:
                //showUserSettings();
                break;
        }
    }
//----------------------Auxyliar Metodos--------------------------//

    private void setScanState(boolean value) {
        mScanning = value;
        setProgressBarIndeterminateVisibility(value);
        ((Button) this.findViewById(R.id.scanButton)).setText(value ? "Stop"
                : "Scan");
    }
    //Set Scan botton
    public void onScan(View view) {
// check Bluetooth is available and on
        if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(
                    BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enableBtIntent);
            return;
        }
        scanLeDevice(!mScanning);
    }

    //Start or Stop the scan
    private void scanLeDevice(final boolean enable) {
        if (enable) {
// scan for SCAN_TIMEOUT
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    setScanState(false);
                    mBluetoothAdapter.stopLeScan(mLeScanCallback); }
            }, SCAN_TIMEOUT);
            setScanState(true);
            mLeDeviceListAdapter.clear();
            mLeDeviceListAdapter.notifyDataSetChanged();
// pass in the link loss service id uuid to filter out devices // that dont support it
            //UUID[] uuids = new UUID[1];
            //uuids[0] = UUID.fromString("00001803-0000-1000-8000-00805f9b34fb");
            //mBluetoothAdapter.startLeScan( uuids, mLeScanCallback);
            //We are look all devices
            mBluetoothAdapter.startLeScan( mLeScanCallback);
        } else {
            setScanState(false);
            mBluetoothAdapter.stopLeScan(mLeScanCallback);
        }
    }

    //----------------Auxyliar Class------------------------//

    // adaptor
    private class ListAdapter extends BaseAdapter {
        private ArrayList<BluetoothDevice> mLeDevices;
        private ArrayList<MyBledevice> myLeDevices;

        public ListAdapter() {
            super();
            mLeDevices = new ArrayList<BluetoothDevice>();
            myLeDevices = new ArrayList<MyBledevice>();
        }
        public void addDevice(BluetoothDevice device) {
            if (!mLeDevices.contains(device)) {
                mLeDevices.add(device);
            }
        }
        public void myaddDevice(MyBledevice device) {
            if (!myLeDevices.contains(device)) {
                myLeDevices.add(device);
            }
        }
        public MyBledevice mygetDevice(int position) {
            return myLeDevices.get(position);
        }
        public BluetoothDevice getDevice(int position) {
            return mLeDevices.get(position);
        }
        public void myclear() {
            myLeDevices.clear();
        }
        public void clear() {
            mLeDevices.clear();
        }

        @Override
        public int getCount() {
            //return mLeDevices.size();
            return myLeDevices.size();
        }
        @Override
        public Object getItem(int i) {
            // return mLeDevices.get(i);
            return myLeDevices.get(i);

        }
        @Override
        public long getItemId(int i) {
            return i;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            // General ListView optimization code.
            if (view == null) {
                view = BleActivity.this.getLayoutInflater().inflate(R.layout.list_row,null);
                viewHolder = new ViewHolder();
                viewHolder.text = (TextView) view.findViewById(R.id.textView);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            //BluetoothDevice device = mLeDevices.get(i);
            MyBledevice device = myLeDevices.get(i);
            final String deviceName = device.device.getName();
            String deviceAdrees = device.device.getAddress();
            int rssi=device.rssi;
            if (deviceAdrees != null && deviceAdrees.length() > 0){
            }else{deviceAdrees="0";}
            if (deviceName != null && deviceName.length() > 0)
                viewHolder.text.setText(deviceName+":"+deviceAdrees+"----->"+rssi);
            else
                viewHolder.text.setText("Anonimo"+deviceAdrees+"----->"+rssi);

            return view;
        }
    }

}