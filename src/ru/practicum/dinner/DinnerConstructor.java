package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishTypes = new HashMap<>();;
    ArrayList<String> items = new ArrayList<>();
    Random random = new Random();

    void addNewDish(String dishType, String dishName) {    //добавление нового блюда в хеш-таблицу
        if (dishTypes.containsKey(dishType)) {    //вариант, когда тип блюда уже есть в таблице
            ArrayList<String> dishNames = dishTypes.get(dishType);
            if (dishNames.contains(dishName)) {    //защита от дублирования записей блюд в одном типе
                System.out.println("Блюдо уже имеется в этом типе, введите другое блюдо");
            } else {
                dishNames.add(dishName);
            }
        } else {    //вариант, когда тип блюда еще отсутствует в таблице
            ArrayList<String> dishNames = new ArrayList<>();
            dishNames.add(dishName);
            dishTypes.put(dishType,dishNames);
        }
    }

    void getListOfItems(String nextItem) {    // получение списка типов блюд для генерации комбо
        if (dishTypes.containsKey(nextItem)) {
            items.add(nextItem);
        } else {
            System.out.println("Такого типа нет в списке, попробуйте выбрать другой.");
        }
    }

    void generateDishCombo(int numberOfCombos) {    // генерация комбо
        for (int k = 0; k < numberOfCombos; k++) {
            ArrayList<String> comboItems = new ArrayList<>();   // список комбо вариантов
            for (int i = 0; i < items.size(); i++) {
                ArrayList<String> dishNames = dishTypes.get(items.get(i));
                int index = random.nextInt(dishNames.size());
                comboItems.add(dishNames.get(index));
            }
            System.out.println("Комбо " + (k + 1) + "\n" + comboItems);
        }
    }
}
