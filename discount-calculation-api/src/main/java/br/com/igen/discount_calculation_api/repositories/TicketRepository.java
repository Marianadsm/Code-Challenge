package br.com.igen.discount_calculation_api.repositories;

import br.com.igen.discount_calculation_api.models.Ticket;
import br.com.igen.discount_calculation_api.utils.WeekDay;

public interface TicketRepository {
   
    public double applyDiscountByTicketAndWeekday(Ticket ticket, WeekDay weekday);
   
    public double applyStudentsDiscount(Ticket ticket);
}
