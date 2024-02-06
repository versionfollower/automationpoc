
package com.appium.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.net.URL;

import com.appium.utils.TestUtils;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public AppiumDriver getDriver(){
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2){
        driver.set(driver2);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;
        GlobalParams params = new GlobalParams();
        PropertyManager props = new PropertyManager();
        System.out.println("pasasape");
        if(driver == null){
            try{
                utils.log().info("initializing Appium driver");
                System.out.println("getPlatformName   " + params.getPlatformName());
                switch(params.getPlatformName()){
                    case "Android":
                        System.out.println("paso android");
                        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), new CapabilitiesManager().getCaps());
                        System.out.println("test111111");
                        break;
                    case "iOS":
                        
                        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), new CapabilitiesManager().getCaps());
                        System.out.println("test2222");
                        break;
                }
                if(driver == null){
                    throw new Exception("driver is null. ABORT!!!");
                }
                utils.log().info("Driver is initialized");
                this.driver.set(driver);
            } catch (IOException exception) {
                exception.printStackTrace();
                utils.log().fatal("Driver initialization failure. ABORT !!!!" + exception.toString());
                throw exception;
            }
        }

    }

}
