package org.itsci.projectweb.service;

import org.itsci.projectweb.model.Administrator;

import java.util.List;

public interface AdministratorService {

    List<Administrator> getAdministrators ();
    Administrator getAdministratorByUsername (String username);

}
