package services.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class EventExampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void postEventShouldSendEventInJSONTypeWhenMethodWasCalled() throws Exception {
        MockHttpServletRequestBuilder postRequest = MockMvcRequestBuilders.post("/api/event")
                .contentType("application/json")
                .content("{\"year\":1998, \"month\":8, \"day\":25, \"name\":\"job offer\"}");
        this.mockMvc.perform(postRequest)
                .andExpect(MockMvcResultMatchers.status().isOk());
        MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.get("/api/event");
        this.mockMvc.perform(getRequest)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"year\":1998, " +
                        "\"month\":8, \"day\":25, \"name\":\"job offer\"}"));
    }
}