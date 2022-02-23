package davidkecskes.stateproject.mapper.bid;

import davidkecskes.stateproject.dto.bid.BidRequestDTO;
import davidkecskes.stateproject.mapper.Mapper;
import davidkecskes.stateproject.model.Bids;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BidEntityMapper implements Mapper<BidRequestDTO, Bids> {
    @Override
    public Bids convertOne(BidRequestDTO bidRequestDTO) {
        return new Bids(
                bidRequestDTO.getTimestamp(),
                bidRequestDTO.getPrice(),
                bidRequestDTO.getQuantity()
        );
    }

    @Override
    public List<Bids> convertList(List<BidRequestDTO> bidRequestDTOs) {
        return bidRequestDTOs.stream().map(this::convertOne).collect(Collectors.toList());
    }
}
