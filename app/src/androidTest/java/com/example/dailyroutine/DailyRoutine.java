package com.example.dailyroutine;

import android.app.Instrumentation;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;

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
        //推荐使用5寸屏以上性能优秀的设备进行操作
        Thread.sleep(300);
        uiDevice.findObject(By.text("Play Store")).click();
        Thread.sleep(2000);
        uiDevice.findObject(By.desc("Search")).click();
        Thread.sleep(300);
        //搜索关键词
        String[] key ={     "lose fat in 30 days",
                            "lose weight",
                            "step counter",
                            "pedometer",
                             "abs workout",
                            "female fitness",
                            "lose belly fat",
                            "downloader",
                            "sleep sounds free",
                            "walking for weight loss",
                            "walking tracker",
                            "running to lose weight",
                            "running Tracker",
                            "leg workouts for women",
                            "fat burning",
                            "free qr scanner",
                            "free qr code reader",
                            "qr scanner",
                            "qr code reader",
                            "Own stickers maker for whatsapp"
                 };
        String desc[] = {   "Lose Weight in 30 Days",//lose
                            "Lose Weight in 30 Days",
                            "Pedometer -  Step Counter Free & Calorie Burner",//新计步器
                            "Pedometer -  Step Counter Free & Calorie Burner",
                            "Abs Workout - Burn Belly Fat with No Equipment",//abs
                            "Female Fitness - Women Workout",//women
                            "Lose Belly Fat in 30 Days - Flat Stomach",//lose belly
                            "Video Downloader",//VD
                            "Sleep Sounds Free - Relax Music, White Noise",//sleep
                            "Walking App - Walking for Weight Loss",//walk plan
                            "Walking App - Walking for Weight Loss",
                            "Running Tracker  - Running to Lose Weight",//running tracker
                            "Running Tracker  - Running to Lose Weight",
                            "Leg Workouts for Women - Slim Leg & Burn Thigh Fat",//leg
                            "Fat Burning Workouts - Lose Weight Home Workout",//lose2
                            "Free QR Scanner - Barcode Scanner, QR Code Reader",//qr scanner
                            "Free QR Scanner - Barcode Scanner, QR Code Reader",
                            "Free QR Scanner - Barcode Scanner, QR Code Reader",
                            "Free QR Scanner - Barcode Scanner, QR Code Reader",
                            "Own Sticker Maker for WhatsApp, WhatsApp Stickers"//own stickers for whatsapp


        };

        uiDevice.findObject(By.text("Search Google Play")).setText(key[0]);
        Thread.sleep(300);
        uiDevice.pressEnter();
        Thread.sleep(2000);
        uiDevice.takeScreenshot(new File("/data/data/com.example.dailyroutine/"+key[0]+".png"));
        Thread.sleep(300);
        uiDevice.findObject(By.text(desc[0]) ).click();
        Thread.sleep(500);
        uiDevice.pressBack();
        Thread.sleep(500);
        for(int i=1;i<20;i++){
        uiDevice.findObject(By.text(key[i-1])).click();
        Thread.sleep(300);
        uiDevice.findObject(By.text(key[i-1])).setText(key[i]);
        Thread.sleep(300);
        uiDevice.pressEnter();
        Thread.sleep(2000);
        //用j来记录向上滑动的次数
        int j =0;
        while(uiDevice.hasObject(By.text(desc[i])) == false){
            uiDevice.swipe(20,1780,20,80,100);
            j++;
            Thread.sleep(1000);
        }
        uiDevice.takeScreenshot(new File("/data/data/com.example.dailyroutine/"+key[i]+".png"));
        Thread.sleep(300);
        uiDevice.findObject(By.text(desc[i])).click();
        Thread.sleep(500);
        uiDevice.pressBack();
        Thread.sleep(500);
        while(j>0){
                uiDevice.swipe(20,80,20,1780,100);
                Thread.sleep(1000);
                j=j-j;
        }
        }
    }
}

