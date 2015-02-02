package com.presencecontrol.m2m.m2m_presencecontrol.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.TextView;
import android.content.BroadcastReceiver;
import android.content.Context;

import com.presencecontrol.m2m.m2m_presencecontrol.model.Constants;
import com.presencecontrol.m2m.m2m_presencecontrol.comunication.DMGETPOSTIntentService;
import com.presencecontrol.m2m.m2m_presencecontrol.R;

/**
 * Created by root on 14/01/15.
 */
public class TestDMGETPOSTIntentService extends Activity {
    //atributes
    //Intent mServiceIntent;
    TextView textOutput;
    DMGETPOSTIntentService mServiceGETPOST;
       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        textOutput=(TextView)findViewById(R.id.test_output_TextView);
             /*Create a new Intent to start the DMGETPOSTIntentService
        * pase a URI in the Intents "data" field*/
//        mServiceIntent = new Intent(this, DMGETPOSTIntentService.class);
//        mServiceIntent.putExtra(EXTRA_GETPOSTINTENSERVICE_METHOD,"GET");
//        mServiceIntent.putExtra(EXTRA_GETPOSTINTENSERVICE_URL,"url");
//               //mServiceIntent.setData(Uri.parse(url));
//        this.startService(mServiceIntent);

           // String url="http://192.168.1.103:8080/new";
           // mServiceGETPOST.startActionGET(this,url);
           String url="http://192.168.1.103:8080/post/tight-custody/?paiload=1234";
           mServiceGETPOST.startActionPOSTHEADER(this,url);
           IntentFilter mIntentFilterPostHeader = new IntentFilter(Constants.INTENTSERVICE_BROADCAST_POSTHEADER);
           ResponseReceiver mResponseReceiver=new ResponseReceiver();
           LocalBroadcastManager.getInstance(this).registerReceiver(
                   mResponseReceiver,
                   mIntentFilterPostHeader);

           // String url="http://192.168.1.103:8080/get/tight-custody";
           //mServiceGETPOST.startActionGET(this,url);
           //IntentFilter mStatusIntentFilter = new IntentFilter(DMConstants.GETINTENTSERVICE_BROADCAST);
           String text="getstatus no implementado";
           textOutput.setText( text);
    }


    //------------------------------------------------------------SUBCLASS---------------------------------------------------------------------//
    private class ResponseReceiver extends BroadcastReceiver
    {
        //atributes
        String response="NULL";
        // Called when the BroadcastReceiver gets an Intent it's registered to receive
        @Override
        public void onReceive(Context context, Intent intent) {
            response=intent.getExtras().getString(Constants.INTENTSERVICE_EXTRA);

            for (String str: intent.getExtras().keySet())
                Log.d("-----key-----: ", str);
                Log.d("---receiver----", "received response:  "+response);
            textOutput.setText(response);

        }
    }

}
