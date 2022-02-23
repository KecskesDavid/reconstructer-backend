package davidkecskes.stateproject.mapper.market;

import davidkecskes.stateproject.dto.MarketDTORequest;
import davidkecskes.stateproject.mapper.Mapper;
import davidkecskes.stateproject.model.Markets;
import davidkecskes.stateproject.model.ProductCategory;
import davidkecskes.stateproject.model.Products;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MarketEntityMapper implements Mapper<MarketDTORequest, Markets> {
    @Override
    public Markets convertOne(MarketDTORequest marketDTO) {
        return new Markets(
                null,
                new Products(
                        null,
                        new ProductCategory(
                                marketDTO.getProductDTO().getCategory().getId(),
                                marketDTO.getProductDTO().getCategory().getName()
                        ),
                        marketDTO.getProductDTO().getName(),
                        marketDTO.getProductDTO().getDetails(),
                        marketDTO.getProductDTO().getCreatedDate(),
                        true
                ),
                marketDTO.getQuantity(),
                marketDTO.getPrice()
        );
    }

    @Override
    public List<Markets> convertList(List<MarketDTORequest> marketDTOs) {
        return marketDTOs.stream().map(this::convertOne).collect(Collectors.toList());
    }
}
