package br.com.igen.discount_calculation_api.controllers;

import br.com.igen.discount_calculation_api.services.TicketService;
import br.com.igen.discount_calculation_api.utils.WeekDay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean 
    private TicketService ticketService;

    @BeforeEach
    public void setup() {
        Mockito.reset(ticketService);
    }

    @Test
    public void testCalculateDiscount_Crianca_Segunda() throws Exception {
        when(ticketService.applyDiscountByTicketAndWeekday(Mockito.any(), Mockito.eq(WeekDay.SEGUNDA)))
            .thenReturn(4.95); 

        mockMvc.perform(get("/calculateDiscount")
                .param("type", "criança")
                .param("weekDay", "SEGUNDA")
                .param("hasStudentCard", "false")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string("4.95"));
    }

    @Test
    public void testCalculateDiscount_Estudante_Terca() throws Exception {
        when(ticketService.applyStudentsDiscount(Mockito.any()))
            .thenReturn(5.2); 

        mockMvc.perform(get("/calculateDiscount")
                .param("type", "estudante")
                .param("weekDay", "TERCA")
                .param("hasStudentCard", "true")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string("5.2"));
    }

    @Test
    public void testCalculateDiscount_Idoso_Quarta() throws Exception {
        when(ticketService.applyDiscountByTicketAndWeekday(Mockito.any(), Mockito.eq(WeekDay.QUARTA)))
            .thenReturn(3.6); 

        mockMvc.perform(get("/calculateDiscount")
                .param("type", "idoso")
                .param("weekDay", "QUARTA")
                .param("hasStudentCard", "false")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string("3.6"));
    }

}
