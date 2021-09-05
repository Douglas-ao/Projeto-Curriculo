package br.unipar.ambientes.aplicacao.enums;

public enum UfEnum {
	
	AC("AC"),
	AL("AL"),
	AP("AP"),
	AM("AM"),
	BA("BA"),
	CE("CE"),
	ES("ES"),
	GO("GO"),
	MA("MA"),
	MT("MT"),
	MS("MS"),
	MG("MG"),
	PA("PA"),
	PB("PB"),
	PR("PR"),
	PE("PE"),
	PI("PI"),
	RJ("RJ"),
	RN("RN"),
	RS("RS"),
	RO("RO"),
	RR("RR"),
	SC("SC"),
	SP("SP"),
	SE("SE"),
	TO("TO");
	
	private UfEnum(String sigla){
		this.sigla = sigla;
	}
	
	private String sigla;
	
	
	public String getDescricao() {
		return sigla;
	}
}