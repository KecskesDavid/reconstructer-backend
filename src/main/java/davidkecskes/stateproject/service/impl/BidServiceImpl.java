package davidkecskes.stateproject.service.impl;

import davidkecskes.stateproject.dto.bid.BidRequestDTO;
import davidkecskes.stateproject.dto.bid.BidResponseDTO;
import davidkecskes.stateproject.exception.DataNotFoundException;
import davidkecskes.stateproject.mapper.bid.BidBidderMapper;
import davidkecskes.stateproject.mapper.bid.BidDTOMapper;
import davidkecskes.stateproject.mapper.bid.BidEntityMapper;
import davidkecskes.stateproject.mapper.bid.BidOwnerMapper;
import davidkecskes.stateproject.model.*;
import davidkecskes.stateproject.repository.*;
import davidkecskes.stateproject.service.BidService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BidServiceImpl implements BidService {

    private BidRepository bidRepository;
    private BidBidderRepository bidBidderRepository;
    private BidOwnerRepository bidOwnerRepository;

    private BidStatusRepository bidStatusRepository;
    private UserRepository userRepository;
    private MarketRepository marketRepository;

    private BidDTOMapper bidDTOMapper;
    private BidOwnerMapper bidOwnerMapper;
    private BidBidderMapper bidBidderMapper;

    @Override
    public Long createBid(BidRequestDTO bidDTO) {
        Markets market = marketRepository.findById(bidDTO.getMarketId()).orElseThrow(() -> new DataNotFoundException("No market was found with the id: " + bidDTO.getMarketId()));
        Users owner = userRepository.findById(bidDTO.getOwnerId()).orElseThrow(() -> new DataNotFoundException("No owner was found with the id: " + bidDTO.getOwnerId()));
        Users buyer = userRepository.findById(bidDTO.getBidderId()).orElseThrow(() -> new DataNotFoundException("No buyer was found with the id: " + bidDTO.getBidderId()));

        BidOwner bidOwner = bidOwnerMapper.convertOne(bidDTO);
        BidBidder bidBidder = bidBidderMapper.convertOne(bidDTO);

        bidOwner.setMarkets(market);
        bidOwner.setOwner(owner);
        bidOwner.setBidder(buyer);
        bidOwner.setTimestamp(Instant.now().getEpochSecond());

        bidBidder.setMarkets(market);
        bidBidder.setOwner(owner);
        bidBidder.setBidder(buyer);
        bidBidder.setTimestamp(Instant.now().getEpochSecond());

        bidBidderRepository.save(bidBidder);
        return bidOwnerRepository.save(bidOwner).getId();
    }

//    @Override
//    public BidResponseDTO updateBid(Long bidId, BidRequestDTO bidDTO) {
//        Bids bid = bidRepository.findById(bidId).orElseThrow(() -> new DataNotFoundException("No bid was found with the id: " + bidId));
////        BidStatuses bidStatus = bidStatusRepository.findById(bidDTO.getBidStatusId()).orElseThrow(() -> new DataNotFoundException("No bid was found with the id: " + bidId));
//
////        bid.setBidStatuses(bidStatus);
//        bid.setTimestamp(Instant.now().getEpochSecond());
//        bid.setPrice(bidDTO.getPrice());
//        bid.setQuantity(bidDTO.getQuantity());
//
//        bidRepository.save(bid);
//
//        return bidDTOMapper.convertOne(bid);
//    }

    @Override
    public void deleteBid(Long bidId) {
        bidRepository.deleteById(bidId);
    }

//    @Override
//    public List<BidResponseDTO> getAllBidsForProduct(Long marketId) {
//        return bidDTOMapper.convertList(
//                bidRepository.findAll()
//                        .stream()
//                        .filter(bid -> bid.getMarkets().getProducts().getId().equals(marketId))
//                        .collect(Collectors.toList())
//        );
//    }
//
//    @Override
//    public List<BidResponseDTO> getAllBidsForUserAsBuyer(String userId) {
//        return bidDTOMapper.convertList(
//                bidRepository.findAll()
//                        .stream()
//                        .filter(bid -> bid.getBuyer().getId().equals(userId))
//                        .collect(Collectors.toList())
//        );
//    }
//
//    @Override
//    public List<BidResponseDTO> getAllBidsForUserHistory(String userId) {
//        return bidDTOMapper.convertList(
//                bidRepository.findAll()
//                        .stream()
//                        .filter(bid -> bid.getBuyer().getId().equals(userId)
//                                && bid.getBidStatuses().getId().equals(bidStatusRepository.getHistoryStatusId()))
//                        .collect(Collectors.toList())
//        );
//    }

    @Override
    public List<BidResponseDTO> getProductBidHistoryForABidder(String bidderId, Long marketId) {
        return bidDTOMapper.convertBidderList(
            bidBidderRepository.findAll()
                    .stream()
                    .filter(bid -> bid.getBidder().getId().equals(bidderId)
                            && bid.getMarkets().getId().equals(marketId))
                    .collect(Collectors.toList())
        );
    }
}
