package com.Iynew.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Iynew.mapper.CartMapper;
import com.Iynew.po.Cart;
import com.Iynew.service.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<Cart> listCart(Cart cart) {
        return cartMapper.listCart(cart);
    }

    @Override
    public int saveCart(Cart cart) {
        return cartMapper.saveCart(cart);
    }

    @Override
    public int updateCart(Cart cart) {
        return cartMapper.updateCart(cart);
    }

    @Override
    public int removeCart(Cart cart) {
        return cartMapper.removeCart(cart);
    }
}