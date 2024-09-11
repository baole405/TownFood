/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author trung
 */
public class MealIngre {
    private int id;
    private int id_ingre;
    private String name;
    private int amount;

    public MealIngre() {
    }

    public MealIngre(int id, int id_ingre, String name, int amount) {
        this.id = id;
        this.id_ingre = id_ingre;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_ingre() {
        return id_ingre;
    }

    public void setId_ingre(int id_ingre) {
        this.id_ingre = id_ingre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
