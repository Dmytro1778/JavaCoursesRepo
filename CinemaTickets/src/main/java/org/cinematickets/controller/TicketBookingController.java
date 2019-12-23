package org.cinematickets.controller;

import org.cinematickets.dto.Administrator;
import org.cinematickets.dto.Ticket;
import org.cinematickets.service.AdminService;
import org.cinematickets.service.TicketsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class TicketBookingController {

    private final TicketsService ticketsService;
    private final AdminService adminService;

    public TicketBookingController(TicketsService ticketsService, AdminService adminService) {
        this.ticketsService = ticketsService;
        this.adminService = adminService;
    }

    @GetMapping("/")
    public String starter(Model model) {
        model.addAttribute("tickets", ticketsService.findAllTickets());
        model.addAttribute("ticket", ticketsService);
        return "page1";
    }

    @PostMapping("/booking")
    public String bookingTicket(@ModelAttribute("ticket") Ticket ticket,
                                HttpSession session,
                                Model model) {
        ticketsService.bookingTicket(ticket);
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @PostMapping("/admin")
    public String adminPage(@ModelAttribute("administrator") Administrator administrator,
                            HttpSession session,
                            Model model) {
        if(adminService.isAdmin(administrator)) {
            return "adminpage";
        }
        return "admin";
    }

    @GetMapping("/dailyresult")
    public String daylyResault(Model model) {
        model.addAttribute("ticket", ticketsService);
        return "dailyresult";
    }

    @GetMapping("/booking_list")
    public String find(Model model) {
        model.addAttribute("tickets", ticketsService.getBookedTickets());
        return "bookinglist";
    }

}
