package com.temm.middleware_bff.api.request;

import java.math.BigDecimal;

public record TransacaoDTO(
        TipoTransacao tipoTransacao,
        BigDecimal valor
) {
}
