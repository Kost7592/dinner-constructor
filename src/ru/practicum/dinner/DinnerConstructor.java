package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishTypes = new HashMap<>();;
    ArrayList<String> items = new ArrayList<>();
    Random random = new Random();

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
        HashMap<String, ArrayList<String>> combos = new HashMap<>();

        for (int k = 0; k < numberOfCombos; k++) {
            ArrayList<String> comboItems = new ArrayList<>();
            for (int i = 0; i < items.size(); i++) {
            ArrayList<String> dishNames = dishTypes.get(items.get(i)); /* достаем из хеш-таблицы список блюд под первым набранным типом блюд */
            int index = random.nextInt(dishNames.size()); //выбираем случайую запись из списка
            comboItems.add(dishNames.get(index)); // включаем случайную запись в новый список
            }
            System.out.println("Комбо " + (k + 1) + comboItems);
        }

    }
}
