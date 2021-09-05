package br.unipar.ambientes.aplicacao.enums;

public enum EstadoCivilEnum {

	SOLTEIRO ("Solteiro(a)"),
	CASADO ("Casado(a)"),
	DIVORCIADO ("Divorciado(a)"),
	VIUVO ("Viuvo(a)"),
	UNIAO_ESTAVEL("Uni�o Estavel");
	
	private String descricao;

	private EstadoCivilEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
