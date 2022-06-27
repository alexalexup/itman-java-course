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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ExampleControllerTest {

    @Nested
    public class Extract {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldExecutedWith200WhenPassAllParams() throws Exception {
            final MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                    .post("/extract/one/1?required=r&optional=opt&default=0&missing=world")
                    .content("all params");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("" +
                            "pathVariable = one\n" +
                            "second = 1\n" +
                            "required = r\n" +
                            "optional = opt\n" +
                            "default = 0\n" +
                            "body = all params\n"
                    ));
        }
    }

    @Nested
    public class FirstPage {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldExecutedWith200() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("I'm your first web-service"));
        }
    }

    @Nested
    public class SecondPage {
        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldExecutedWith200() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/second");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("I'm the second binding"));
        }
    }

    @Nested
    public class PostMethod {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldExecutedWith200() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/second");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("I'm post mapping"));
        }
    }

    @Nested
    public class PutMethod {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldExecutedWith200() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/second");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("I'm put mapping"));
        }
    }

    @Nested
    public class PatchMethod {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldExecutedWith200() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.patch("/second");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("I'm patch mapping"));
        }
    }

    @Nested
    public class DeleteMethod {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldExecutedWith200() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("/second");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("I'm delete mapping"));
        }
    }

    @Nested
    public class NumbFromParam {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldReturnResultWhenRangeHaveOneValue() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/range?from=-3&to=-2");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("" +
                            "-3\n"));
        }

        @Test
        public void shouldReturnResultWhenRangeHaveSomeValues() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/range?from=-3&to=4");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("" +
                            "-3\n" +
                            "-2\n" +
                            "-1\n" +
                            "0\n" +
                            "1\n" +
                            "2\n" +
                            "3\n"));
        }
    }

    @Nested
    public class NumbFromVariable {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldReturnResultWhenRangeHaveOneValues() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/range/0/1");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("" +
                            "0\n"));
        }

        @Test
        public void numbFromVariableShouldReturnResultWhenRangeHaveSomeValues() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/range/-1/4");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("" +
                            "-1\n" +
                            "0\n" +
                            "1\n" +
                            "2\n" +
                            "3\n"));
        }
    }
}