package com.example.demo.domain.card;

import com.example.demo.common.PaymentDto;
import com.example.demo.common.PaymentType;
import com.example.demo.common.SearchDto;
import com.example.demo.domain.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardService implements PaymentService {

    private final CardRepository cardRepository;

    @Override
    public PaymentType getServiceType() {
        return PaymentType.CARD;
    }

    @Override
    public List<? extends PaymentDto> getList(SearchDto searchDto) {
        List<CardProjections> cardProjections = cardRepository.findByName(searchDto.getSearchName(), CardProjections.class);

        return cardProjections.stream()
                .map(p->CardDto.builder()
                        .projections(p)
                        .build())
                .collect(Collectors.toList());
    }
}
