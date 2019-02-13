package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final String NAME = "name";
    private static final String PLACE_OF_ORIGIN = "placeOfOrigin";
    private static final String DESCRIPTION = "description";
    private static final String IMAGE = "image";
    private static final String INGREDIENTS = "ingredients";
    private static final String MAIN_NAME = "mainName";
    private static final String ALSO_KNOWN_AS = "alsoKnownAs";

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject object = new JSONObject(json);

        String name = object.getJSONObject(NAME).getString(MAIN_NAME);
        List<String> alsoKnownAs = convertToList(object.getJSONObject(NAME).getJSONArray(ALSO_KNOWN_AS));
        String description = object.getString(DESCRIPTION);
        String placeOfOrigin = object.getString(PLACE_OF_ORIGIN);
        String image = object.getString(IMAGE);
        List<String> ingredients = convertToList(object.getJSONArray(INGREDIENTS));

        Sandwich sandwich = new Sandwich(name, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        return sandwich;
    }

    private static List<String> convertToList(JSONArray array) throws JSONException {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < array.length(); i++)
            result.add(array.getString(i));
        return result;
    }
}
