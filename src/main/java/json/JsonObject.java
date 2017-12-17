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
        for (JsonPair pair : jsonPairs) {
            for (int i = 0; i < this.values.size(); i++) {
                if (this.values.get(i).key.equals(pair.key)) {
                    this.values.add(i, pair);
                    break;
                }
            }
            this.values.add(pair);
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
        // ToDo
    }

    public Json find(String name) {
        // ToDo
        return null;
    }

    public JsonObject projection(String... names) {
        // ToDo
        return null;
    }
}
