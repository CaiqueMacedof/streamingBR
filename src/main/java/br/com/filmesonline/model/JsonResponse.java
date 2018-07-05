package br.com.filmesonline.model;

public class JsonResponse {

	private boolean sucesso;
	private Object objeto;
	private String mensagem;
	private String classeAlerta;

	public JsonResponse() {
	}

	public JsonResponse(boolean sucesso, Object objeto, String mensagem, String classeAlerta) {
		this.sucesso = sucesso;
		this.objeto = objeto;
		this.mensagem = mensagem;
		this.classeAlerta = classeAlerta;
	}

	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getClasseAlerta() {
		return classeAlerta;
	}

	public void setClasseAlerta(String classeAlerta) {
		this.classeAlerta = classeAlerta;
	}

}
