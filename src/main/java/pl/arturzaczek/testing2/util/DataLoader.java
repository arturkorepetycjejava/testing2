package pl.arturzaczek.testing2.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.arturzaczek.testing2.jpa.model.entity.ProductEntity;
import pl.arturzaczek.testing2.repository.ProductEntityRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataLoader {

    private final ProductEntityRepository productEntityRepository;

    @PostConstruct
    public void setProducts() {
        final ProductEntity credit = ProductEntity
                .builder()
                .productName("credit")
                .isActive(true)
                .build();
        final ProductEntity account = ProductEntity
                .builder()
                .productName("account")
                .isActive(true)
                .build();
        final ProductEntity deposit = ProductEntity
                .builder()
                .productName("deposit")
                .isActive(true)
                .build();
        final ProductEntity creditCard = ProductEntity
                .builder()
                .productName("credit card")
                .isActive(true)
                .build();
        final ProductEntity leasing = ProductEntity
                .builder()
                .productName("leasing")
                .isActive(false)
                .build();
        final ProductEntity factoring = ProductEntity
                .builder()
                .productName("factoring")
                .isActive(true)
                .build();
        final ProductEntity escrowAccount = ProductEntity
                .builder()
                .productName("escrow account")
                .isActive(true)
                .build();
        final ProductEntity bankGuarantee = ProductEntity
                .builder()
                .productName("Bank guarantee")
                .isActive(false)
                .build();

        final List<ProductEntity> productList = List.of(credit, account, deposit, creditCard, escrowAccount, bankGuarantee, factoring, leasing);
        productEntityRepository.saveAllAndFlush(productList);
        log.info("products loaded");
    }
}
