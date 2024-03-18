package co.samtel.usuario.dao;

import co.samtel.usuario.entity.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioDao implements PanacheRepository<Usuario>{
}
