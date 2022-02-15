package pl.arturzaczek.testing2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import pl.arturzaczek.testing2.jpa.model.dto.BusinessResponse;

import java.util.List;

public interface BusinessApi {

    @GetMapping(value = "/product-access",produces = {"application/json"})
    ResponseEntity<BusinessResponse> getBusinessResponse(@RequestParam(required = false) final List<String> services,
                                                         @RequestHeader("token") final String accessToken);
}
