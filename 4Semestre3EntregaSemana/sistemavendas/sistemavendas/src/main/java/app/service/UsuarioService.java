package app.service;

import app.entity.Usuario;
import app.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class UsuarioService {

        @Autowired
        private UsuarioRepository usuarioRepository;

        // Método para criar um novo usuário
        public Usuario criarUsuario(Usuario usuario) {
            return usuarioRepository.save(usuario);
        }

        // Método para atualizar um usuário existente
        public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
            if (usuarioOptional.isPresent()) {
                Usuario usuario = usuarioOptional.get();
                usuario.setCpf(usuarioAtualizado.getCpf());
                usuario.setNome(usuarioAtualizado.getNome());
                usuario.setEmail(usuarioAtualizado.getEmail());
                return usuarioRepository.save(usuario);
            }
            return null; // Ou lance uma exceção personalizada
        }

        // Método para listar todos os usuários
        public List<Usuario> listarUsuarios() {
            return usuarioRepository.findAll();
        }

        // Método para obter um usuário pelo ID
        public Usuario obterUsuarioPorId(Long id) {
            return usuarioRepository.findById(id).orElse(null);
        }

        // Método para deletar um usuário pelo ID
        public void deletarUsuario(Long id) {
            usuarioRepository.deleteById(id);
        }
}