import java.util.Scanner;

public class Contador {
    public static void main(String[] args) throws Exception {
        
        Scanner terminal = new Scanner(System.in);
        
        System.out.println("Digite o parametro um");
        int parametroUm = terminal.nextInt();
        System.out.println("Digite o parametro dois");
        int parametroDois = terminal.nextInt();
        
        try {
            contar(parametroUm, parametroDois);
        } catch(ParametrosInvalidosException e) {
            System.out.println("O segundo parametro deve ser maior que o primeiro");
        }
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {

        int contagem = parametroDois - parametroUm;
        if(contagem <= 0) throw new ParametrosInvalidosException();
        for(int i = 1; i < contagem; ++i) System.out.println("contagem " + i);
    }
}

class ParametrosInvalidosException extends Exception {

}