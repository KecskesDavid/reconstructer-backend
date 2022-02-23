package davidkecskes.stateproject.service.impl;

import davidkecskes.stateproject.dto.MarketDTORequest;
import davidkecskes.stateproject.dto.MarketDTOResponse;
import davidkecskes.stateproject.exception.DataNotFoundException;
import davidkecskes.stateproject.mapper.market.MarketDTOMapper;
import davidkecskes.stateproject.mapper.market.MarketEntityMapper;
import davidkecskes.stateproject.model.Markets;
import davidkecskes.stateproject.model.ProductCategory;
import davidkecskes.stateproject.model.Users;
import davidkecskes.stateproject.repository.MarketRepository;
import davidkecskes.stateproject.repository.ProductCategoryRepository;
import davidkecskes.stateproject.repository.ProductRepository;
import davidkecskes.stateproject.repository.UserRepository;
import davidkecskes.stateproject.service.MarketService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class MarketServiceImpl implements MarketService {

    private final MarketDTOMapper marketDTOMapper;
    private final MarketEntityMapper marketEntityMapper;

    private final MarketRepository marketRepository;
    private final UserRepository userRepository;

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public MarketDTOResponse getMarket(Long marketId) {
        return marketDTOMapper.convertOne(
                marketRepository.findById(marketId).orElseThrow(() ->
                        new DataNotFoundException("No market was found with the id: " + marketId)
                )
        );
    }

    @Override
    public List<MarketDTOResponse> getAllMarkets() {
        return marketDTOMapper.convertList(marketRepository.findAll());
    }

    public List<MarketDTOResponse> getMarketsByUser(String userId) {
        return marketDTOMapper.convertList(marketRepository.findByUserId(userId));
    }

    @Override
    public List<MarketDTOResponse> getAllMarketsWithPaging(int offset, int pageSize) {
        Page<Markets> marketsPage = marketRepository.findAll(PageRequest.of(offset, pageSize));

        return marketDTOMapper.convertList(marketsPage.toList());
    }

    @Override
    public Long saveMarket(MarketDTORequest marketDTO) {
        Markets market = marketEntityMapper.convertOne(marketDTO);
        Users user = userRepository.findById(
                marketDTO.getUserId()
        ).orElseThrow(() -> new DataNotFoundException("No user was found with the id: " + marketDTO.getUserId()));
        ProductCategory productCategory = productCategoryRepository.findById(
                marketDTO.getProductDTO().getCategory().getId()
        ).orElseThrow(() -> new DataNotFoundException("No product category was found with the id: " + marketDTO.getProductDTO().getCategory().getId()));

        market.getProducts().setCreatedDate(Instant.now().getEpochSecond());
        market.getProducts().setCategory(productCategory);
        Long productId = productRepository.save(market.getProducts()).getId();

        market.setUsers(user);
        market.getProducts().setId(productId);
        market.setPlacedDate(Instant.now().getEpochSecond());

        return marketRepository.save(market).getId();
    }

    @Override
    public void updateMarket(Integer id, MarketDTORequest marketDTO) {

    }

    @Override
    public MarketDTOResponse getMarketDetails(Integer id) {
        return null;
    }
}
