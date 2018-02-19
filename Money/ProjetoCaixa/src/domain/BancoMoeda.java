package domain;

public class BancoMoeda {
	private Long id;
	private String nome;
	private String codigo;
	private String sinal;
	private Double valor;
	private Double valorR;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSinal() {
		return sinal;
	}

	public void setSinal(String sinal) {
		this.sinal = sinal;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorR() {
		return valorR;
	}

	public void setValorR(Double valorR) {
		this.valorR = valorR;
	}

	@Override
	public String toString() {
		String saida = nome + " " + codigo + " " + sinal + " " + valor + " " + valorR;
		return saida;
	}
}
