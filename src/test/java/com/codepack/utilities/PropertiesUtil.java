package com.codepack.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



/**
 * A thread-safe Singleton properties loader util to handle standard environment properties files.
 * @author Team Awesome
 */
public class PropertiesUtil {


    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            Properties props = System.getProperties();
            String environment = "";

            if (props.containsKey("environment.name")) {
                environment = props.getProperty("environment.name");
            } else {
// Uncomment the one that you want
//        environment = "localhost";
//        environment = "devb";
//        environment = "int";
//        environment = "qa";
//        environment = "uat";
//        environment = "staging";
                environment = "test";
            }

            InputStream in =
                    Thread.currentThread().getContextClassLoader().getResourceAsStream("envs/" + environment + ".properties");
            PROPERTIES.load(in);
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBaseUrl(){
        return PROPERTIES.getProperty("BaseUrl");
    }


    public String getBrowser(){
        return PROPERTIES.getProperty("BrowserName");
    }


    private PropertiesUtil() {
    }

   }

