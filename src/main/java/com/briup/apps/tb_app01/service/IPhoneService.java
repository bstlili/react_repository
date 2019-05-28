package com.briup.apps.tb_app01.service;

import com.briup.apps.tb_app01.bean.Phone;

import java.util.List;

public interface IPhoneService {
    List<Phone> findAll();

    void saveOrUpdate(Phone phone);

    Phone findById(long id);
}
