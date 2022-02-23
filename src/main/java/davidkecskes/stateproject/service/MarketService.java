package davidkecskes.stateproject.service;

import davidkecskes.stateproject.dto.MarketDTORequest;
import davidkecskes.stateproject.dto.MarketDTOResponse;

import java.util.List;

public interface MarketService {

    MarketDTOResponse getMarket(Long marketId);

    List<MarketDTOResponse> getAllMarkets();

    List<MarketDTOResponse> getMarketsByUser(String userId);

    List<MarketDTOResponse> getAllMarketsWithPaging(int offset, int pageSize);

    Long saveMarket(MarketDTORequest marketDTO);

    void updateMarket(Integer id, MarketDTORequest marketDTO);

    MarketDTOResponse getMarketDetails(Integer id);
}
