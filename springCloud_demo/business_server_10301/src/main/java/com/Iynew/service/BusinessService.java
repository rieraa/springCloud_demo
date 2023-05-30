package com.Iynew.service;

import java.util.List;

import com.Iynew.po.Business;

public interface BusinessService {
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

    public Business getBusinessById(Integer businessId);
}