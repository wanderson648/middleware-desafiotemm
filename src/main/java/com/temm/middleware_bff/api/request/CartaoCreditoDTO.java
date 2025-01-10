package com.temm.middleware_bff.api.request;

import java.math.BigDecimal;

public record CartaoCreditoDTO(
        String numero,
        String mes,
        String ano,
        String cvv,
        BigDecimal saldo
) {
}
