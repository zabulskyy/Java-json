package domain;

import json.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    JsonArray jsonArrayExams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        ArrayList<Json> jsonPairArrayList = new ArrayList<>();
        JsonObject jsonObjectExam;

        for (Tuple<String, Integer> exam : exams) {
            jsonObjectExam = tuple2ExamJsonObject(exam);
            jsonPairArrayList.add(jsonObjectExam);
        }
        this.jsonArrayExams = new JsonArray(jsonPairArrayList);
    }

    @Override
    public JsonObject toJsonObject() {
        return new JsonObject(
                new JsonPair("name", new JsonString(this.name)),
                new JsonPair("surname", new JsonString(this.surname)),
                new JsonPair("year", new JsonNumber(this.year)),
                new JsonPair("exams", this.jsonArrayExams)
        );
    }

    public static JsonObject tuple2ExamJsonObject(Tuple<String, Integer> tuple) {
        String course = tuple.key;
        int mark = tuple.value;
        boolean passed = mark >= 3;
        return new JsonObject(
                new JsonPair("course", new JsonString(course)),
                new JsonPair("mark", new JsonNumber(mark)),
                new JsonPair("passed", new JsonBoolean(passed))
        );
    }
}
