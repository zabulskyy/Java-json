package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private ArrayList<JsonPair> values;

    public JsonObject(JsonPair... jsonPairs) {
        this.values = new ArrayList<>();
        boolean added = false;
        for (JsonPair pair : jsonPairs) {
            this.add(pair);
        }
    }

    @Override
    public String toJson() {
        StringBuilder value = new StringBuilder();

        if (this.values.size() == 0)
            return "{}";

        JsonPair firstPair = this.values.get(0);
        value.append(firstPair.key).append(": ").append(firstPair.value.toJson());

        for (int i = 1; i < this.values.size(); i++) {
            value.append(", ").append(this.values.get(i).key).append(": ").append(this.values.get(i).value.toJson());
        }
        return "{\n" + String.valueOf(value) + "}";
    }

    public void add(JsonPair jsonPair) {
        boolean added = false;

        for (int i = 0; i < this.values.size(); i++) {
            if (this.values.get(i).key.equals(jsonPair.key)) {
                this.values.set(i, jsonPair);
                added = true;
                break;
            }
        }
        if (!added) {
            this.values.add(jsonPair);
        }
    }


    public Json find(String name) {
        for (JsonPair pair : this.values) {
            if (pair.key.equals(name)) {
                return pair.value;
            }
        }
        return null;

    }

    public JsonObject projection(String... names) {
        JsonObject jsonObject = new JsonObject();
        for (String name : names) {

            for (JsonPair pair : this.values) {
                if (pair.key.equals(name)) {
                    jsonObject.add(pair);
                }
            }
        }
        return jsonObject;
    }

    public boolean contains(String name) {

        for (JsonPair pair : this.values) {
            if (pair.key.equals(name)) {
                return true;
            }
        }
        return false;
    }
}
