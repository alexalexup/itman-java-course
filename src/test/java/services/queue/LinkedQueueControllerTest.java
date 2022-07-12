package services.queue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class LinkedQueueControllerTest {

    @Nested
    public class MethodsFromLinkedQueueSpringApplicationFirstScript {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void methodsFromQueueSpringApplicationShouldWorkCorrectWhenFirstScriptWasCalled() throws Exception {
            MockHttpServletRequestBuilder nextTicketRequest = MockMvcRequestBuilders
                    .get("/api/queue/nextTicket");
            this.mockMvc.perform(nextTicketRequest);
            this.mockMvc.perform(nextTicketRequest);
            this.mockMvc.perform(nextTicketRequest);
            MockHttpServletRequestBuilder getCurrentQueue = MockMvcRequestBuilders
                    .get("/api/queue/getCurrentQueue");
            this.mockMvc.perform(getCurrentQueue).andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json("[{\"number\":1,\"place\":\"bank\"}" +
                            ",{\"number\":2,\"place\":\"bank\"}" +
                            ",{\"number\":3,\"place\":\"bank\"}]"));
            MockHttpServletRequestBuilder callNext = MockMvcRequestBuilders
                    .post("/api/queue/callNext");
            this.mockMvc.perform(callNext);
            this.mockMvc.perform(callNext);
            this.mockMvc.perform(callNext).andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json("{\"number\":3, \"place\":\"bank\"}"));
            MockHttpServletRequestBuilder nextWorkDayRequest = MockMvcRequestBuilders
                    .post("/api/queue/toNextWorkDay");
            this.mockMvc.perform(nextWorkDayRequest);
            this.mockMvc.perform(nextTicketRequest);
            this.mockMvc.perform(nextTicketRequest);
            this.mockMvc.perform(getCurrentQueue).andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json("[{\"number\":1,\"place\":\"bank\"}" +
                            ",{\"number\":2,\"place\":\"bank\"}]"));
            MockHttpServletRequestBuilder totalRequest = MockMvcRequestBuilders
                    .get("/api/queue/totalTickets");
            this.mockMvc.perform(totalRequest)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("5"));
            this.mockMvc.perform(nextTicketRequest);
            this.mockMvc.perform(nextTicketRequest);
            this.mockMvc.perform(nextTicketRequest);
            this.mockMvc.perform(nextTicketRequest);
            this.mockMvc.perform(nextTicketRequest)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json("{\"number\":7, \"place\":\"bank\"}"));
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
                    .andExpect(MockMvcResultMatchers.content().json("[3,7,3,4]"));
            this.mockMvc.perform(totalRequest)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("17"));
        }
    }
}