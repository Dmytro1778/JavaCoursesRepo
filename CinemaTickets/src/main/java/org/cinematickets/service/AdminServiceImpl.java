package org.cinematickets.service;

import org.cinematickets.dto.Administrator;
import org.cinematickets.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final TicketsService ticketsService;

    public AdminServiceImpl(AdminRepository adminRepository, TicketsService ticketsService) {
        this.adminRepository = adminRepository;
        this.ticketsService = ticketsService;
    }

    @Override
    public List<Administrator> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public boolean isAdmin(Administrator administrator) {
        if(isNotNull(administrator)) {
            for(Administrator admin: getAllAdmin()) {
                if( admin.getAdminName().equals(administrator.getAdminName()) &
                        admin.getPassword().equals(administrator.getPassword()) ) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isNotNull(Administrator administrator) {
        return ( (administrator.getAdminName() != null && !administrator.getAdminName().isEmpty()) &&
                (administrator.getPassword() != null && !administrator.getPassword().isEmpty()));
    }
}
