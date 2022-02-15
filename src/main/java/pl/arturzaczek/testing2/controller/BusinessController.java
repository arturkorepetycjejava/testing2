package pl.arturzaczek.testing2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.arturzaczek.testing2.exception.AccessTokenException;
import pl.arturzaczek.testing2.jpa.model.dto.AccessToken;
import pl.arturzaczek.testing2.jpa.model.dto.BusinessResponse;
import pl.arturzaczek.testing2.service.BusinessService;
import pl.arturzaczek.testing2.util.AccessTokenService;
import pl.arturzaczek.testing2.util.ClientContext;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BusinessController implements BusinessApi {

    private final ClientContext clientContext;
    private final BusinessService businessService;
    private final AccessTokenService accessTokenService;


    @Override
    public ResponseEntity<BusinessResponse> getBusinessResponse(final List<String> services, final String accessToken) {
        try {
            final AccessToken decodedToken = accessTokenService.getDecodedToken(accessToken);
            clientContext.setAccessToken(decodedToken);
        }catch (final Exception e){
            log.error(e.getMessage());
            throw new AccessTokenException("access token error", e);
        }
        return ResponseEntity.ok(businessService.getBusinessResponse(Optional.ofNullable(services)));
    }
}
