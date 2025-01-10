package com.temm.middleware_bff.infrastructure.clients.usuarioclient;

import com.temm.middleware_bff.api.request.AutenticaUsuarioRequestDTO;
import com.temm.middleware_bff.api.request.CartaoCreditoDTO;
import com.temm.middleware_bff.api.request.TransacaoDTO;
import com.temm.middleware_bff.api.request.UsuarioDTO;
import com.temm.middleware_bff.api.response.CartaoCreditoResponseDTO;
import com.temm.middleware_bff.api.response.TransacaoResponseDTO;
import com.temm.middleware_bff.api.response.UsuarioResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "usuario-api", url = "localhost:8080")
public interface UsuarioClient {

    @PostMapping("/users")
    ResponseEntity<UsuarioResponseDTO> createUser(@RequestBody UsuarioDTO dto);

    @PostMapping("/auth")
    ResponseEntity<Object> autentica(@RequestBody AutenticaUsuarioRequestDTO autenticaUsuarioRequestDTO);

    @PostMapping("/cards")
    ResponseEntity<CartaoCreditoResponseDTO> createCreditCard(
            @RequestParam String email, @RequestBody CartaoCreditoDTO dto);

    @GetMapping("/cards")
    ResponseEntity<List<CartaoCreditoResponseDTO>> listCreditCards();

    @PostMapping("/transactions")
    ResponseEntity<TransacaoResponseDTO> createTransaction(
            @RequestParam String email, @RequestBody TransacaoDTO dto);

    @GetMapping("/transactions")
    ResponseEntity<List<TransacaoResponseDTO>> listTransaction();
}
