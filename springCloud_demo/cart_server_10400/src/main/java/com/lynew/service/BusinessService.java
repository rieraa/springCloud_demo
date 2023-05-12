package com.lynew.service;

import com.lynew.po.Business;

import java.util.List;

public interface BusinessService {
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

    public Business getBusinessById(Integer businessId);
}