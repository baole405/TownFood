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
public class OrderDetail {
    private int id;
    private int idMeal;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(int id, int idMeal, int quantity) {
        this.id = id;
        this.idMeal = idMeal;
        this.quantity = quantity;

    }
        public OrderDetail(int idMeal, int quantity) {
        this.idMeal = idMeal;
        this.quantity = quantity;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(int idMeal) {
        this.idMeal = idMeal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
