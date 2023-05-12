package com.Iynew.service;

import java.util.List;

import com.Iynew.po.Food;

public interface FoodService {
    public List<Food> listFoodByBusinessId(Integer businessId);
}