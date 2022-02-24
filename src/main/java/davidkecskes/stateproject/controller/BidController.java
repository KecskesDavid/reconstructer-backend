package davidkecskes.stateproject.controller;

import davidkecskes.stateproject.dto.bid.BidRequestDTO;
import davidkecskes.stateproject.exception.DataNotFoundException;
import davidkecskes.stateproject.model.BidStatuses;
import davidkecskes.stateproject.model.ProductCategory;
import davidkecskes.stateproject.repository.BidStatusRepository;
import davidkecskes.stateproject.service.BidService;
import davidkecskes.stateproject.utils.ExceptionHandlerUtils;
import davidkecskes.stateproject.utils.ResponseBodyUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/bid")
@AllArgsConstructor
public class BidController {
    private BidService bidService;
    private BidStatusRepository bidStatusRepository;

    @PostConstruct
    private void saveBidStatuses() {
        if (!bidStatusRepository.existsById(0L)) bidStatusRepository.save(new BidStatuses(1L, "WAITING_FOR_OWNER"));
        if (!bidStatusRepository.existsById(1L)) bidStatusRepository.save(new BidStatuses(2L, "WAITING_FOR_BUYER"));
        if (!bidStatusRepository.existsById(2L)) bidStatusRepository.save(new BidStatuses(3L, "DECLINED"));
        if (!bidStatusRepository.existsById(3L)) bidStatusRepository.save(new BidStatuses(4L, "FINISHED"));
    }

    @PostMapping
    public ResponseEntity<?> createBid(@RequestBody BidRequestDTO bidRequestDTO) {
        try {
            Long bidId = bidService.createBid(bidRequestDTO);

            ResponseBodyUtil responseBodyUtil = new ResponseBodyUtil();
            responseBodyUtil.addToResponseBody("message", "Bid created successfully!");
            responseBodyUtil.addToResponseBody("id", String.valueOf(bidId.intValue()));

            return new ResponseEntity<>(responseBodyUtil.createResponseBody(), HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }

    @PostMapping(path = "/update/{bidId}")
    public ResponseEntity<?> updateBid(@PathVariable Long bidId, @RequestBody BidRequestDTO bidRequestDTO) {
        try {
            return new ResponseEntity<>(bidService.updateBid(bidId, bidRequestDTO), HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }

    @PostMapping(path = "/delete/{bidId}")
    public ResponseEntity<?> deleteBid(@PathVariable Long bidId) {
        try {
            bidService.deleteBid(bidId);

            ResponseBodyUtil responseBodyUtil = new ResponseBodyUtil();
            responseBodyUtil.addToResponseBody("message", "Bid deleted successfully!");
            responseBodyUtil.addToResponseBody("id", String.valueOf(bidId.intValue()));

            return new ResponseEntity<>(responseBodyUtil.createResponseBody(), HttpStatus.OK);
        } catch (Exception e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }

    @GetMapping(path = "/product/{bidId}")
    public ResponseEntity<?> getAllBidsForProduct(@PathVariable Long bidId) {
        try {
            return new ResponseEntity<>(bidService.getAllBidsForProduct(bidId), HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }

    @GetMapping(path = "/buyer/{userId}")
    public ResponseEntity<?> getAllBidsForUserAsBuyer(@PathVariable String userId) {
        try {
            return new ResponseEntity<>(bidService.getAllBidsForUserAsBuyer(userId), HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }

    @GetMapping(path = "/history/{userId}")
    public ResponseEntity<?> getAllBidsForUserHistory(@PathVariable String userId) {
        try {
            return new ResponseEntity<>(bidService.getAllBidsForUserHistory(userId), HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }
}
