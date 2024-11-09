package core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

import constants.Target;

public class PropertiesReader {
    final Properties props = new Properties();

    public PropertiesReader() {
        try {
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Target getTarget() {
        String target = System.getProperty("target");
        if (target == null)
            target = "ANDROID";
        if (Objects.equals(target, "NONE")) {
            return Target.valueOf(props.getProperty("target"));
        } else {
            return Target.valueOf(target);
        }
    }

    public void load() throws IOException {
        String propertyFileName = "env.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        try (InputStream stream = loader.getResourceAsStream(propertyFileName)) {
            props.load(stream);
        }
    }
}
