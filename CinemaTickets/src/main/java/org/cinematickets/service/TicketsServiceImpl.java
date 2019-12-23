package org.cinematickets.service;

import org.cinematickets.dto.Ticket;
import org.cinematickets.repository.TicketsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketsServiceImpl implements TicketsService {

    private final TicketsRepository ticketsRepository;

    public TicketsServiceImpl(TicketsRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
    }

    /* method checks input data by validation methods
       and, if it's successful, this method recodes
       the data to database  */
    @Override
    public Ticket bookingTicket(Ticket ticket) {
        if( isRightValue(ticket) ) {
            if( isFreePlace(findAllTickets(), ticket) ) {
                ticket.setPrice(findAllTickets().get(findRightPlace(findAllTickets(), ticket)).getPrice());
                ticket.setCurrency(findAllTickets().get(findRightPlace(findAllTickets(), ticket)).getCurrency());
                return ticketsRepository.saveAndFlush(ticket);
            } else {
                return ticketsRepository.findAll().get(Integer.parseInt(ticket.getPlace())-1);
            }
        } else {
            return ticketsRepository.findAll().get(0);
        }
    }

    /* this method is used for displaying places in right ordered */
    @Override
    public Ticket findTicketByPlace(int place) {
        int counter = 0;
        for(int i=0; i<findAllTickets().size(); i++) {
            if( Integer.parseInt(findAllTickets().get(i).getPlace()) == place ) { counter = i; }
        }
        return findAllTickets().get(counter);
    }

    /* this method is used for receive booked ticked */
    @Override
    public List<Ticket> getBookedTickets() {
        List<Ticket> ticketList = new ArrayList<>();

        for(Ticket eachTicket: ticketsRepository.findAll()) {
            if( !eachTicket.getIsFree() ) { ticketList.add(eachTicket); }
        }
        return ticketList;
    }

    @Override
    public boolean isFreePlace(List<Ticket> ticketList, Ticket ticket) {
        return ticketList.get(findRightPlace(ticketList, ticket)).getIsFree();
    }

    @Override
    public List<Ticket> findAllTickets() {
        return ticketsRepository.findAll();
    }

    /* this method is used for matching places in the cinema
        and their location in database*/
    @Override
    public int findRightPlace(List<Ticket> ticketList, Ticket ticket) {
        for(int i=0; i<ticketList.size(); i++) {
            if( ticketList.get(i).getPlace().equals(ticket.getPlace()) ) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int totalIncome() {
        int income = 0;

        for(Ticket eachTicket: findAllTickets()) {
            if( !eachTicket.getIsFree() ) {
                income += Integer.parseInt(eachTicket.getPrice());
            }
        }
        return income;
    }

    @Override
    public boolean isNotNull(Ticket ticket) {
        return ( (ticket.getPlace() != null && !ticket.getPlace().isEmpty()) &&
                (ticket.getName() != null && !ticket.getName().isEmpty()));
    }

    /* the method is for checking input data */
    @Override
    public boolean isRightValue(Ticket ticket) {
        if(isNotNull(ticket)) {
            try {
                if( Integer.parseInt(ticket.getPlace()) > findAllTickets().size() ) { return false; }
            } catch (NumberFormatException exc) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public String getTicketCurrency() {
        return findAllTickets().get(0).getCurrency();
    }

    @Override
    public int totalTicketAmount() {
        return findAllTickets().size();
    }

    @Override
    public int bookedTicketAmount() {
        int counter = 0;

        for(int i=0; i<findAllTickets().size(); i++) {
            if( !findAllTickets().get(i).getIsFree() ) {
                counter ++;
            }
        }

        return counter;
    }
}
