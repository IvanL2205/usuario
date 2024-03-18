package co.samtel.usuario.controller;

import co.samtel.usuario.gen.contract.V1UsuarioApi;
import co.samtel.usuario.gen.type.UsuarioTypeInput;
import co.samtel.usuario.gen.type.UsuarioTypeResponse;
import co.samtel.usuario.service.impl.UsuarioServiceImpl;
import co.samtel.usuario.utils.ApplicationException;
import co.samtel.usuario.gen.type.UsuarioTypeInput;
import jakarta.inject.Inject;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;
import static co.samtel.usuario.constant.Constant.ERROR_SERVICIO;

public class UsuarioController implements V1UsuarioApi {
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

    @Inject
    UsuarioServiceImpl usuarioServiceImpl;

    @Override
    public List<UsuarioTypeResponse> crearUsuario(UsuarioTypeInput usuarioTypeInput){
        LOG.info("Inicia crearUsuarioController");
        try {
            //Object usuarioType = usuarioServiceImpl.crearUsuario(usuarioTypeInput);
            //LOG.info("Termina crearUsuario");
            return usuarioServiceImpl.crearUsuario(usuarioTypeInput);
        }catch (ApplicationException e) {
            LOG.error("Se identifica error ");
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());

        }
        }

    @Override
    public List<UsuarioTypeResponse> editarUsuario(Integer idtblUser, UsuarioTypeInput usuarioTypeInput) {
        return usuarioServiceImpl.editarUsuario(idtblUser, usuarioTypeInput);
    }

    @Override
    public void eliminarUsuario(Integer idtblUser) {
        usuarioServiceImpl.eliminarUsuario(idtblUser);

    }

    @Override
    public List<UsuarioTypeResponse> listarTodosLosUsuario() {
        return usuarioServiceImpl.listarUsuarios();
    }

    @Override
    public List<UsuarioTypeResponse> listarUsuario(Integer idtblUser) {

        return usuarioServiceImpl.listarUsuario(idtblUser);
    }



}

