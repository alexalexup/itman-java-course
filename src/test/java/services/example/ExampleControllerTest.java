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
class ExampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void extractShouldExecutedWith200WhenPassAllParams() throws Exception {
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

    @Test
    public void firstPageShouldExecutedWith200() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("I'm your first web-service"));
    }

    @Test
    public void secondPageShouldExecutedWith200() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/second");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("I'm the second binding"));
    }

    @Test
    public void postMethodShouldExecutedWith200() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/second");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("I'm post mapping"));
    }

    @Test
    public void putMethodShouldExecutedWith200() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/second");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("I'm put mapping"));
    }

    @Test
    public void patchMethodShouldExecutedWith200() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.patch("/second");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("I'm patch mapping"));
    }

    @Test
    public void deleteMethodShouldExecutedWith200() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("/second");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("I'm delete mapping"));
    }

    @Test
    public void numbFromParamShouldReturnResultWhenRangeHaveTwoValues() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/range?from=-3&to=-2");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("" +
                        "-3\n" +
                        "-2\n"));
    }

    @Test
    public void numbFromParamShouldReturnResultWhenRangeHaveSomeValues() throws Exception {
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
                        "3\n" +
                        "4\n"));
    }

    @Test
    public void numbFromVariableShouldReturnResultWhenRangeHaveTwoValues() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/range/0/1");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("" +
                        "0\n" +
                        "1\n"));
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
                        "3\n" +
                        "4\n"));
    }
}