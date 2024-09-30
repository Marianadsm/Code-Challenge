package br.com.igen.discount_calculation_api.services;

import br.com.igen.discount_calculation_api.models.Ticket;
import br.com.igen.discount_calculation_api.utils.WeekDay;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketServiceTest {

	private final TicketService ticketService = new TicketService();

	@Test
	public void testApplyDiscountByTicketAndWeekday_Crianca_Segunda() {
		Ticket ticket = new Ticket("criança");
		double expectedPrice = 4.95;

		double finalPrice = ticketService.applyDiscountByTicketAndWeekday(ticket, WeekDay.SEGUNDA);

		assertEquals(expectedPrice, finalPrice, 0.01);
	}
	
	@Test
	public void testApplyDiscountByTicketAndWeekday_Idoso_Segunda() {
		Ticket ticket = new Ticket("idoso");
		double expectedPrice = 5.4;

		double finalPrice = ticketService.applyDiscountByTicketAndWeekday(ticket, WeekDay.SEGUNDA);

		assertEquals(expectedPrice, finalPrice, 0.01);
	}
	
	@Test
	public void testApplyDiscountByTicketAndWeekday_Estudante_Segunda() {
		Ticket ticket = new Ticket("estudante");
		double expectedPrice = 7.2;

		double finalPrice = ticketService.applyDiscountByTicketAndWeekday(ticket, WeekDay.SEGUNDA);

		assertEquals(expectedPrice, finalPrice, 0.01);
	}

	@Test
	public void testApplyDiscountByTicketAndWeekday_Idoso_Terca() {

		Ticket ticket = new Ticket("idoso");
		double expectedPrice = 5.1;

		double finalPrice = ticketService.applyDiscountByTicketAndWeekday(ticket, WeekDay.TERCA);

		assertEquals(expectedPrice, finalPrice, 0.01);
	}

	@Test
	public void testApplyDiscountByTicketAndWeekday_Crianca_Terca() {

		Ticket ticket = new Ticket("criança");
		double expectedPrice = 4.68;

		double finalPrice = ticketService.applyDiscountByTicketAndWeekday(ticket, WeekDay.TERCA);

		assertEquals(expectedPrice, finalPrice, 0.01);
	}
	
	@Test
	public void testApplyDiscountByTicketAndWeekday_Estudante_Terca() {

		Ticket ticket = new Ticket("estudante");
		double expectedPrice = 7.60;

		double finalPrice = ticketService.applyDiscountByTicketAndWeekday(ticket, WeekDay.TERCA);

		assertEquals(expectedPrice, finalPrice, 0.01);
	}
	
	@Test
    public void testApplyDiscountByTicketAndWeekday_Idoso_Quarta() {
       
        Ticket ticket = new Ticket("idoso");
        double expectedPrice = 3.60; 

        double finalPrice = ticketService.applyDiscountByTicketAndWeekday(ticket, WeekDay.QUARTA);

        assertEquals(expectedPrice, finalPrice, 0.01);
    }
	
	@Test
    public void testApplyDiscountByTicketAndWeekday_Crianca_Quarta() {
       
        Ticket ticket = new Ticket("criança");
        double expectedPrice = 3.85; 

        double finalPrice = ticketService.applyDiscountByTicketAndWeekday(ticket, WeekDay.QUARTA);

        assertEquals(expectedPrice, finalPrice, 0.01);
    }
	
	@Test
    public void testApplyDiscountByTicketAndWeekday_Estudante_Quarta() {
       
        Ticket ticket = new Ticket("estudante");
        double expectedPrice = 4.00; 

        double finalPrice = ticketService.applyDiscountByTicketAndWeekday(ticket, WeekDay.QUARTA);

        assertEquals(expectedPrice, finalPrice, 0.01);
    }
	
	@Test
    public void testApplyDiscountByTicketAndWeekday_Idoso_Quinta() {
       
        Ticket ticket = new Ticket("idoso");
        double expectedPrice = 4.20; 

        double finalPrice = ticketService.applyDiscountByTicketAndWeekday(ticket, WeekDay.QUINTA);

        assertEquals(expectedPrice, finalPrice, 0.01);
    }
	
	@Test
    public void testApplyDiscountByTicketAndWeekday_Estudante_Quinta() {
       
        Ticket ticket = new Ticket("estudante");
        double expectedPrice = 5.60; 

        double finalPrice = ticketService.applyDiscountByTicketAndWeekday(ticket, WeekDay.QUINTA);

        assertEquals(expectedPrice, finalPrice, 0.01);
    }
	
	@Test
    public void testApplyDiscountByTicketAndWeekday_Crianca_Sexta() {
       
        Ticket ticket = new Ticket("criança");
        double expectedPrice = 4.89; 

        double finalPrice = ticketService.applyDiscountByTicketAndWeekday(ticket, WeekDay.SEXTA);

        assertEquals(expectedPrice, finalPrice, 0.01);
    }
	
	
	@Test
	public void testApplyStudentsDiscount_Estudante() {

		Ticket ticket = new Ticket("estudante");
		double expectedPrice = 5.20;

		double finalPrice = ticketService.applyStudentsDiscount(ticket);

		assertEquals(expectedPrice, finalPrice, 0.01);
	}

	@Test
	public void testApplyDiscountByTicketAndWeekday_Idoso_Sabado() {

		Ticket ticket = new Ticket("idoso");
		double expectedPrice = 5.70;

		double finalPrice = ticketService.applyDiscountByTicketAndWeekday(ticket, WeekDay.SABADO);

		assertEquals(expectedPrice, finalPrice, 0.01);
	}
	
	@Test
	public void testApplyDiscountByTicketAndWeekday_Idoso_Domingo() {

		Ticket ticket = new Ticket("idoso");
		double expectedPrice = 5.70;

		double finalPrice = ticketService.applyDiscountByTicketAndWeekday(ticket, WeekDay.DOMINGO);

		assertEquals(expectedPrice, finalPrice, 0.01);
	}
	
	@Test
	public void testApplyDiscountByTicketAndWeekday_Idoso_Feriado() {

		Ticket ticket = new Ticket("idoso");
		double expectedPrice = 5.70;

		double finalPrice = ticketService.applyDiscountByTicketAndWeekday(ticket, WeekDay.FERIADO);

		assertEquals(expectedPrice, finalPrice, 0.01);
	}


	
}
