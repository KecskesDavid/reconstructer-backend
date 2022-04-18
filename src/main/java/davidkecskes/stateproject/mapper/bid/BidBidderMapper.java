package davidkecskes.stateproject.mapper.bid;

import davidkecskes.stateproject.dto.bid.BidRequestDTO;
import davidkecskes.stateproject.mapper.Mapper;
import davidkecskes.stateproject.model.BidBidder;
import davidkecskes.stateproject.model.Bids;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BidBidderMapper implements Mapper<BidRequestDTO, BidBidder> {
    @Override
    public BidBidder convertOne(BidRequestDTO bidRequestDTO) {
        return new BidBidder(
                bidRequestDTO.getTimestamp(),
                bidRequestDTO.getPrice(),
                bidRequestDTO.getQuantity(),
                bidRequestDTO.getMessage(),
                bidRequestDTO.getBidType()
        );
    }

    @Override
    public List<BidBidder> convertList(List<BidRequestDTO> bidRequestDTOs) {
        return bidRequestDTOs.stream().map(this::convertOne).collect(Collectors.toList());
    }
}
