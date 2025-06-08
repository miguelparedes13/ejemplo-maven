package com.infoloxa.catequesis.vistas;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.ejb.EJB;
import com.infoloxa.catequesis.logica.dao.UsuarioDao;
import com.infoloxa.catequesis.model.Usuarios;

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB(lookup = "java:global/logica-1.0/UsuarioDaoImpl!com.infoloxa.catequesis.logica.dao.UsuarioDao")
    private UsuarioDao usuarioDao;

    private String usuario;
    private String clave;
    private boolean autenticado;

    public String ingresar() {
        List<Usuarios> usuarios = usuarioDao.buscarUsuario(usuario, clave);
        if (!usuarios.isEmpty()) {
            autenticado = true;
            return "/pages/catequesis/index.xhtml?faces-redirect=true";
        }
        String msg = ResourceBundle.getBundle("MessageResources").getString("login_incorrecto");
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
        return null;
    }

    public void cerrarSesion() throws IOException {
        autenticado = false;
        FacesContext faces = FacesContext.getCurrentInstance();
        faces.getExternalContext().invalidateSession();
        String loginPage = faces.getExternalContext().getRequestContextPath()
                + "/faces/pages/login.xhtml";
        faces.getExternalContext().redirect(loginPage);
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
