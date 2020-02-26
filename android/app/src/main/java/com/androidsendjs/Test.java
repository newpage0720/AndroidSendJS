package com.androidsendjs;  
 
import android.provider.Settings;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
 
public class Test {
    //定义上下文对象 
    public static ReactContext myContext;
    private ReactContext reactContext;
    private String eventName;
    private WritableMap params;

    //定义发送事件的函数
    public void sendEvent(ReactContext reactContext, String eventName, @Nullable WritableMap params) {
        this.reactContext = reactContext;
        this.eventName = eventName;
        this.params = params;
        //System.out.println("reactContext="+reactContext);

        reactContext
            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
            .emit(eventName,params);
    }
 
    public void fun() {
    //在该方法中开启线程，并且延迟3秒，然后向JavaScript端发送事件。
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //发送事件,事件名为EventName
                WritableMap et= Arguments.createMap();
                sendEvent(myContext,"EventName",et);
            }
        }).start();  
    }
}