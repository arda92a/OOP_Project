package OOP_Project;

import java.util.HashMap;
import java.util.Map;

public class UserProperties {
    private Map<String, Object> properties;

    public UserProperties() {
        this.properties = new HashMap<>();
    }

    public void addProperty(String key, Object value) {
        properties.put(key, value);
    }

    public Object getProperty(String key) {
        return properties.get(key);
    }

    public void removeProperty(String key) {
        properties.remove(key);
    }

    public boolean containsProperty(String key) {
        return properties.containsKey(key);
    }
    public void updatePropertyValue(String key, Object newValue) {
        if (containsProperty(key)) {
            properties.put(key, newValue);
        }
    }

}
