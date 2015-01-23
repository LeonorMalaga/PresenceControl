package com.presencecontrol.m2m.m2m_presencecontrol.Activitys;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.presencecontrol.m2m.m2m_presencecontrol.R;
import com.presencecontrol.m2m.m2m_presencecontrol.model.AuxTableScreme;
import com.presencecontrol.m2m.m2m_presencecontrol.model.DMConstants;
import com.presencecontrol.m2m.m2m_presencecontrol.model.DataBaseManager;
import com.presencecontrol.m2m.m2m_presencecontrol.model.Device;
import com.presencecontrol.m2m.m2m_presencecontrol.model.Payload;
import com.presencecontrol.m2m.m2m_presencecontrol.model.SettingsModel;

import java.util.ArrayList;

/**
 * Created by root on 21/01/15.
 */
public class FirstActivity extends ActionBarActivity {
    private static final int RESULT_SETTINGS = 1;
    //attributes
    int first;
    private Button startDefaultButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //showUserSettings();
        first= PreferenceManager.getDefaultSharedPreferences(FirstActivity.this).getInt(DMConstants.FIRST,0);
        /*if(first==178456239){
            //Itś not the first time, look the work mode and jump to the correct activity


        }else{
            startDefaultButton=(Button)this.findViewById(R.id.startDefault_button);
            startDefaultButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View view){
                    // startActivity(new Intent(FirstActivity.this, SecondActivity.class));
                }
            });

        }*/

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

 //----------------------------------------------------------------Methods-------------------------//

   /* private void showUserSettings() {

        SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this);

        StringBuilder builder = new StringBuilder();

        builder.append("\n Username: "
                + sharedPrefs.getString("prefUsername", "NULL"));

        builder.append("\n Send report:"
                + sharedPrefs.getBoolean("prefSendReport", false));

        builder.append("\n Sync Frequency: "
                + sharedPrefs.getString("prefSyncFrequency", "NULL"));

       // TextView settingsTextView = (TextView) findViewById(R.id.textUserSettings);

        //settingsTextView.setText(builder.toString());
    }*/

}
