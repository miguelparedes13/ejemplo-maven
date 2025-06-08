package com.infoloxa.catequesis.vistas;

import java.io.IOException;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private static final long serialVersionUID = 1L;

    private String usuario;
    private String clave;
    private boolean autenticado;

    public String ingresar() {
        if ("admin".equals(usuario) && "admin".equals(clave)) {
            autenticado = true;
            return "/pages/catequesis/index.xhtml?faces-redirect=true";
        } else {
            String msg = ResourceBundle.getBundle("MessageResources").getString("login_incorrecto");
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
            return null;
        }
    }

    public void cerrarSesion() throws IOException {
        autenticado = false;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/pages/login.xhtml");
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
