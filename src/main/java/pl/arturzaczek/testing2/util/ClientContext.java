package pl.arturzaczek.testing2.util;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import pl.arturzaczek.testing2.jpa.model.dto.AccessToken;

@Component
@RequestScope
@Data
public class ClientContext {
    private AccessToken accessToken;
}
