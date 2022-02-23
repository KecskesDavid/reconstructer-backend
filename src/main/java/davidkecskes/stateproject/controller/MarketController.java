package davidkecskes.stateproject.controller;

import davidkecskes.stateproject.dto.MarketDTORequest;
import davidkecskes.stateproject.exception.DataNotFoundException;
import davidkecskes.stateproject.service.MarketService;
import davidkecskes.stateproject.utils.ExceptionHandlerUtils;
import davidkecskes.stateproject.utils.ResponseBodyUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/market")
@AllArgsConstructor
public class MarketController {

    private final MarketService marketService;

    @PostMapping
    private ResponseEntity<?> saveMarket(@RequestBody MarketDTORequest marketDTO) {
        try {
            Long marketId = marketService.saveMarket(marketDTO);

            ResponseBodyUtil responseBodyUtil = new ResponseBodyUtil();
            responseBodyUtil.addToResponseBody("message", "Market saved successfully!");
            responseBodyUtil.addToResponseBody("id", String.valueOf(marketId.intValue()));

            return new ResponseEntity<>(responseBodyUtil.createResponseBody(), HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }

    @GetMapping(path = "/{marketId}")
    private ResponseEntity<?> getMarket(@PathVariable Long marketId) {
        try {
            return new ResponseEntity<>(marketService.getMarket(marketId), HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }

    @GetMapping()
    private ResponseEntity<?> getMarkets() {
        try {
            return new ResponseEntity<>(marketService.getAllMarkets(), HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }

    @GetMapping(path = "/user/{userId}")
    private ResponseEntity<?> getMarketsByUser(@PathVariable String userId) {
        try {
            return new ResponseEntity<>(marketService.getMarketsByUser(userId), HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }

    @GetMapping(path = "/{offset}/{pageSize}")
    private ResponseEntity<?> getMarketsPaging(@PathVariable Integer offset, @PathVariable Integer pageSize) {
        try {
            return new ResponseEntity<>(marketService.getAllMarketsWithPaging(offset, pageSize), HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }
}
