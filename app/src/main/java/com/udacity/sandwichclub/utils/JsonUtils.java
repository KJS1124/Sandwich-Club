package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        final String nameProperty = "name";
        final String placeOfOriginProperty = "placeOfOrigin";
        final String descriptionProperty = "description";
        final String imageProperty = "image";
        final String ingredientsProperty = "ingredients";
        final String mainNameProperty = "mainName";
        final String alsoKnownAsProperty = "alsoKnownAs";

        JSONObject object = new JSONObject(json);

        String name = object.getJSONObject(nameProperty).getString(mainNameProperty);
        List<String> alsoKnownAs = convertToList(object.getJSONObject(nameProperty).getJSONArray(alsoKnownAsProperty));
        String description = object.getString(descriptionProperty);
        String placeOfOrigin = object.getString(placeOfOriginProperty);
        String image = object.getString(imageProperty);
        List<String> ingredients = convertToList(object.getJSONArray(ingredientsProperty));

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
