package POO.DEQUE;

import java.util.Random;

public class CentroDeSaude {
    private FilaCircularDePrioridade fila;

    
    public CentroDeSaude() {
        fila = new FilaCircularDePrioridade(100);  
    }

    public void gerarPacientesDiarios() {
        Random rand = new Random();
        int contadorDeId = 1;

        for (int grupo = 1; grupo <= 10; grupo++) {
            
            for (int i = 0; i < 1; i++) {
                fila.enfileirar(new Pessoa(contadorDeId++, "M", rand.nextInt(60) + 20, false, false, true)); // Necessidades Especiais
                fila.enfileirar(new Pessoa(contadorDeId++, "F", rand.nextInt(40) + 20, true, false, false)); // Gestante
                fila.enfileirar(new Pessoa(contadorDeId++, "F", rand.nextInt(40) + 20, false, true, false)); // Lactante
                fila.enfileirar(new Pessoa(contadorDeId++, "M", rand.nextInt(30) + 61, false, false, false)); // Acima de 60
            }
            for (int i = 0; i < 3; i++) {
                fila.enfileirar(new Pessoa(contadorDeId++, "M", rand.nextInt(30) + 61, false, false, false)); // Acima de 60
            }
            for (int i = 0; i < 4; i++) {
                fila.enfileirar(new Pessoa(contadorDeId++, "M", rand.nextInt(40) + 20, false, false, false)); // Normal
            }
        }
    }

    
    public void processarFilaDiaria() {
        int grupo = 1;
        int atendidos = 0;

        while (!fila.estaVazia() && atendidos < 100) {
            int tamanhoGrupo = grupo;
            System.out.println("Grupo " + grupo + ": Atendendo " + tamanhoGrupo + " pessoas");
            for (int i = 0; i < tamanhoGrupo && atendidos < 100 && !fila.estaVazia(); i++) {
                Pessoa p = fila.desenfileirar();
                System.out.println("Atendido: " + p);
                atendidos++;
            }
            grupo++;
        }

        if (!fila.estaVazia()) {
            System.out.println("Pacientes não atendidos: ");
            while (!fila.estaVazia()) {
                System.out.println(fila.desenfileirar());
            }
        }
    }
}