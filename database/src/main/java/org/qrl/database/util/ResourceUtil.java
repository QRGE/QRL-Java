package org.qrl.database.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author qr
 * @date 2021/12/20 14:33
 */
public class ResourceUtil {

    public static Properties getResourceFile(String filename) {
        InputStream resource = ResourceUtil.class.getClassLoader().getResourceAsStream(filename);
        Properties properties = new Properties();
        try {
            properties.load(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
