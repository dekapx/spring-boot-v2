package com.dekapx.springboot.service;

import com.dekapx.springboot.model.Contact;
import com.dekapx.springboot.model.Status;
import com.dekapx.springboot.repository.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {
    private IGenericDao<Status> genericDao;

    @Autowired
    public StatusServiceImpl(final IGenericDao<Status> genericDao) {
        this.genericDao = genericDao;
        this.genericDao.setClazz(Status.class);
    }

    @Override
    public Status findOne(final Long id) {
        return this.genericDao.findOne(id);
    }
}
