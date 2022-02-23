package davidkecskes.stateproject.service;

import davidkecskes.stateproject.dto.bid.BidRequestDTO;
import davidkecskes.stateproject.dto.bid.BidResponseDTO;

import java.util.List;

public interface BidService {

    Long createBid(BidRequestDTO bidDTO);

    BidResponseDTO updateBid(Long bidId, BidRequestDTO bidDTO);

    void deleteBid(Long bidId);

    List<BidResponseDTO> getAllBidsForProduct(Long marketId);

    List<BidResponseDTO> getAllBidsForUserAsBuyer(String userId);

    List<BidResponseDTO> getAllBidsForUserHistory(String userId);
}
