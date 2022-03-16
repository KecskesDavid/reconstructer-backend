package davidkecskes.stateproject.mapper.bid;

import davidkecskes.stateproject.dto.MarketDTOResponse;
import davidkecskes.stateproject.dto.ProductCategoryDTO;
import davidkecskes.stateproject.dto.ProductDTO;
import davidkecskes.stateproject.dto.UserDTO;
import davidkecskes.stateproject.dto.bid.BidResponseDTO;
import davidkecskes.stateproject.dto.bid.BidStatusDTO;
import davidkecskes.stateproject.mapper.Mapper;
import davidkecskes.stateproject.model.Bids;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BidDTOMapper implements Mapper<Bids, BidResponseDTO> {
    @Override
    public BidResponseDTO convertOne(Bids bid) {
        return new BidResponseDTO(
                bid.getId(),
                new MarketDTOResponse(
                        bid.getMarkets().getId(),
                        new UserDTO(
                                bid.getMarkets().getUsers().getId(),
                                bid.getMarkets().getUsers().getName(),
                                bid.getMarkets().getUsers().getEmail(),
                                bid.getMarkets().getUsers().getPhoneNumber(),
                                bid.getMarkets().getUsers().getProfilePicture()
                        ),
                        new ProductDTO(
                                bid.getMarkets().getProducts().getId(),
                                new ProductCategoryDTO(
                                        bid.getMarkets().getProducts().getCategory().getId(),
                                        bid.getMarkets().getProducts().getCategory().getName()
                                ),
                                bid.getMarkets().getProducts().getName(),
                                bid.getMarkets().getProducts().getDetails(),
                                bid.getMarkets().getProducts().getCreatedDate(),
                                bid.getMarkets().getProducts().isAvailable()
                        ),
                        bid.getMarkets().getQuantity(),
                        bid.getMarkets().getPrice(),
                        bid.getMarkets().getPlacedDate()
                ),
                new UserDTO(
                        bid.getOwner().getId(),
                        bid.getOwner().getName(),
                        bid.getOwner().getEmail(),
                        bid.getOwner().getPhoneNumber(),
                        bid.getOwner().getProfilePicture()
                ),
                new UserDTO(
                        bid.getBuyer().getId(),
                        bid.getBuyer().getName(),
                        bid.getBuyer().getEmail(),
                        bid.getBuyer().getPhoneNumber(),
                        bid.getBuyer().getProfilePicture()
                ),
                new BidStatusDTO(
                        bid.getBidStatuses().getId(),
                        bid.getBidStatuses().getName()
                ),
                bid.getTimestamp(),
                bid.getPrice(),
                bid.getQuantity()
        );
    }

    @Override
    public List<BidResponseDTO> convertList(List<Bids> bids) {
        return bids.stream().map(this::convertOne).collect(Collectors.toList());
    }
}
