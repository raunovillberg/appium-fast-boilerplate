package core.utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class CapabilitiesHelper {
    public static HashMap<String, String> readAndMakeCapabilities(String fileName) throws IOException {
        String caps = new FileReader().readFile(fileName);
        HashMap<String, String> map = convertCapsToMap(caps);

        updateAbsolutePath(map);
        return map;
    }

    private static HashMap convertCapsToMap(String caps) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(caps, HashMap.class);
    }

    private static void updateAbsolutePath(HashMap<String, String> map) {
        String path = map.get("app");
        File appPath = new File(path);
        map.put("app", appPath.getAbsolutePath());
    }
}
