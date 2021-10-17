import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuscaCsv {
	private int contarCompara;
	

	private List<Usuario> list = new ArrayList<Usuario>();

	public void criaLista(String path) {

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = null;
			while ((line = br.readLine()) != null) {

				String[] campos = line.split(",");

				list.add(new Usuario(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5]

				));

			}

			

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public int pesquisaBinaria(String chave) {
		int inicio, fim, meio;

		inicio = 0;
		fim = list.size() - 1;
		contarCompara = 0;

		while (inicio <= fim) {
			meio = (inicio + fim) / 2;
			
			contarCompara++; 
			if (chave.equals(list.get(meio).getName())) {
				return meio;
			}
			contarCompara++; 
			if (chave.compareTo(list.get(meio).getName()) < 0) { 
				fim = meio - 1;
			} else {
				inicio = meio + 1;
			}
		}
		return -1;
	}

	public int getContarCompara() {
		return contarCompara;
	}

	public Usuario getUsuariobyindex(int index){
		return list.get(index);
	}

	public List<Usuario> getList() {
		return list;
	}

	public void setList(List<Usuario> list) {
		this.list = list;
	}

}
