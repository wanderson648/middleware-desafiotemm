package com.temm.middleware_bff.api.response;

import com.temm.middleware_bff.api.request.CartaoCreditoDTO;

import java.math.BigDecimal;

public record CartaoCreditoResponseDTO(
        String numero,
        String mes,
        String ano,
        String cvv,
        BigDecimal saldo,
        String email
) {
    public CartaoCreditoResponseDTO(String email, CartaoCreditoDTO dto) {
        this(dto.numero(), dto.mes(), dto.ano(), dto.cvv(), dto.saldo(), email);
    }
}
