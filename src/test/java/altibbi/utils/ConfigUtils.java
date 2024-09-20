package altibbi.utils;

import java.util.Properties;

public class ConfigUtils {
    private  Properties properties ;
    private static ConfigUtils configUtils;
    private ConfigUtils() {
        String env = System.getProperty("env", "production").toUpperCase();
        switch(env) {
            case "PRODUCTION":
                properties = PropertiesUtils.loadProperties("src/test/java/altibbi/config/production.properties");
                break;
            default:
                throw new RuntimeException("Environment is not supported");
        }

    }

    public static ConfigUtils getInstance() {
        if(configUtils==null){
            configUtils =new ConfigUtils();
        }
        return configUtils;
    }

    public  String getBaseUrl() {
        String prop= properties.getProperty("baseUrl");

        if (prop != null)return prop;
        throw new RuntimeException("cant find the baser url in the property file") ;


    }

    public  String getBaseUrlForgetPass() {
        String prop= properties.getProperty("baseUrlForgetPass");

        if (prop != null)return prop;
        throw new RuntimeException("cant find the baser url in the property file") ;


    }


    public  String getbaseUrlRegistration() {
        String prop= properties.getProperty("baseUrlRegistration");

        if (prop != null)return prop;
        throw new RuntimeException("cant find the baser url in the property file") ;


    }
    public String getPhoneNumber() {
        String prop = properties.getProperty("phoneNumber");

        if (prop != null) return prop;
        throw new RuntimeException("cant find the email in the property file");

    }
    public  String getEmail() {
        String prop= properties.getProperty("email");

        if (prop != null)return prop;
        throw new RuntimeException("cant find the email in the property file") ;

    }
    public  String getPassword() {
        String prop= properties.getProperty("password");

        if (prop != null)return prop;
        throw new RuntimeException("cant find the password in the property file") ;


    }


}
