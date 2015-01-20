package com.presencecontrol.m2m.m2m_presencecontrol.Activitys;

/**
 * Created by root on 20/01/15.
 */
//Android import
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.presencecontrol.m2m.m2m_presencecontrol.R;

//Java import
import java.util.ArrayList;
//Internal import
import com.presencecontrol.m2m.m2m_presencecontrol.model.Device;
import com.presencecontrol.m2m.m2m_presencecontrol.model.SettingsModel;
import com.presencecontrol.m2m.m2m_presencecontrol.model.Payload;
import com.presencecontrol.m2m.m2m_presencecontrol.model.AuxTableScreme;
import com.presencecontrol.m2m.m2m_presencecontrol.model.DataBaseManager;
public class FirstActivity extends Activity {
    //-------------------attributes-------------------------//
    private int build=0;
    private boolean mbuil = false;
    private Button buildButton=null;
    private Button ProyectDataButton=null;
    public static final String BUILD="com.m2m.ericsson.controller.activity.BUILD";
    public static final int SETTINGS_REQUEST=1;
    public DataBaseManager mSQLite=null;

    //---------------------Principal Methods---------------//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_first);
        ShowButton(true);
        build= PreferenceManager.getDefaultSharedPreferences(FirstActivity.this).getInt(BUILD,0);

        Log.d("------------------------------------------------------------------------------------------------","--------------------");
        Log.d("--------------------Default-----------------------",String.valueOf(build));
        Log.d("------------------------------------------------------------------------------------------------","--------------------");
        if(build!=178456239){

            buildButton=(Button)this.findViewById(R.id.Build_button);
            buildButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View view){
                    Log.d("-------------------boton puldado---","----------------");
                    setbuild(true);
                /*
                 *Building database
                */
                    mSQLite=new DataBaseManager(FirstActivity.this);
                    ArrayList<AuxTableScreme> auxArray=new ArrayList<AuxTableScreme>();
                    /**
                     * Build Tables
                     */
                    mSQLite.makeTable(Payload.class);
                    String aux1= mSQLite.showTables(Payload.class);
                    String result=aux1;

                    PreferenceManager.getDefaultSharedPreferences(FirstActivity.this)
                            .edit()
                            .putInt(BUILD,178456239)
                            .commit();
                    setresult(result);
                    ShowButton(false);
                }
            });


        }/*else{
            // If not the first time that you ' access to the application , the program options are shown
            startActivity(new Intent(FirstActivity.this, SecondActivity.class));
        }*/

        // Initializes Bluetooth adapter.
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dm_interface, menu);
        return true;
    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //menu_settings no esiste
        if (id == R.id.action_settings) {
            Intent settingsIntent=new Intent(FirstActivity.this, SettingsActivity.class);
            settingsIntent.putExtra(SettingsActivity.LANGUAGE, "en");
            startActivityForResult(settingsIntent,SETTINGS_REQUEST);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    /**
     * Called when an activity you launched exits, giving you the requestCode
     * you started it with, the resultCode it returned, and any additional
     * data from it.  The <var>resultCode</var> will be
     * {@link #RESULT_CANCELED} if the activity explicitly returned that,
     * didn't return any result, or crashed during its operation.
     * <p/>
     * <p>You will receive this call immediately before onResume() when your
     * activity is re-starting.
     *
     * @param requestCode The integer request code originally supplied to
     *                    startActivityForResult(), allowing you to identify who this
     *                    result came from.
     * @param resultCode  The integer result code returned by the child activity
     *                    through its setResult().
     * @param data        An Intent, which can return result data to the caller
     *                    (various data can be attached to Intent "extras").
     * @see #startActivityForResult
     * @see #createPendingResult
     * @see #setResult(int)
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==SETTINGS_REQUEST && resultCode==Activity.RESULT_OK){
//            ImageView.ScaleType scaleType=(ImageView.ScaleType)data.getSerializableExtra(SettingsActivity.EXTRA_WINE_IMAGE_SCALE_TYPE);
//            mWineImage.setScaleType(scaleType);
        }
    }
    //----------------------Auxyliar Metodos--------------------------//

    //Set build botton
    private void setbuild(boolean value) {
        mbuil = value;
        setProgressBarIndeterminateVisibility(value);
        ((Button) this.findViewById(R.id.Build_button)).setText(value ? "building"
                : "Build");
    }
    //set result
    private void setresult(String msg) {
        ((TextView) this.findViewById(R.id.build_result_textView)).setText(msg);
    }
    //if show buil button then conceal ProyectData button
    //true show buil button
    //false show ProyectData button
    private void ShowButton(boolean value) {
        if(value){
            ((Button) this.findViewById(R.id.Build_button)).setVisibility(View.VISIBLE);
            ((Button) this.findViewById(R.id.ProyectData_button)).setVisibility(View.GONE);
        }else{
            setProgressBarIndeterminateVisibility(value);
            ((Button) this.findViewById(R.id.Build_button)).setVisibility(View.GONE);
            ((Button) this.findViewById(R.id.ProyectData_button)).setVisibility(View.VISIBLE);
            ((TextView) this.findViewById(R.id.first_textView)).setText("press the botton to start");
            /*//Configuramos la accion del Boton
            ProyectDataButton=(Button)this.findViewById(R.id.ProyectData_button);
            ProyectDataButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View view){
                    // We already create the database  , now we going to fill the project data
                    startActivity(new Intent(FirstActivity.this, BussinesDataActivity.class));
                }
            });//Fil al pulsar*/
        }
    }
}

