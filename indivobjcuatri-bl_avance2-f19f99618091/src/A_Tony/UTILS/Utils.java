package bl_avance2.src.A_Tony.UTILS;

import java.io.FileInputStream;
import java.util.Properties;

public class Utils {
    public static String[] getProperties() throws Exception {
        String[] properties = new String[7];
        Properties p = new Properties();
        String path = "src/bl_avance2/src/A_Tony/bd.properties";

        try {
            p.load(new FileInputStream(path));
            properties[0] = p.getProperty("driver");
            properties[1] = p.getProperty("server");
            properties[2] = p.getProperty("port");
            properties[3] = p.getProperty("database");
            properties[4] = p.getProperty("others");
            properties[5] = p.getProperty("user");
            properties[6] = p.getProperty("password");
            return properties;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
