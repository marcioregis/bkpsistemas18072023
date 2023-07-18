package br.com.farmacia.domain;

public class Inquilinos {
private Long codigo;
private String nomeinq;
private String cpf;
private String rg;
//private Date datanasc;
private String profissao;
private String email;
private String endereco;
private String bairro;
private String cidade;
private String uf;
private String cep;
private String telefone;
private String celular;
private String enderecocom;
private String bairrocom;
private String cidadecom;
private String ufcom;
private String cepcom;
private String telefonecom;
private String celularcom;

private Imoveis imoveis = new Imoveis();

public Long getCodigo() {
	return codigo;
}
public void setCodigo(Long codigo) {
	this.codigo = codigo;
}

public String getNomeinq() {
	return nomeinq;	
}
public void setNomeinq(String nomeinq) {
	this.nomeinq = nomeinq;
}

public String getEndereco() {
	return endereco;	
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}

public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}
public String getRg() {
	return rg;
}
public void setRg(String rg) {
	this.rg = rg;
}
//public Date getDatanasc() {
//	return datanasc;
//}
//public void setDatanasc(Date datanasc) {
//	this.datanasc = datanasc;
//}
public String getProfissao() {
	return profissao;
}
public void setProfissao(String profissao) {
	this.profissao = profissao;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
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
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public String getCelular() {
	return celular;
}
public void setCelular(String celular) {
	this.celular = celular;
}
public String getEnderecocom() {
	return enderecocom;
}
public void setEnderecocom(String enderecocom) {
	this.enderecocom = enderecocom;
}
public String getBairrocom() {
	return bairrocom;
}
public void setBairrocom(String bairrocom) {
	this.bairrocom = bairrocom;
}
public String getCidadecom() {
	return cidadecom;
}
public void setCidadecom(String cidadecom) {
	this.cidadecom = cidadecom;
}
public String getUfcom() {
	return ufcom;
}
public void setUfcom(String ufcom) {
	this.ufcom = ufcom;
}
public String getCepcom() {
	return cepcom;
}
public void setCepcom(String cepcom) {
	this.cepcom = cepcom;
}
public String getTelefonecom() {
	return telefonecom;
}
public void setTelefonecom(String telefonecom) {
	this.telefonecom = telefonecom;
}
public String getCelularcom() {
	return celularcom;
}
public void setCelularcom(String celularcom) {
	this.celularcom = celularcom;
}

public Imoveis getImoveis() {
	return imoveis;
}
public void setImoveis(Imoveis imoveis) {
	this.imoveis = imoveis;
}
}
