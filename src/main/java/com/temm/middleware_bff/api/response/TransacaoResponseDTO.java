package com.temm.middleware_bff.api.response;

import com.temm.middleware_bff.api.request.TipoTransacao;
import com.temm.middleware_bff.api.request.TransacaoDTO;

import java.math.BigDecimal;

public record TransacaoResponseDTO(
        TipoTransacao tipoTransacao,
        BigDecimal valor,
        String email
) {
        public TransacaoResponseDTO(String email, TransacaoDTO dto) {
                this(dto.tipoTransacao(), dto.valor(), email);
        }
}
