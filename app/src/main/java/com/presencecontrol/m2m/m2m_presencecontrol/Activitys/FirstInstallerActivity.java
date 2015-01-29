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
import android.widget.EditText;
import android.widget.TextView;

import com.presencecontrol.m2m.m2m_presencecontrol.R;
import com.presencecontrol.m2m.m2m_presencecontrol.model.MySQLiteHelper;
import com.presencecontrol.m2m.m2m_presencecontrol.model.DMConstants;
import com.presencecontrol.m2m.m2m_presencecontrol.model.Project;
import com.presencecontrol.m2m.m2m_presencecontrol.model.ProjectDAO;

/**
 * Created by leonormartinezmesas on 29/01/15.
 */
public class FirstInstallerActivity extends ActionBarActivity {

private static final int RESULT_SETTINGS = 12344567;
//attributes
int firstInstaller;
private Button saveButton;
private EditText projectName;
private String projectName_string;
private EditText projectSpecification;
private String projectSpecification_string;
private TextView save;
private Project project;
private ProjectDAO projectDAO;
private int project_id;
MySQLiteHelper Database;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_first_installer);
            //showUserSettings();
            firstInstaller= PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getInt(DMConstants.FIRSTINSTALLER,0);
            if(firstInstaller==378456239){
                //Itś not the first time, look the work mode and jump to the correct activity
                // startActivity(new Intent(FirstActivity.this, SecondActivity.class));
            }else{
                saveButton=(Button)this.findViewById(R.id.first_installer_button);
                projectName=(EditText)this.findViewById(R.id.project_name_editText);
                projectSpecification=(EditText)this.findViewById(R.id.project_specification_editText);
                save=(TextView)this.findViewById(R.id.first_intaller_response_textView);

                saveButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View view){
                    projectSpecification_string=projectName.getText().toString();
                    projectName_string=projectSpecification.getText().toString();
                    Log.d("-----Project Name-----------", projectSpecification_string);
                    Log.d("-----Project Specification-----------", projectName_string);

                    project=new Project(projectName_string, projectName_string);
                    projectDAO=new ProjectDAO(getApplicationContext());
                    projectDAO.open();
                    project_id=projectDAO.create(project);
                    projectDAO.close();
                    project.set_id(project_id);
                    save.setText("Save object Project in database with id:"+project_id);
                    // startActivity(new Intent(FirstActivity.this, SecondActivity.class));
                }
            });

                PreferenceManager.getDefaultSharedPreferences(getApplicationContext())
                        .edit()
                        .putInt(DMConstants.FIRST,278456239)
                        .commit();
            }

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


}

