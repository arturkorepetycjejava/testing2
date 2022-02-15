package pl.arturzaczek.testing2.jpa.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BusinessResponse {
    private String uuid;
    private List<Product> productList;
}
