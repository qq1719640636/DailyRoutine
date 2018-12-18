package com.example.dailyroutine;

import android.app.Instrumentation;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(AndroidJUnit4.class)
public class DailyRoutine {
    public Instrumentation instrumentation;
    public UiDevice uiDevice;

    @Before
    public void setUp(){
        instrumentation = InstrumentationRegistry.getInstrumentation();
        uiDevice = UiDevice.getInstance(instrumentation);
    }
    @Test
    public void Test() throws RemoteException, InterruptedException {
        uiDevice.pressHome();
        //运行程序前，请将Play Store放在第一屏即Home页，并清空后台
        //uiDevice.pressRecentApps();
        //Thread.sleep(1000);
        //uiDevice.findObject(By.desc("Close all")).click();
        Thread.sleep(1000);
        uiDevice.findObject(By.text("Play Store")).click();
        Thread.sleep(2000);
        uiDevice.findObject(By.desc("Search")).click();
        Thread.sleep(1000);
        String[] key ={     "lose weight",
                            "step counter",
                            "pedometer",
                             "abs workout",
                            "female fitness",
                            "lose belly fat",
                            "downloader ",
                            "sleep sounds free",
                            "walking for weight loss",
                            "walking tracker",
                            "running to lose weight",
                            "running Tracker",
                            "leg workouts for women",
                            "fat burning",
                            "free qr scanner",
                            "free qr code reader"};

        uiDevice.findObject(By.text("Search Google Play")).setText(key[0]);
        Thread.sleep(1000);
        uiDevice.pressEnter();
        Thread.sleep(3000);
        uiDevice.takeScreenshot(new File("/data/data/com.example.dailyroutine/"+key[0]+".png"));
        Thread.sleep(1000);
        for(int i=1;i<16;i++){
        uiDevice.findObject(By.text(key[i-1])).click();
        Thread.sleep(1000);
        uiDevice.findObject(By.text(key[i-1])).setText(key[i]);
        Thread.sleep(1000);
        uiDevice.pressEnter();
        Thread.sleep(3000);
        uiDevice.takeScreenshot(new File("/data/data/com.example.dailyroutine/"+key[i]+".png"));
        Thread.sleep(1000);
        }
    }
}

