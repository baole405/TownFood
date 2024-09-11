/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author trung
 */
public class Meal implements Serializable{
    private int id;
    private String mcate;
    private String name;
    private String recipe;
    private float price;
    private int status;
    private String address;

    public Meal() {
    }

    public Meal(int id, String mcate, String name, String recipe, float price, int status) {
        this.id = id;
        this.mcate = mcate;
        this.name = name;
        this.recipe = recipe;
        this.price = price;
        this.status = status;
    }

    
    
    public Meal(int id, String mcate, String name, String recipe, float price, int status, String address) {
        this.id = id;
        this.mcate = mcate;
        this.name = name;
        this.recipe = recipe;
        this.price = price;
        this.status = status;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMcate() {
        return mcate;
    }

    public void setMcate(String mcate) {
        this.mcate = mcate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Meal{" + "id=" + id + ", mcate=" + mcate + ", name=" + name + ", recipe=" + recipe + ", price=" + price + ", status=" + status + ", address=" + address + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Meal other = (Meal) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
