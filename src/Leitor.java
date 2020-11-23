import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;




public class Leitor {

    public static void main(String[] args) {
        Scanner inputUser       = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<String>();
        Interpretador i = new Interpretador();

        System.out.println(" Insira o path do seu arquivo no formato: 'C:\\' ");
        String path = inputUser.nextLine();
        inputUser.close();
        try {
            File file  = new File(path);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
            // System.out.println(lines);
            i.Ler(lines);
            sc.close();
        }catch (FileNotFoundException e) {
            System.out.println(" Ocorreu um erro. Tente novamente.");
            e.printStackTrace();
        }
    }



}


