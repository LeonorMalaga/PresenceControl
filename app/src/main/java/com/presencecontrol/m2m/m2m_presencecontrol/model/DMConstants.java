package com.presencecontrol.m2m.m2m_presencecontrol.model;

/**
 * Created by root on 16/01/15.
 */
public class DMConstants {
    //---------------------Constans for Build DataBases-------------------------------------//
    public static final String FIRST="com.m2m.ericsson.controller.activity.FIRST";
    public static final String BUILDSETTINGS="com.m2m.ericsson.controller.activity.BUILDSETTINGS";
    public static final String BUILDPAYLOAD="com.m2m.ericsson.controller.activity.BUILDPAYLOAD";
    public static final String BUILDDEVICE="com.m2m.ericsson.controller.activity.BUILDDEVICE";
    //---------------------------------FIN---Constans for Build DataBases-------------------------------------//
    //----------------------------------Constans for DMGETPOSTIntentService-----------------------------------//
    /*Defines a custom Intent action in DMGETPOSTIntenService class to update the status*/
    public static final String INTENTSERVICE_BROADCAST_POSTHEADER=
            "com.presencecontrol.m2m.m2m_presencecontrol.extra.INTENTSERVICE_ACTION_POSTHEADER";
    /*Defines a custom Intent action in DMGETPOSTIntenService class to update the status*/
    public static final String INTENTSERVICE_BROADCAST_GET=
            "com.presencecontrol.m2m.m2m_presencecontrol.extra.INTENTSERVICE_ACTION_GET";
    /*Defines the key for the status "extra" in DMGETPOSTIntenService Intent*/
    public static final String INTENTSERVICE_EXTRA =
            "com.presencecontrol.m2m.m2m_presencecontrol.extra.INTENTSERVICE_EXTRA";

//---------------------------------FIN-Constans for DMGETPOSTIntentService-----------------------------------//
}
