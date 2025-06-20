package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    Random random = new Random();
    HashMap<String, ArrayList<String>> dishList;

    public DinnerConstructor() {
        dishList = new HashMap<>();
    }

    void addNewDish(String dishType, String dishName) {

        ArrayList<String> dishes = new ArrayList<>();

        if (checkDishesType(dishType)) {
            dishList.get(dishType).add(dishName);
        } else {
            dishes.add(dishName);
            dishList.put(dishType, dishes);
        }
    }

    void generateDishCombo(int numberOfCombos, ArrayList<String> dishType) {
        for (int comboNumber = 0; comboNumber < numberOfCombos; comboNumber++) {
            System.out.println("Комбо " + (comboNumber + 1));
            for (String dish : dishType) {
                int randomDish = random.nextInt(dishList.get(dish).size());
                System.out.println(dishList.get(dish).get(randomDish));
            }
        }
    }

    boolean checkDishesType(String dishType) {
        boolean categoryCheck = false;

        for (String check : dishList.keySet()) {
            if (check.equals(dishType)) {
                categoryCheck = true;
                break;
            }
        }
        return  categoryCheck;
    }
}
