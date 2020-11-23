import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

import src.
public class teste01 {
    File file  = new File("/exemplos/exemplo01.in");
    Scanner sc = new Scanner(file);
    @Rule
     Interpretador i = new Interpretador(sc);

    public teste01() throws FileNotFoundException {
    }

    @Test
    public void test() throws Exception
    {
        assertTrue(i.isType() == true);
    }

}

