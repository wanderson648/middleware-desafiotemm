package com.temm.middleware_bff.business;

import com.temm.middleware_bff.api.request.AutenticaUsuarioRequestDTO;
import com.temm.middleware_bff.api.request.CartaoCreditoDTO;
import com.temm.middleware_bff.api.request.TransacaoDTO;
import com.temm.middleware_bff.api.request.UsuarioDTO;
import com.temm.middleware_bff.api.response.AutenticaUsuarioResponseDTO;
import com.temm.middleware_bff.api.response.CartaoCreditoResponseDTO;
import com.temm.middleware_bff.api.response.TransacaoResponseDTO;
import com.temm.middleware_bff.api.response.UsuarioResponseDTO;
import com.temm.middleware_bff.infrastructure.clients.usuarioclient.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioClient usuarioClient;

    public UsuarioResponseDTO createUser(@RequestBody UsuarioDTO dto) {
        return usuarioClient.createUser(dto);
    }

    public AutenticaUsuarioResponseDTO autentica(@RequestBody AutenticaUsuarioRequestDTO autenticaUsuarioRequestDTO) {
        return usuarioClient.autentica(autenticaUsuarioRequestDTO);
    }

    public CartaoCreditoResponseDTO createCreditCard(
            @RequestParam String email, @RequestBody CartaoCreditoDTO dto) {
        return usuarioClient.createCreditCard(email, dto);
    }

    public List<CartaoCreditoResponseDTO> listCreditCards() {
        return usuarioClient.listCreditCards();
    }

    public TransacaoResponseDTO createTransaction(
            @RequestParam String email, @RequestBody TransacaoDTO dto) {
        return usuarioClient.createTransaction(email, dto);
    }

    public List<TransacaoResponseDTO> listTransaction() {
        return usuarioClient.listTransaction();
    }

}
