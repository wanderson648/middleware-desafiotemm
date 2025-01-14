package com.temm.middleware_bff.infrastructure.clients.usuarioclient;

import com.temm.middleware_bff.api.request.AutenticaUsuarioRequestDTO;
import com.temm.middleware_bff.api.request.CartaoCreditoDTO;
import com.temm.middleware_bff.api.request.TransacaoDTO;
import com.temm.middleware_bff.api.request.UsuarioDTO;
import com.temm.middleware_bff.api.response.AutenticaUsuarioResponseDTO;
import com.temm.middleware_bff.api.response.CartaoCreditoResponseDTO;
import com.temm.middleware_bff.api.response.TransacaoResponseDTO;
import com.temm.middleware_bff.api.response.UsuarioResponseDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "usuario-api", url = "http://localhost:8083")
@SecurityRequirement(name = "bearerAuth")
public interface UsuarioClient {

    @PostMapping("/users")
    UsuarioResponseDTO createUser(@RequestBody UsuarioDTO dto);

    @PostMapping("/auth")
    AutenticaUsuarioResponseDTO autentica(@RequestBody AutenticaUsuarioRequestDTO autenticaUsuarioRequestDTO);

    @PostMapping("/cards")
    CartaoCreditoResponseDTO createCreditCard(
            @RequestParam String email, @RequestBody CartaoCreditoDTO dto);

    @GetMapping("/cards")
    List<CartaoCreditoResponseDTO> listCreditCards();

    @PostMapping("/transactions")
    TransacaoResponseDTO createTransaction(
            @RequestParam String email, @RequestBody TransacaoDTO dto);

    @GetMapping("/transactions")
    List<TransacaoResponseDTO> listTransaction();
}
