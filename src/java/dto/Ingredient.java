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
public class Ingredient {

    private int id;
    private String icate;
    private String name;
    private int quantity;
    private int status;
    private String address;

    public Ingredient() {
    }

    public Ingredient(int id, String icate, String name, int quantity, int status) {
        this.id = id;
        this.icate = icate;
        this.name = name;
        this.quantity = quantity;
        this.status = status;
    }

    public Ingredient(int id, String icate, String name, int quantity, int status, String address) {
        this.id = id;
        this.icate = icate;
        this.name = name;
        this.quantity = quantity;
        this.status = status;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcate() {
        return icate;
    }

    public void setIcate(String icate) {
        this.icate = icate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        return "Ingredient{" + "id=" + id + ", icate=" + icate + ", name=" + name + ", quantity=" + quantity + ", status=" + status + ", address=" + address + '}';
    }

    

}
