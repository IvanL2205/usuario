package co.samtel.usuario.service.impl;

import co.samtel.usuario.controller.UsuarioController;
import co.samtel.usuario.dao.UsuarioDao;
import co.samtel.usuario.entity.Usuario;
import co.samtel.usuario.gen.type.UsuarioTypeInput;
import co.samtel.usuario.gen.type.UsuarioTypeResponse;
import co.samtel.usuario.utils.ApplicationException;
import co.samtel.usuario.utils.UsuarioMapper;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static co.samtel.usuario.constant.Constant.ERROR_SERVICIO;
@ApplicationScoped
public class UsuarioServiceImpl {
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);
    @Inject
    UsuarioMapper usuarioMapper;
    @Inject
    UsuarioDao usuarioDao;

    @Transactional
    public List<UsuarioTypeResponse> crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia crear usuario");
        UsuarioTypeResponse response;
        try {
            Usuario usuario = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
            usuarioDao.persist(usuario);
            response = usuarioMapper.usuarioEntityToType(usuario);
            LOG.info("Finaliza crear usuario");
        }catch (ApplicationException e){
            LOG.error("Error al crear usuario");
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
        return Collections.singletonList(response);
    }

    @Transactional
    public List<UsuarioTypeResponse> listarUsuario(Integer idtblUser){
        LOG.info("Inicia listarUsuarioImpl");
        UsuarioTypeResponse response;
        try {
            Usuario user = usuarioDao.findById(idtblUser.longValue());
            response = usuarioMapper.usuarioEntityToType(user);
            LOG.info("Finaliza listar usuario por id");

        }catch (ApplicationException e){
            LOG.error("Se presento un error al listar usuario por id"+ e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
        return  Collections.singletonList(response);
    }

    @Transactional
    public void eliminarUsuario (Integer id){
        LOG.info("Se inicia la eliminacion de dato");
        try{
            usuarioDao.deleteById(Long.valueOf(id));
            LOG.info("Se finaliza la eliminacion de dato");
        }catch (ApplicationException e){
            LOG.error("Se presento un error al listar usuario por id"+ e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
    }

    @Transactional
    public List<UsuarioTypeResponse> editarUsuario(Integer idtblUser, UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia edicion del usuario");
        UsuarioTypeResponse response;
        try{
            Usuario usuario = usuarioDao.findById(idtblUser.longValue());
            Usuario usuarioCambio = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);

            usuario.setName(usuarioCambio.getName());
            usuario.setLastname(usuarioCambio.getLastname());
            usuario.setCreateat(usuarioCambio.getCreateat());

            response = usuarioMapper.usuarioEntityToType(usuarioCambio);
            LOG.info("Finaliza listar usuario por id");


        }catch(ApplicationException e){
            LOG.error("Se presento un error al listar usuario por id"+ e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
        return  Collections.singletonList(response);
    }

    @Transactional
    public List<UsuarioTypeResponse> listarUsuarios() {
        LOG.info("Inicia listar usuarios");
        List<Usuario> usuarios;
        try {
            usuarios = usuarioDao.listAll();

            LOG.info("Finaliza listar usuarios");

        } catch (ApplicationException e) {
            LOG.error("Se presento un error al listar usuarios " + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
        return usuarioMapper.usuariosTypeListEntityToTypeResponse(usuarios);
    }
}
