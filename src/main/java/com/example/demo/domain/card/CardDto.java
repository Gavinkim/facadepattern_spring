package com.example.demo.domain.card;

import com.example.demo.common.PaymentType;
import com.example.demo.common.PaymentDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class CardDto extends PaymentDto {
    private String cardNumber;
    private String name;

    @Builder
    public CardDto(CardProjections projections) {
        this.name = projections.getName();
        this.cardNumber = projections.getCardNumber();
        this.type = PaymentType.CARD;
    }
}
