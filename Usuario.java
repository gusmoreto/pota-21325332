import java.io.Serializable;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String sexo;
	private String endereco;
	private String cidade;
	private String email;
	private String telefone;

	public Usuario() {
	}

	public Usuario(String name, String sexo, String endereco, String cidade, String email, String telefone) {
		this.name = name;
		this.sexo = sexo;
		this.endereco = endereco;
		this.cidade = cidade;
		this.email = email;
		this.telefone = telefone;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String toString() {
		return "Nome = " + this.name + ", \n Sexo = " + this.sexo + ", \n Endereço = " + this.endereco
				+ ", \n Cidade = " + this.cidade + ", \n Email =  " + this.email + ", \n Telefone = " + this.telefone
				+ " \n -------------------------";
	}

	public int compareTo(Usuario usu){
		if(getName() == null || usu.getName() == null ){
			return 0;
		} 
		return getName().compareTo(usu.getName());


	}

}
