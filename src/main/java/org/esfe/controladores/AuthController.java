package org.esfe.controladores;

import org.esfe.seguridad.dtos.UsuarioLogin;
import org.esfe.seguridad.dtos.UsuarioRegistrar;
import org.esfe.seguridad.dtos.UsuarioToken;
import org.esfe.seguridad.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<UsuarioToken> login(@RequestBody UsuarioLogin loginRequest){
        return ResponseEntity.ok(usuarioService.login(loginRequest));
    }

    @PostMapping("/registro")
    public ResponseEntity<UsuarioToken> registro(@RequestBody UsuarioRegistrar registroRequest){
        return ResponseEntity.ok(usuarioService.registro(registroRequest));
    }
}