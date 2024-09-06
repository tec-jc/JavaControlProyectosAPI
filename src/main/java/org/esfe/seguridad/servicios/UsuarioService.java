package org.esfe.seguridad.servicios;

import org.esfe.seguridad.dtos.UsuarioLogin;
import org.esfe.seguridad.dtos.UsuarioRegistrar;
import org.esfe.seguridad.dtos.UsuarioToken;
import org.esfe.seguridad.modelos.Rol;
import org.esfe.seguridad.modelos.Usuario;
import org.esfe.seguridad.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private RolService rolService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public UsuarioToken login(UsuarioLogin loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getClave()));
        Usuario usuario = userRepository.findByLogin(loginRequest.getLogin()).orElseThrow();
        String token = jwtService.getToken(usuario);
        return UsuarioToken.builder()
                .token(token)
                .build();
    }

    public UsuarioToken registro(UsuarioRegistrar registroRequest) {
        Usuario usuario = Usuario.builder()
                .nombre(registroRequest.getNombre())
                .apellido(registroRequest.getApellido())
                .telefono(registroRequest.getTelefono())
                .login(registroRequest.getLogin())
                .clave(passwordEncoder.encode(registroRequest.getClave()))
                .rol(rolService.obtenerPorId(registroRequest.getRolId()))
                .build();

        userRepository.save(usuario);

        return UsuarioToken.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }
}