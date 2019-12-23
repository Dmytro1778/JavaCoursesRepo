package org.cinematickets.service;

import org.cinematickets.dto.Ticket;

import java.util.*;

public interface TicketsService {

    Ticket bookingTicket(Ticket ticket);

    Ticket findTicketByPlace(int place);

    boolean isFreePlace(List<Ticket> listTicket, Ticket ticket);

    List<Ticket> findAllTickets();

    List<Ticket> getBookedTickets();

    int findRightPlace(List<Ticket> ticketList, Ticket ticket);

    int totalIncome();

    boolean isNotNull(Ticket ticket);

    boolean isRightValue(Ticket ticket);

    String getTicketCurrency();

    int totalTicketAmount();

    int bookedTicketAmount();
}
