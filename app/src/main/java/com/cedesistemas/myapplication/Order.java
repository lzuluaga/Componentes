package com.cedesistemas.myapplication;

import java.io.Serializable;

/**
 * Created by jersonsuaza on 12/11/18.
 */

public class Order implements Serializable {

    private String food;
    private boolean hasSoda;
    private boolean hasSnack;

    public Order(){
        food = "";
        hasSnack = false;
        hasSoda = false;
    }

    public Order(String food, boolean hasSoda, boolean hasSnack) {
        this.food = food;
        this.hasSoda = hasSoda;
        this.hasSnack = hasSnack;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public boolean isHasSoda() {
        return hasSoda;
    }

    public void setHasSoda(boolean hasSoda) {
        this.hasSoda = hasSoda;
    }

    public boolean isHasSnack() {
        return hasSnack;
    }

    public void setHasSnack(boolean hasSnack) {
        this.hasSnack = hasSnack;
    }


}
