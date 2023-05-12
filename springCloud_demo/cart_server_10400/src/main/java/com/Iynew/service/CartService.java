package com.Iynew.service;

import java.util.List;

import com.Iynew.po.Cart;

public interface CartService {
    public List<Cart> listCart(Cart cart);

    public int saveCart(Cart cart);

    public int updateCart(Cart cart);

    public int removeCart(Cart cart);
}