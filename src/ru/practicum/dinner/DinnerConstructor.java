package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishTypes = new HashMap<>();;
    ArrayList<String> items = new ArrayList<>();
    Random random;

    void addNewDish(String dishType, String dishName) {
        if (dishTypes.containsKey(dishType)) {
            ArrayList<String> dishNames = dishTypes.get(dishType);
            dishNames.add(dishName);
        } else {
            ArrayList<String> dishNames = new ArrayList<>();
            dishNames.add(dishName);
            dishTypes.put(dishType,dishNames);
        }
    }

    void getListOfItems(String nextItem) {
        if (dishTypes.containsKey(nextItem)) {
            items.add(nextItem);
        } else {
            System.out.println("Такого типа нет в списке, попробуйте выбрать другой.");
        }
    }

    void generateDishCombo(int numberOfCombos) {
        for (int i = 0; i < numberOfCombos; i++) {

            ArrayList<String> dishNames = dishTypes.get(items.get(i));
            int dish = random.nextInt(dishNames.size());
            System.out.println(dishNames.get(dish));

        }

    }
}
