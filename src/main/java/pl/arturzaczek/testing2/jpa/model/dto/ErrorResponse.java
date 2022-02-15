package pl.arturzaczek.testing2.jpa.model.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.client.HttpStatusCodeException;

@Data
@Builder
public class ErrorResponse {
    private String code;
    private String message;
}
