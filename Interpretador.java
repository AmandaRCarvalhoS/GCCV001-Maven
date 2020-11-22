import java.util.ArrayList;


public class Interpretador {
    private ArrayList<String> lines;
    private String linha;


    public void Ler(ArrayList<String> arr){
        this.lines = arr;
        for (int i = 0; i < lines.size(); i++){
            linha = lines.get(i);
            Identificar(linha);
        }
    }

    public void Identificar(String line) {

        String[] arrayPlvr = line.split(" ");
        if (arrayPlvr.length == 1){
            //type
            if (isType(line)) {
                System.out.println(line);
                System.out.println(" É um Type");
                
            }else{
                    System.out.println(line);
                    System.out.println("A declaração está incorreta");
            }
        }else if (line.contains("{")){
            if(isMethod(line)){
                System.out.println(line);
                System.out.println("É um Método ");
            }else{
                System.out.println(line);
                System.out.println("A declaração está incorreta");
            }
        }else {

            if (isVariable(line)) {
                System.out.println(line);
                System.out.println("Variável ");
            } else {
                System.out.println(line);
                System.out.println("A declaração está incorreta");
            }
            //erro
           // System.out.println("Ops! Isso não parece ser uma sentença em Java ");
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

            if (arrayPlvr[1] == "int" || arrayPlvr[1] == "int[]" || arrayPlvr[1] == "boolean ") {
                if (arrayPlvr[2].contains("(") && arrayPlvr[2].contains(")") ){

                }
            }
        }
        return false;
    }

    public boolean isVariable(String line){
        int index = 0;
        while (line.charAt(index) == ' '){
            index++;
        }
        if(line.indexOf("int", index) != -1 ||
                line.indexOf("int[]", index) != -1 ||
                line.indexOf("boolean", index) != -1) {
            int qtd = 0;
            String[] arrayPlvr = line.split(" ");
            for (String s : arrayPlvr) {
                qtd++;
                //System.out.println(s);
            }
            if (qtd >= 2) {

              if(Character.isLetterOrDigit(arrayPlvr[1].charAt(0))) {
                  return line.endsWith(";");
              }
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean isType(String line){
        String firstUp = line.toUpperCase();
        if(line.indexOf("int") != -1 ||
           line.indexOf("int[]") != -1 ||
           line.indexOf("boolean") != -1 ||
           line.charAt(0) == firstUp.charAt(0)) {
            return (!line.endsWith(";"));
        }
        return false;
    }
}
