/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.repo;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IGenericRepo<T> {
    public abstract Boolean insert(T t);
    public abstract Boolean update(T t);
    public abstract Boolean recupera(T t);
    public abstract Boolean delete(T t);
    public abstract List<T> selectAll();
    public abstract T selectById(int id);
    public abstract List<T> selectByName();
}
