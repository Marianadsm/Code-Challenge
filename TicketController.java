package br.com.igen.discount_calculation_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.igen.discount_calculation_api.models.Ticket;
import br.com.igen.discount_calculation_api.services.TicketService;
import br.com.igen.discount_calculation_api.utils.WeekDay;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = "*")
@RestController
public class TicketController {

	private final TicketService ticketService;

	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@Operation(summary = "Calcula o preço do ingresso com base no tipo, dia da semana e se possui cartão de estudante.", description = "Este endpoint calcula o preço final do ingresso, aplicando descontos se necessário.", parameters = {
			@Parameter(name = "type", description = "Tipo de ingresso (Valores: 'estudante', 'criança', 'idoso')", required = true),
			@Parameter(name = "weekDay", description = "Dia da semana", required = true),
			@Parameter(name = "hasStudentCard", description = "Indica se o usuário possui um cartão de estudante", required = true) }, responses = {
					@ApiResponse(responseCode = "200", description = "Preço do ingresso calculado com sucesso"),
					@ApiResponse(responseCode = "400", description = "Parâmetros inválidos fornecidos") })
	
	@GetMapping("/calculateDiscount")
	public ResponseEntity<Double> calculatePrice(@RequestParam String type, @RequestParam String weekDay,
			@RequestParam boolean hasStudentCard) {
		Ticket ticket = new Ticket(type);
		WeekDay day = WeekDay.valueOf(weekDay.toUpperCase());

		double finalPrice;
		if (hasStudentCard && type.toLowerCase().equals("estudante") && !(weekDay.toUpperCase().equals("SABADO") || !weekDay.toUpperCase().equals("DOMINGO") ||!weekDay.toUpperCase().equals("FERIADO")  )) {
			finalPrice = ticketService.applyStudentsDiscount(ticket);
		} else {
			finalPrice = ticketService.applyDiscountByTicketAndWeekday(ticket, day);
			System.out.printf(type + hasStudentCard);
		}

		return ResponseEntity.ok(finalPrice);
	}
}
