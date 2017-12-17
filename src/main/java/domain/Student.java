package domain;

import json.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {

    private JsonArray exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        for (Tuple<String, Integer> exam : exams) {

        }
    }

    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject(
                new JsonPair("name", new JsonString(this.name)),
                new JsonPair("surname", new JsonString(this.surname)),
                new JsonPair("year", new JsonNumber(this.year)),
                new JsonPair("exams", this.exams)
        );
        return null;
    }
}
