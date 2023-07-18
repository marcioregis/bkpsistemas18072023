package br.com.farmacia.domain;

public class Imoveis {
	private Long codigo;
	private String nome;
	private String tipo;
	private String endereco;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private String andar;
	private Double valoraluguel;
	private Double valoriptu;
	private Double valorcondominio;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}		
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
		
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getAndar() {
		return andar;
	}
	public void setAndar(String andar) {
		this.andar = andar;
	}
		
	public Double getValoraluguel() {
		return valoraluguel;
	}
	public void setValoraluguel(Double valoraluguel) {
		this.valoraluguel = valoraluguel;
	}	
	public Double getValorcondominio() {
		return valorcondominio;
	}
	public void setValorcondominio(Double valorcondominio) {
		this.valorcondominio = valorcondominio;
	}		
	public Double getValoriptu() {
		return valoriptu;
	}
	public void setValoriptu(Double valoriptu) {
		this.valoriptu = valoriptu;
	}
	
	
	@Override
	public String toString() {
		String saida = codigo + " - " + nome  ; 
		return saida;
	}
}
