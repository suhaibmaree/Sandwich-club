package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json)
    {
        Sandwich sandwich = new Sandwich();
        try {
            //Main name from Json
            JSONObject item = new JSONObject(json);
            JSONObject itemName = item.getJSONObject("name");
            String mainName = itemName.getString("mainName");
            sandwich.setMainName(mainName);
            //++++++++++++++++++++++++++++++++

            //alsoKnownAs from Json ** Array
            JSONArray alsoKnownAsArr =item.getJSONArray("alsoKnownAs");
            List< String > alsoKnownAsList =new ArrayList<>();
            for (int i=0; i < alsoKnownAsArr.length(); i++){
                alsoKnownAsList.add(alsoKnownAsArr.getString(i));
            }
            sandwich.setAlsoKnownAs(alsoKnownAsList);
            //+++++++++++++++++++++++++++++++++

            //placeOfOrigin from Json
            String placeOfOrigin = item.getString("placeOfOrigin");
            if (placeOfOrigin != null)
            sandwich.setPlaceOfOrigin(placeOfOrigin);
            //+++++++++++++++++++++++++++++++++

            //description from Json
            String description = item.getString("description");
            if (description != null)
            sandwich.setDescription(description);
            //+++++++++++++++++++++++++++++++++
            //image from Json
            String image = item.getString("image");
            if (image !=null)
            sandwich.setImage(image);
            //+++++++++++++++++++++++++++++++++

            //ingredients from Json **Array
            JSONArray ingredientsArr =item.getJSONArray("ingredients");
            List<String > ingredientsList =new ArrayList<>();
            for (int i=0; i<ingredientsArr.length();i++){
                ingredientsList.add(ingredientsArr.getString(i));
            }
            sandwich.setIngredients(ingredientsList);
            //+++++++++++++++++++++++++++++++++
        }catch (JSONException e){
            e.printStackTrace();
        }
        return sandwich;
    }
}
