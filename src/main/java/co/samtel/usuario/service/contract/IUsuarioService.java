package co.samtel.usuario.service.contract;


import co.samtel.usuario.gen.type.UsuarioTypeInput;
import co.samtel.usuario.gen.type.UsuarioTypeResponse;

import java.util.List;

public interface IUsuarioService {
    UsuarioTypeInput crearUsuario(UsuarioTypeInput usuarioTypeInput);
    List<UsuarioTypeResponse> editarUsuario(Integer idtblUser, UsuarioTypeInput usuarioTypeInput);
    List<UsuarioTypeResponse> listarUsuario(Integer idtblUser);
    void eliminarUsuario(Integer idtblUser);
    List<UsuarioTypeResponse> listarTodosLosUsuario();
}
