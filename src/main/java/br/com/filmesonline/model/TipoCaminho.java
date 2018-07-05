package br.com.filmesonline.model;

public enum TipoCaminho {
	IMG("/resources/img/"), WORKSPACE(
			"C:\\Users\\CaiqueMacedo\\eclipse-workspace\\filmesonline\\src\\main\\webapp\\resources\\img\\");

	private String nome;

	TipoCaminho(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

}
