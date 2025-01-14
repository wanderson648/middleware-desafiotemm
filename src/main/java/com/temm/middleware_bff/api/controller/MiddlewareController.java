package com.temm.middleware_bff.api.controller;

import com.temm.middleware_bff.api.request.AutenticaUsuarioRequestDTO;
import com.temm.middleware_bff.api.request.CartaoCreditoDTO;
import com.temm.middleware_bff.api.request.TransacaoDTO;
import com.temm.middleware_bff.api.request.UsuarioDTO;
import com.temm.middleware_bff.api.response.AutenticaUsuarioResponseDTO;
import com.temm.middleware_bff.api.response.CartaoCreditoResponseDTO;
import com.temm.middleware_bff.api.response.TransacaoResponseDTO;
import com.temm.middleware_bff.api.response.UsuarioResponseDTO;
import com.temm.middleware_bff.business.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/middleware")
@SecurityRequirement(name = "bearerAuth")
public class MiddlewareController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(tags = "Usuário", summary = "Cadastrar Usuário", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cadastro realizado com sucesso")
    })
    @PostMapping("/users")
    public ResponseEntity<UsuarioResponseDTO> createUser(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.createUser(usuarioDTO));
    }

    @Operation(tags = "Autenticação", summary = "Autenticar Usuário", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Autenticação realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "email/password incorretos")
    })
    @PostMapping("/auth")
    public ResponseEntity<AutenticaUsuarioResponseDTO> authUser(@RequestBody AutenticaUsuarioRequestDTO autenticaUsuarioRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.autentica(autenticaUsuarioRequestDTO));
    }

    @Operation(tags = "Cartões", summary = "Cadastrar Cartão", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "email não encontrado"),
            @ApiResponse(responseCode = "403", description = "Não autorizado a realizar a operação")
    })
    @PostMapping("/cards")
    public ResponseEntity<CartaoCreditoResponseDTO> createCreditCard(@RequestParam String email, @RequestBody CartaoCreditoDTO cartaoCreditoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.createCreditCard(email, cartaoCreditoDTO));
    }

    @Operation(tags = "Cartões", summary = "Lista Cartões", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Não autorizado a realizar a operação")
    })
    @GetMapping("/cards")
    public ResponseEntity<List<CartaoCreditoResponseDTO>> listCreditCards() {
        return ResponseEntity.ok().body(usuarioService.listCreditCards());
    }

    @Operation(tags = "Transações", summary = "Realizar Transacão", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "email não encontrado"),
            @ApiResponse(responseCode = "403", description = "Não autorizado a realizar a operação")
    })
    @PostMapping("/transactions")
    public ResponseEntity<TransacaoResponseDTO> createTransaction(@RequestParam String email, @RequestBody TransacaoDTO transacaoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.createTransaction(email, transacaoDTO));
    }

    @Operation(tags = "Transações", summary = "Lista Transações", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Não autorizado a realizar a operação")
    })
    @GetMapping("/transactions")
    public ResponseEntity<List<TransacaoResponseDTO>> listTransactions() {
        return ResponseEntity.ok().body(usuarioService.listTransaction());
    }
}
