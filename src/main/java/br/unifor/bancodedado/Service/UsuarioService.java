package br.unifor.bancodedado.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

import br.unifor.bancodedado.model.Usuario;
import br.unifor.bancodedado.DTO.UsuarioDTO;
import br.unifor.bancodedado.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario salvar(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome);
        usuario.setEmail(dto.email);
        usuario.setMatricula(dto.matricula);
        usuario.setSenha(passwordEncoder.encode(dto.senha));
        usuario.setAdmin(dto.isAdmin);
        return usuarioRepo.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepo.findAll();
    }
}
