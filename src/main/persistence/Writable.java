package persistence;

import org.json.JSONObject;

// CODE SOURCE: Json Serialization Demo
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
