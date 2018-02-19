package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MoedaUtil {
	public static void MensagemErro(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
	}
}
