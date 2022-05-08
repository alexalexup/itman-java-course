package services.calendar;

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
class CalendarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void methodsFromCalendarSpringApplicationShouldWorkCorrectWhenFirstScriptWasCalled() throws Exception {
        MockHttpServletRequestBuilder addEvent = MockMvcRequestBuilders.post("/api/event/add")
                .contentType("application/json")
                .content("{\"year\":1998, \"month\":8, \"day\":25, \"name\":\"job offer\"}");
        this.mockMvc.perform(addEvent);
        addEvent = MockMvcRequestBuilders.post("/api/event/add")
                .contentType("application/json")
                .content("{\"year\":1997, \"month\":8, \"day\":25, \"name\":\"good day\"}");
        this.mockMvc.perform(addEvent);
        addEvent = MockMvcRequestBuilders.post("/api/event/add")
                .contentType("application/json")
                .content("{\"year\":1998, \"month\":8, \"day\":24, \"name\":\"birthday\"}");
        this.mockMvc.perform(addEvent);
        addEvent = MockMvcRequestBuilders.post("/api/event/add")
                .contentType("application/json")
                .content("{\"year\":1998, \"month\":8, \"day\":24, \"name\":\"aloha\"}");
        this.mockMvc.perform(addEvent);
        MockHttpServletRequestBuilder getAllEvents = MockMvcRequestBuilders.get("/api/event/all");
        this.mockMvc.perform(getAllEvents)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[" +
                        "{\"year\":1997, \"month\":8, \"day\":25, \"name\":\"good day\", \"id\":2}," +
                        "{\"year\":1998, \"month\":8, \"day\":24, \"name\":\"aloha\", \"id\":4}," +
                        "{\"year\":1998, \"month\":8, \"day\":24, \"name\":\"birthday\", \"id\":3}," +
                        "{\"year\":1998, \"month\":8, \"day\":25, \"name\":\"job offer\", \"id\":1}" + "]"));
        MockHttpServletRequestBuilder gedById = MockMvcRequestBuilders.get("/api/event/get")
                .contentType("application/json")
                .content("4");
        this.mockMvc.perform(gedById)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"year\":1998, \"month\":8, \"day\":24," +
                        " \"name\":\"aloha\", \"id\":4}"));
        MockHttpServletRequestBuilder removeById = MockMvcRequestBuilders.post("/api/event/remove")
                .contentType("application/json")
                .content("1");
        this.mockMvc.perform(removeById);
        this.mockMvc.perform(getAllEvents)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[" +
                        "{\"year\":1997, \"month\":8, \"day\":25, \"name\":\"good day\", \"id\":2}," +
                        "{\"year\":1998, \"month\":8, \"day\":24, \"name\":\"aloha\", \"id\":4}," +
                        "{\"year\":1998, \"month\":8, \"day\":24, \"name\":\"birthday\", \"id\":3}" + "]"));
        MockHttpServletRequestBuilder getEventsByYearMonthDay = MockMvcRequestBuilders.get("/api/event/" +
                "year/month/day?year=1998&month=8&day=24");
        this.mockMvc.perform(getEventsByYearMonthDay)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[" +
                        "{\"year\":1998, \"month\":8, \"day\":24, \"name\":\"aloha\", \"id\":4}," +
                        "{\"year\":1998, \"month\":8, \"day\":24, \"name\":\"birthday\", \"id\":3}" + "]"));
    }

}