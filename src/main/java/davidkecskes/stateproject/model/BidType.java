package davidkecskes.stateproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum BidType {
    BIDDER_TO_OWNER_NEW_OFFER("BIDDER_TO_OWNER_NEW_OFFER"),
    BIDDER_TO_OWNER_DECLINED("BIDDER_TO_OWNER_DECLINED"),
    BIDDER_TO_OWNER_ACCEPTED("BIDDER_TO_OWNER_ACCEPTED"),
    OWNER_TO_BIDDER_NEW_OFFER("OWNER_TO_BIDDER_NEW_OFFER"),
    OWNER_TO_BIDDER_DECLINED("OWNER_TO_BIDDER_DECLINED"),
    OWNER_TO_BIDDER_ACCEPTED("OWNER_TO_BIDDER_ACCEPTED");

    private String value;

    private BidType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static BidType decode(final String code) {
        return Stream.of(BidType.values()).filter(targetEnum -> targetEnum.value.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
