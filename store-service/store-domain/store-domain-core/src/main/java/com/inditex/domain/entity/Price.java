package com.inditex.domain.entity;

import com.inditex.domain.valueobject.*;
import java.time.LocalDateTime;

public class Price extends AggregateRoot<PriceId>{
    private final BrandId brandId;
    private final Money price;
    private final Currency curr;
    private final ProductId productId;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final Integer priority;
    private final PriceList priceList;

    public BrandId getBrandId() {
        return brandId;
    }

    public Price compare(Price price2) {
        if(price2.getPriority().compareTo(this.getPriority())>0){
            return price2;
        }
        return this;
    }

    public Money getPrice() {
        return price;
    }

    public Currency getCurr() {
        return curr;
    }

    public ProductId getProductId() {
        return productId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Integer getPriority() {
        return priority;
    }

    public PriceList getPriceList() {
        return priceList;
    }

    private Price(Builder builder) {
        super.setId(builder.priceId);
        brandId = builder.brandId;
        price = builder.price;
        curr = builder.curr;
        productId = builder.productId;
        startDate = builder.startDate;
        endDate = builder.endDate;
        priority = builder.priority;
        priceList = builder.priceList;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private PriceId priceId;
        private BrandId brandId;
        private Money price;
        private Currency curr;
        private ProductId productId;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Integer priority;
        private PriceList priceList;

        private Builder() {
        }

        public Builder id(PriceId val) {
            priceId = val;
            return this;
        }

        public Builder brandId(BrandId val) {
            brandId = val;
            return this;
        }

        public Builder price(Money val) {
            price = val;
            return this;
        }

        public Builder curr(Currency val) {
            curr = val;
            return this;
        }

        public Builder productId(ProductId val) {
            productId = val;
            return this;
        }

        public Builder startDate(LocalDateTime val) {
            startDate = val;
            return this;
        }

        public Builder endDate(LocalDateTime val) {
            endDate = val;
            return this;
        }

        public Builder priority(Integer val) {
            priority = val;
            return this;
        }

        public Builder priceList(PriceList val) {
            priceList = val;
            return this;
        }

        public Price build() {
            return new Price(this);
        }
    }
}
