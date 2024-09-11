/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author trung
 */
public interface CRUD<T> {
    public int create(T object);
    public T read(int id);
    public int update(T object);
    public int delete(T object);
}
