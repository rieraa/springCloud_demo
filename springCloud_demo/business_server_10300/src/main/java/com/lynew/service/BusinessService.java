package com.lynew.service;

import java.util.List;

import com.lynew.po.Business;

public interface BusinessService {
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

    public Business getBusinessById(Integer businessId);
}