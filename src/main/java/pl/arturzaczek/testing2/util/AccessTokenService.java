package pl.arturzaczek.testing2.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.arturzaczek.testing2.jpa.model.dto.AccessToken;

import java.util.Base64;

@Component
@Slf4j
public class AccessTokenService {

    public AccessToken getDecodedToken(final String inputJson) throws JsonProcessingException {
        byte[] decodedBytes = Base64.getDecoder().decode(inputJson);
        String decodedString = new String(decodedBytes);
        log.info("\ntoken input: {}\ntoken decoded string: {}", inputJson, decodedString);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(decodedString, AccessToken.class);
    }
}
