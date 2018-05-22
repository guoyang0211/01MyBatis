package com.xdy.dao;

import com.xdy.bean.Provincial;

import java.io.Serializable;

public interface CountryDao {
    /**
     * 根绝省会的id 查出 省会 一级对用的国家
     */
    Provincial selectProvincialById(Serializable id);
}
