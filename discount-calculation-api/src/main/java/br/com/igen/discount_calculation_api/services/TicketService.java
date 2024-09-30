package br.com.igen.discount_calculation_api.services;

import org.springframework.stereotype.Service;
import br.com.igen.discount_calculation_api.models.Ticket;
import br.com.igen.discount_calculation_api.repositories.TicketRepository;
import br.com.igen.discount_calculation_api.utils.WeekDay;

@Service
public class TicketService implements TicketRepository {

	@Override
	public double applyDiscountByTicketAndWeekday(Ticket ticket, WeekDay weekDay) {

		double initialPrice = ticket.getPrice();
		int discountPercentage = 0;

		switch (weekDay) {
		case SEGUNDA:
			discountPercentage = 10;
			break;
		case TERCA:
			if (ticket.getTicketType().equalsIgnoreCase("criança")
					|| ticket.getTicketType().equalsIgnoreCase("idoso")) {
				discountPercentage = 15;
			} else {
				discountPercentage = 5;
			}
			break;
		case QUARTA:
			if (ticket.getTicketType().equalsIgnoreCase("criança")) {
				discountPercentage = 30;
			} else if (ticket.getTicketType().equalsIgnoreCase("idoso")) {
				discountPercentage = 40;
			} else {
				discountPercentage = 50;
			}
			break;
		case QUINTA:
			if (ticket.getTicketType().equalsIgnoreCase("idoso")
					|| ticket.getTicketType().equalsIgnoreCase("estudante")) {
				discountPercentage = 30;
			}
			break;
		case SEXTA:
			if (ticket.getTicketType().equalsIgnoreCase("criança")) {
				discountPercentage = 11;
			}
			break;
		case SABADO:
		case DOMINGO:
		case FERIADO:
			if (ticket.getTicketType().equalsIgnoreCase("idoso")) {
				discountPercentage = 5;
			}
			break;
		default:
			discountPercentage = 0;
		}

		double discountValue = (initialPrice * discountPercentage) / 100;
		double finalPrice = initialPrice - discountValue;

		return finalPrice;
	}

	@Override
	public double applyStudentsDiscount(Ticket ticket) {
		
			double price = ticket.getPrice();
			double discountPercentage = 35;

			double discount = discountPercentage / 100;
			double discountValue = price * discount;

			double finalPrice = price - discountValue;

			return finalPrice;
		} 
	}


