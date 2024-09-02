package POO.DEQUE;

public class FilaCircularDePrioridade {
    private Pessoa[] fila;
    private int frente, fim, tamanho, capacidade;

    // Construtor
    public FilaCircularDePrioridade(int capacidade) {
        this.capacidade = capacidade;
        fila = new Pessoa[capacidade];
        frente = 0;
        fim = -1;
        tamanho = 0;
    }

    
    public void enfileirar(Pessoa pessoa) {
        if (estaCheia()) {
            System.out.println("Fila está cheia, não é possível adicionar mais pacientes.");
            return;
        }
        
   
        fim = (fim + 1) % capacidade;
        fila[fim] = pessoa;
        tamanho++;
        ajustarPrioridade();
    }

    
    private void ajustarPrioridade() {
        int atual = fim;
        while (atual != frente) {
            int anterior = (atual - 1 + capacidade) % capacidade;
            if (fila[atual].getPrioridade() > fila[anterior].getPrioridade()) {
                // Trocar para manter a ordem de prioridade
                Pessoa temp = fila[atual];
                fila[atual] = fila[anterior];
                fila[anterior] = temp;
                atual = anterior;
            } else {
                break;
            }
        }
    }

    
    public Pessoa desenfileirar() {
        if (estaVazia()) {
            System.out.println("Fila está vazia, não há pacientes para atender.");
            return null;
        }
        Pessoa pessoa = fila[frente];
        frente = (frente + 1) % capacidade;
        tamanho--;
        return pessoa;
    }

    public boolean estaCheia() {
        return tamanho == capacidade;
    }

   
    public boolean estaVazia() {
        return tamanho == 0;
    }

    
    public int getTamanho() {
        return tamanho;
    }
}
