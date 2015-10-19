package ru.siestavl.siestavl.entity;

import java.util.ArrayList;

/**
 * Created by dmitry on 10/19/15.
 */
public class Basket {

    private static Basket instance;
    ArrayList<Dish> dishList;
    ArrayList<Film> filmsList;

    private Basket() {
        dishList = new ArrayList<>();
        filmsList = new ArrayList<>();
    }

    public static synchronized Basket getInstance(){

        if (instance == null){
            instance = new Basket();
        }

        return instance;
    }

    public void setDish(Dish order) {
        dishList.add(order);
    }

    public ArrayList<Dish> getDishList() {
        return dishList;
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
