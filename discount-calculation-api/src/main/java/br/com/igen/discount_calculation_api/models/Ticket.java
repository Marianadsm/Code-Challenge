package br.com.igen.discount_calculation_api.models;

public class Ticket {

	private String ticketType;
	private double price;

	public Ticket(String ticketType) {
		this.ticketType = ticketType;
		switch (ticketType.toLowerCase()) {
		case "criança":
			this.price = 5.50;
			break;
		case "estudante":
			this.price = 8.00;
			break;
		case "idoso":
			this.price = 6.00;
			break;
		default:
			throw new IllegalArgumentException("Tipo de ingresso inválido");
		}
	}

	 public String getTicketType() {
	        return ticketType;
	    }

	    public double getPrice() {
	        return price;
	    }

}
