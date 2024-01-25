package org.itsci.projectweb.dao;

import org.itsci.projectweb.model.Administrator;

import java.util.List;

public interface AdministratorDao {

    List<Administrator> getAdministrators ();
    Administrator getAdministratorByUsername (String username);

}
