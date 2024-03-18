package co.samtel.usuario.utils;

import co.samtel.usuario.entity.Usuario;
import co.samtel.usuario.gen.type.UsuarioTypeInput;
import co.samtel.usuario.gen.type.UsuarioTypeResponse;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class UsuarioMapper {
    public Usuario usuarioTypeToEntity(UsuarioTypeInput usuarioType) {
        return new ModelMapper().map(usuarioType, Usuario.class);
    }

    public UsuarioTypeResponse usuarioEntityToType (Usuario usuario){
        return new ModelMapper().map(usuario, UsuarioTypeResponse.class);
    }

    //---------------------Mapeo para listar todos los usuarios-------------------------------------
    public List<UsuarioTypeResponse> usuariosTypeListEntityToTypeResponse(List<Usuario> usuarios){
        List<UsuarioTypeResponse> responses = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            UsuarioTypeResponse response = new ModelMapper().map(usuario, UsuarioTypeResponse.class);
            responses.add(response);
        }
        return responses;
    }

}