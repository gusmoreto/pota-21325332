//Augusto Moreto Barros - 21325332 
//Gabriel Stavik - 21339181
//Stephany de Paula Frageri - 21338745
//Ian Heski Maia - 21141409 
//Isabella Fagundes Barão - 21268610


import java.text.Normalizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Execute {

    public static String value = "À Á Â Ã Ä Å Æ Ç È É Ê Ë Ì Í Î Ï Ð Ñ Ò Ó Ô Õ Ö Ø Ù Ú Û Ü Ý Þ ß à á â ã ä å æ ç è é ê ë ì í î ï ð ñ ò ó ô õ ö ø ù ú û ü ý þ ÿ ";

    public static void main(String[] args) throws Exception {

        
        String path = "arquivoDados.csv";
        BuscaCsv csv = new BuscaCsv();

        csv.criaLista(path);

        for (Usuario usuario : csv.getList()) {
            usuario.setName(semAcento(usuario.getName()));

        }

        List<Usuario> usuarioOrdenados = csv.getList()
        .stream()
        .sorted(Comparator.comparing(Usuario::getName))
        .collect(Collectors.toList());
        
        csv.setList(usuarioOrdenados);

        Scanner leitura = new Scanner(System.in, "CP850");

        String entrada = null;
        entrada = leitura.nextLine();

        while (!entrada.toLowerCase().equals("exit")) {

            int index = csv.pesquisaBinaria(entrada);
            if (index >= 0) {
                Usuario user = csv.getUsuariobyindex(index);
                System.out.println(user.toString());
                System.out.println("Comparações: " + csv.getContarCompara() + "\n");

            } else {
                System.out.println("Usuario " + entrada + " não existe \n");
            }

            entrada = leitura.nextLine();
        }

        leitura.close();

    }

    public static String semAcento(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

}
