package com.liang.service;

import com.liang.model.JourneyUser;

public interface LoginService {
    public boolean compareInfo(JourneyUser user) throws Exception;
}
