package app.entity;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O Nome é obrigatório")
    @Pattern(regexp = "^[A-Z][a-z]+( [A-Z][a-z]+)+$",
    message = "Nome deve conter pelo menos duas palavras")
    private String nome;

    @Min(value = 1, message = "A Idade não pode ser menor que 1!")
    private int idade;

    @NotBlank(message = "Endereço é obrigatório!")
    private String endereco;

    @Email(message = "Email inválido!")
    private String email;

    @CPF(message = "CPF é inválido!")
    private String cpf;

    @Pattern(regexp = "^\\d{5}-\\d{3}$",
    message = "CEP deve seguir o padrão XXXXX-XXX")
    private String cep;

    @Pattern(regexp = "^\\(\\d{2}\\) \\d{4}-\\d{4}|\\(\\d{2}\\) \\d{5}-\\d{4}$",
    message = "Telefone é inválido!")
    private String telefone;

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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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


}
