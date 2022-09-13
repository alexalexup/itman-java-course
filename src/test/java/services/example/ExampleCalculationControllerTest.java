package services.example;

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
class ExampleCalculationControllerTest {

    @Nested
    public class MethodsFromCalendarSpringApplication {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldWorkCorrectWhenScriptWasCalled() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/calculation?" +
                            "term1=20&operator=PLUS&term2=30")
                    .contentType("application/json");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("50.0"));
            request = MockMvcRequestBuilders.post("/calculation?" +
                    "term1=40&operator=MINUS&term2=10")
                    .contentType("application/json");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("30.0"));
            request = MockMvcRequestBuilders.post("/calculation?" +
                    "term1=3&operator=MULTIPLY&term2=12")
                    .contentType("application/json");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("36.0"));
            request = MockMvcRequestBuilders.post("/calculation?" +
                    "term1=5&operator=DIVIDE&term2=2")
                    .contentType("application/json");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("2.5"));
        }

        @Test
        public void shouldReturnOperatorsFromMath() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/calculation/operators");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content()
                            .json("[PLUS, MINUS, MULTIPLY, DIVIDE]"))
                    .andExpect(MockMvcResultMatchers.content()
                            .string("[\"PLUS\",\"MINUS\",\"MULTIPLY\",\"DIVIDE\"]"));
        }
    }
}