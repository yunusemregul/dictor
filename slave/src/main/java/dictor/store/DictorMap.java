package dictor.store;

import java.util.Hashtable;

public class DictorMap extends Hashtable<String, String> {
    @Override
    public String get(Object key) {
        return super.get(key);
    }

    @Override
    public String put(String key, String value) {
        return super.put(key, value);
    }
}
