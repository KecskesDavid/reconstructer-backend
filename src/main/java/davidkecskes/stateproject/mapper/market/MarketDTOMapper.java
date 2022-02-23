package davidkecskes.stateproject.mapper.market;

import davidkecskes.stateproject.dto.MarketDTOResponse;
import davidkecskes.stateproject.dto.ProductCategoryDTO;
import davidkecskes.stateproject.dto.ProductDTO;
import davidkecskes.stateproject.dto.UserDTO;
import davidkecskes.stateproject.mapper.Mapper;
import davidkecskes.stateproject.model.Markets;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MarketDTOMapper implements Mapper<Markets, MarketDTOResponse> {
    @Override
    public MarketDTOResponse convertOne(Markets market) {
        UserDTO userDTO = new UserDTO(
                market.getUsers().getId(),
                market.getUsers().getName(),
                market.getUsers().getEmail(),
                market.getUsers().getPhoneNumber()
        );
        ProductDTO productDTO = new ProductDTO(
                market.getProducts().getId(),
                new ProductCategoryDTO(
                        market.getProducts().getCategory().getId(),
                        market.getProducts().getCategory().getName()
                ),
                market.getProducts().getName(),
                market.getProducts().getDetails(),
                market.getProducts().getCreatedDate(),
                market.getProducts().isAvailable()
        );

        return new MarketDTOResponse(
                market.getId(),
                userDTO,
                productDTO,
                market.getQuantity(),
                market.getPrice(),
                market.getPlacedDate()
        );
    }

    @Override
    public List<MarketDTOResponse> convertList(List<Markets> markets) {
        return markets.stream().map(this::convertOne).collect(Collectors.toList());
    }
}
