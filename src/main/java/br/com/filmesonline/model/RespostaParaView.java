package br.com.filmesonline.model;

public class RespostaParaView {

	private boolean sucesso;
	private Object objeto;
	private String mensagem;

	public RespostaParaView(boolean sucesso, Object objeto, String mensagem) {
		this.sucesso = sucesso;
		this.objeto = objeto;
		this.mensagem = mensagem;
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

}
