package ru.siestavl.siestavl.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmitry on 10/19/15.
 */
public class Order {

    private static Order instance;
    Map<Dish, Integer> dishList;
    ArrayList<Film> filmsList;

    private Order() {
        dishList = new HashMap<>();
        filmsList = new ArrayList<>();
    }

    public static synchronized Order getInstance(){

        if (instance == null){
            instance = new Order();
        }

        return instance;
    }

    public void setDish(Dish order, Integer val) {
        dishList.put(order, val);
    }

    public Map<Dish, Integer> getDishList() {
        return dishList;
    }

    public ArrayList<String> getArray() {
        ArrayList<String> array = new ArrayList<>();

        for (Map.Entry<Dish, Integer> entry : dishList.entrySet()) {
            array.add(entry.getValue().toString());
            //System.out.println("ID =  " + entry.getKey() + " День недели = " + entry.getValue());
        }

        return array;
    }

    public void setFilm(Film order) {
        filmsList.add(order);
    }

    public ArrayList<Film> getFilmsList() {
        return filmsList;
    }

    public boolean isEmptyDishList() {
        return dishList.isEmpty();
    }
    public boolean isEmptyFilmList() {
        return filmsList.isEmpty();
    }

    public int getCountOfDishes() {
        return dishList.size();
    }
}
