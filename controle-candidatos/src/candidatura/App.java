package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Processo Seletivo");
        
        //analisarCandidato(1900.0);
        //analisarCandidato(2200.0);
        //analisarCandidato(2000.0);

        //selecaoCanditatos();

        //imprimirSelecionados();

        entrandoEmContatoLista();
    }

    static void entrandoEmContatoLista() {
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "MONICA"};
        for(String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato) {
        
        int tentativasRealizadas = 1;
        boolean continuaTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuaTentando = !atendeu;
            if(continuaTentando) {
                ++tentativasRealizadas;
            } else {
                System.out.println("Contato com " + candidato + " realizado com sucesso");
            }
        } while(continuaTentando && tentativasRealizadas < 3);

        if(atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa");
        } else {
            System.out.println("Não conseguimos contato com " + candidato + ", número máximo tentativas " + tentativasRealizadas);
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados() {
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "MONICA"};
        for(String candidato : candidatos) {
            System.out.println("O candidato " + candidato + " foi solecionado para a vaga");
        }
    }

    static void selecaoCanditatos() {
        
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JOJO"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        do {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
            if(salarioBase >= salarioPretendido) {
                ++candidatosSelecionados;
                System.out.println(candidatosSelecionados + "- O candidato " + candidato + " foi solecionado para a vaga");
            }
            ++candidatoAtual;
        } while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length);
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {

        double salarioBase = 2000.0;

        if(salarioBase > salarioPretendido)
            System.out.println("LIGAR PARA O CANDIDATO");
        else if(salarioBase == salarioPretendido)
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        else
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
    }
}
