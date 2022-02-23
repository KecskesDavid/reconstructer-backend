package davidkecskes.stateproject.controller;

import davidkecskes.stateproject.dto.bid.BidRequestDTO;
import davidkecskes.stateproject.exception.DataNotFoundException;
import davidkecskes.stateproject.model.Bids;
import davidkecskes.stateproject.service.BidService;
import davidkecskes.stateproject.utils.ExceptionHandlerUtils;
import davidkecskes.stateproject.utils.ResponseBodyUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bid")
@AllArgsConstructor
public class BidController {

    private BidService bidService;

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
