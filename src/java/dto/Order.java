/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author trung
 */
public class Order {

    private int id;
    private int idAcc;
    private Date date;
    private String process;
    private int status;
    private float price;

    public Order() {
    }

    public Order( int idAcc, String process, int status, float price) {
        this.idAcc = idAcc;
        this.process = process;
        this.status = status;
        this.price = price;
    }

    public Order(int id, int idAcc, Date date, String process, int status, float price) {
        this.id = id;
        this.idAcc = idAcc;
        this.date = date;
        this.process = process;
        this.status = status;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAcc() {
        return idAcc;
    }

    public void setIdAcc(int idAcc) {
        this.idAcc = idAcc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
