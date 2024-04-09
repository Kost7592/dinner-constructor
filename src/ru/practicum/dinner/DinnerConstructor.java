package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> typesOfDishes;

    static void addNewDish(String dishType, String dishName, HashMap<String, ArrayList<String>> typesOfDishes) {
        if (typesOfDishes.containsKey(dishType)) {
            ArrayList<String> dishNames = typesOfDishes.get(dishType);
            dishNames.add(dishName);
        } else {
            ArrayList<String> dishNames = new ArrayList<>();
            dishNames.add(dishName);
            typesOfDishes.put(dishType,dishNames);
        }
    }
}
