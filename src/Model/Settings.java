package Model;

import java.io.*;
import java.util.Properties;

public class Settings {
    private static final String FILENAME = "settings.properties";
    private Properties props;

    public Settings(){
        props = new Properties();
        File file = new File(FILENAME);
        if(!file.exists()){
            try {
                file.createNewFile();
                initSettings();
            }catch (IOException e){
                System.out.println("IO exc : error create settings file");
            }
            return;
        }

        try(InputStream input = new FileInputStream(file)) {
            props.load(input);
        }catch (IOException e){
            System.out.println("Io exc : error while loading settings");
        }
    }

    private void initSettings(){
        props.setProperty("directory", "");
        props.setProperty("theme", "light");
    }

    public String getProperty(String key){
        return props.getProperty(key);
    }

    public void setProperty(String key, String value){
        try(OutputStream output = new FileOutputStream(FILENAME)){
            props.setProperty(key,value);
            props.store(output, null);
        }catch (IOException e){
            System.out.println("IO exc : error while saving settings");
        }
    }
}
