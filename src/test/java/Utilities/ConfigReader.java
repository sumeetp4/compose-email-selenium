package Utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {

    public static Properties loadConfigProperies() {
        try {
            Properties prop = new Properties();
            Path filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "config.properties");
            InputStream input = new FileInputStream(filePath.toAbsolutePath().toString());
            prop.load(input);
            input.close();
            return prop;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
