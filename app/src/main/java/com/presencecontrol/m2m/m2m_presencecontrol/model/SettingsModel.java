package com.presencecontrol.m2m.m2m_presencecontrol.model;

import android.content.Context;
import android.preference.PreferenceManager;
/**
 *Created by LeonorMartinezMesas@gmail.com on 04/01/2015.
 * class to save the settings configurations
 * The database Structure, has to be bouilding que fest time that the app is used
 */
public class SettingsModel{
    //atributes
    public enum SaveMode{SERVER,LOCAL,BOTH};
    public enum AppMode{INSTALLER, USER};
    private AppMode appMode;
    private SaveMode saveMode;
    private String getUrl;
    private String postheaderUrl;
    private String mdate;

    public SettingsModel(Context context) {
        this.appMode =AppMode.USER;
        this.saveMode =SaveMode.LOCAL;
        this.getUrl="http://192.168.1.103:8080/get/";
        this.postheaderUrl="http://192.168.1.103:8080/post/";
        this.mdate =String.valueOf(System.currentTimeMillis());

    }

    public SettingsModel(Context context,SaveMode saveMode,AppMode appMode,String getUrl, String postheaderUrl) {
        this.appMode =appMode;
        this.saveMode = saveMode;
        this.getUrl = getUrl;
        this.postheaderUrl = postheaderUrl;
        this.mdate =String.valueOf(System.currentTimeMillis());
    }

    public AppMode getAppMode() {
        return appMode;
    }

    public void setAppMode(AppMode appMode) {
        this.appMode = appMode;
    }

    @Override
    public String toString() {

        return "Settings:\nSAVE MODE: "+saveMode+"\nGET URL: "+getUrl+"\nPOST HEADER URL: "+postheaderUrl+"|\n";
    }
    /*There are three save Mode: In a remote SERVER, in the phone LOCAL or in BOTH*/
    public SaveMode getSaveMode() {
        return saveMode;
    }
   /*There are three save Mode: In a remote SERVER, in the phone LOCAL or in BOTH*/
    public void setSaveMode(SaveMode saveMode) {
        this.saveMode = saveMode;
    }
   /* a getUrl example is: "http://192.168.1.103:8080/get/"
    * the app obtains information about a device,with  sending a get petition to: getUrl/device.
    *The app obtains a response like :[{"id":"device", "params":{"key":"value"}}]*/
    public String getGetUrl() {
        return getUrl;
    }
    /* a getUrl example is: "http://192.168.1.103:8080/get/"
     * the app obtains information about a device,with  sending a get petition to: getUrl/device.
     *The app obtains a response like :[{"id":"device", "params":{"key":"value"}}]*/
    public void setGetUrl(String getUrl) {
        this.getUrl = getUrl;
    }
/** a postheaderUrl example is:"http://192.168.1.103:8080/post/"
 *the app send information about a device,with a post where the information go in the header,not in the body
 *if the device is not save before, it will be save
  *The post petition sending will be:postheaderUrl/device?key=value */
   public String getPostheaderUrl() {
        return postheaderUrl;
    }
  /** a postheaderUrl example is:"http://192.168.1.103:8080/post/"
  *the app send information about a device,with a post where the information go in the header,not in the body
  *if the device is not save before, it will be save
  *The post petition sending will be:postheaderUrl/device?key=value*/
   public void setPostheaderUrl(String portheaderUrl) {
        this.postheaderUrl = portheaderUrl;
    }
}

