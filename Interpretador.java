import java.util.ArrayList;


public class Interpretador {
    private ArrayList<String> lines;
    private String linha;


    public void Ler(ArrayList<String> arr){
        this.lines = arr;
        //linha = lines.toString();
        StringBuffer sb = new StringBuffer();

        for (String s : lines) {
            sb.append(s);
            sb.append(" ");
        }
        linha = sb.toString();
        Identificar(linha);
    }

    public void Identificar(String line) {

        String[] arrayPlvr = line.split(" ");
        if (arrayPlvr.length == 1){
            //type
            if (isType(line)) {
                System.out.println(" "+linha);
                System.out.println(" É um Type");

            }else{
                System.out.println(linha);
                System.out.println(" A declaração está incorreta");
            }
        }else if (line.contains("{")){
            if(isMethod(line)){
                System.out.println(" "+linha);
                System.out.println(" É um Método ");
            }else{
                System.out.println(linha);
                System.out.println(" A declaração está incorreta");
            }
        }else {

            if (isVariable(line)) {
                System.out.println(linha);
                System.out.println(" É uma Variável ");
            } else {
                System.out.println(linha);
                System.out.println(" A declaração está incorreta");
            }
        }
    }

    public boolean isMethod(String line){
        int index = 0;
        while (line.charAt(index) == ' '){
            index++;
        }
        if (line.indexOf("public", index) != -1 ||
                line.indexOf("private", index) != -1 ) {

            String[] arrayPlvr = line.split(" ");
            String firstUp = arrayPlvr[1].toUpperCase();

            if (arrayPlvr[1].equals("int") || arrayPlvr[1].equals("int[]") ||
                    arrayPlvr[1].equals("boolean") || arrayPlvr[1].charAt(0) == firstUp.charAt(0)) {

                if (line.indexOf('(') != -1 && line.indexOf(')') != -1) {
                    int par_a = line.indexOf('(');
                    int par_f = line.indexOf(')');
                    int index1 = par_f - par_a;
                    if (index1 > 1){
                        String parametros = line.substring(par_a, par_f);
                        if (parametros.contains(",")){
                            String[] arrayParam = parametros.split(",");
                            for ( int i = 0; i < arrayParam.length;){
                                return isParam(arrayParam[i]);
                            }
                        }
                        return isParam(parametros);
                    }

                    String definicao = line.substring(par_f);
                    return (definicao.indexOf('{') != -1 && definicao.indexOf('}') != -1);
                }
            }
        }
        return false;
    }

    public boolean isVariable(String line){
        int index = 0;
        String firstUp = line.toUpperCase();

        while (line.charAt(index) == ' '){
            index++;
        }

        if(line.indexOf("int", index) != -1 ||
                line.indexOf("int[]", index) != -1 ||
                line.indexOf("boolean", index) != -1||
                line.charAt(0) == firstUp.charAt(0)) {

            String[] arrayPlvr = line.split(" ");


            if (arrayPlvr.length >= 2) {
                if(Character.isLetterOrDigit(arrayPlvr[1].charAt(0))) {
                    return arrayPlvr[arrayPlvr.length - 1].endsWith(";");
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean isType(String line){
        String firstUp = line.toUpperCase();
        if(line.contains("int") ||
                line.contains("int[]") ||
                line.contains("boolean") ||
                line.charAt(0) == firstUp.charAt(0)) {
            return (!line.endsWith(";"));
        }
        return false;
    }

    public boolean isParam(String parametro){

        String[] tam = parametro.split(" ");

        if (tam.length == 2) {
            String firstUp = tam[0].toUpperCase();

            if (tam[0].contains("int") ||
                    tam[0].contains("int[]") ||
                    tam[0].contains("boolean") ||
                    tam[0].charAt(0) == firstUp.charAt(0)) {
                return true;
            }
        }
        return false;
    }
}
