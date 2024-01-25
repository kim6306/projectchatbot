package org.itsci.projectweb.service;

import org.itsci.projectweb.dao.AdministratorDao;
import org.itsci.projectweb.model.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorDao administratorDao;

    @Override
    @Transactional
    public List<Administrator> getAdministrators() {
        return administratorDao.getAdministrators();
    }

    @Override
    @Transactional
    public Administrator getAdministratorByUsername(String username) {
        return administratorDao.getAdministratorByUsername(username);
    }
}
