package pl.arturzaczek.testing2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import pl.arturzaczek.testing2.exception.AccessTokenException;
import pl.arturzaczek.testing2.exception.NoActiveProductException;
import pl.arturzaczek.testing2.exception.PrvtProfileTypeNotImplementedException;
import pl.arturzaczek.testing2.jpa.model.dto.AccessToken;
import pl.arturzaczek.testing2.jpa.model.dto.BusinessResponse;
import pl.arturzaczek.testing2.jpa.model.dto.Product;
import pl.arturzaczek.testing2.jpa.model.dto.ProfileType;
import pl.arturzaczek.testing2.jpa.model.entity.ProductEntity;
import pl.arturzaczek.testing2.repository.ProductEntityRepository;
import pl.arturzaczek.testing2.util.ClientContext;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BusinessService {

    private final ClientContext clientContext;
    private final ProductEntityRepository productEntityRepository;

    public BusinessResponse getBusinessResponse(final Optional<List<String>> services) {
        final AccessToken accessToken = clientContext.getAccessToken();
        if (accessToken == null || accessToken.getProfileType() == null) {
            throw new AccessTokenException("access token incomplete");
        }
        if (accessToken.getProfileType() == ProfileType.PRVT) {
            throw new PrvtProfileTypeNotImplementedException("Prvt profile type is not implemented");
        }
        List products;
        if (services.isPresent()) {
            products = getAllActiveProductsMatchingList(services.get());
        } else {
            products = getAllActiveProducts();
        }

        return createResponse(products, accessToken.getUserId());
    }

    private List<ProductEntity> getAllActiveProducts() {
        final List<ProductEntity> allActiveProducts = productEntityRepository.getAllActiveProducts();
        if (CollectionUtils.isEmpty(allActiveProducts)) {
            throw new NoActiveProductException();
        }
        return allActiveProducts;
    }

    private List<ProductEntity> getAllActiveProductsMatchingList(final List<String> serviceActivity) {
        final var allActiveProducts = productEntityRepository.getAllActiveProductsMatchingToServiceActivity(serviceActivity);
        if (CollectionUtils.isEmpty(allActiveProducts)) {
            throw new NoActiveProductException();
        }
        return allActiveProducts;
    }

    private BusinessResponse createResponse(final List<ProductEntity> allActiveProducts, final int userId) {
        return BusinessResponse.builder()
                .uuid(String.valueOf(userId))
                .productList(allActiveProducts
                        .stream()
                        .map(product -> new Product(product.getProductName()))
                        .collect(Collectors.toList()))
                .build();
    }
}
