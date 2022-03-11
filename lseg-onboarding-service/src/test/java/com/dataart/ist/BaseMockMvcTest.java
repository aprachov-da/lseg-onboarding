package com.dataart.ist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public abstract class BaseMockMvcTest {

    private final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
            .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .modules(new JavaTimeModule())
            .build();

    @MockBean
    protected AuthenticationManager authenticationManager;
    @Autowired
    protected MockMvc mockMvc;

    protected String toJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    protected byte[] toByteArray(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsBytes(object);
    }

    protected void assertOkResponse(ResultActions response) throws Exception {
        response.andExpect(status().isOk());
    }

    protected void assertForbiddenResponse(ResultActions response) throws Exception {
        response.andExpect(status().isForbidden());
    }
}
