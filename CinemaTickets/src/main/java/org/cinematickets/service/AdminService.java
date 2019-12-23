package org.cinematickets.service;

import org.cinematickets.dto.Administrator;

import java.util.List;

public interface AdminService {

    List<Administrator> getAllAdmin();

    boolean isAdmin(Administrator administrator);

    boolean isNotNull(Administrator administrator);
}
