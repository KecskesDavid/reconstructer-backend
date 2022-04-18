package davidkecskes.stateproject.mapper.bid;

import davidkecskes.stateproject.dto.bid.BidRequestDTO;
import davidkecskes.stateproject.mapper.Mapper;
import davidkecskes.stateproject.model.BidOwner;
import davidkecskes.stateproject.model.Bids;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BidOwnerMapper implements Mapper<BidRequestDTO, BidOwner> {
    @Override
    public BidOwner convertOne(BidRequestDTO bidRequestDTO) {
        return new BidOwner(
                bidRequestDTO.getTimestamp(),
                bidRequestDTO.getPrice(),
                bidRequestDTO.getQuantity(),
                bidRequestDTO.getMessage(),
                bidRequestDTO.getBidType()
        );
    }

    @Override
    public List<BidOwner> convertList(List<BidRequestDTO> bidRequestDTOs) {
        return bidRequestDTOs.stream().map(this::convertOne).collect(Collectors.toList());
    }
}
