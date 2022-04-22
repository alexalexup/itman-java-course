package services.queue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class QueueControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void methodsFromQueueSpringApplicationShouldWorkCorrectWhenFirstScriptWasCalled() throws Exception {
        MockHttpServletRequestBuilder totalRequest = MockMvcRequestBuilders
                .get("/api/queue/totalTickets");
        this.mockMvc.perform(totalRequest)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("0"));
        MockHttpServletRequestBuilder nextTicketRequest = MockMvcRequestBuilders
                .get("/api/queue/nextTicket");
        this.mockMvc.perform(nextTicketRequest);
        this.mockMvc.perform(nextTicketRequest);
        this.mockMvc.perform(nextTicketRequest);
        this.mockMvc.perform(nextTicketRequest);
        this.mockMvc.perform(nextTicketRequest)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"number\":5, \"place\":\"bank\"}"));
        MockHttpServletRequestBuilder nextWorkDayRequest = MockMvcRequestBuilders
                .post("/api/queue/toNextWorkDay");
        this.mockMvc.perform(nextWorkDayRequest);
        this.mockMvc.perform(nextTicketRequest);
        this.mockMvc.perform(nextTicketRequest);
        this.mockMvc.perform(nextTicketRequest)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"number\":3, \"place\":\"bank\"}"));
        this.mockMvc.perform(nextWorkDayRequest);
        this.mockMvc.perform(nextTicketRequest);
        this.mockMvc.perform(nextTicketRequest);
        this.mockMvc.perform(nextTicketRequest);
        this.mockMvc.perform(nextTicketRequest);
        MockHttpServletRequestBuilder getVisitsByDaysRequest = MockMvcRequestBuilders
                .get("/api/queue/getVisitsByDays");
        this.mockMvc.perform(getVisitsByDaysRequest)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[5,3,4]"));
        this.mockMvc.perform(totalRequest)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("12"));
    }
}