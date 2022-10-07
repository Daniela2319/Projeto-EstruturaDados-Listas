package ProjetoListaEncadeada;

public class ListaEncadeada <T> {

    No<T> referenciaEntrada;

    public ListaEncadeada(){
        this.referenciaEntrada = null;

    }

    public void add (T conteudo){ //Método add: Receber o conteudo, vai criar novoNo e adiciona na lista
        No<T> novoNo = new No<>(conteudo);
        if (this.isEmpty()){ // Testa se lista esta vazia se não continuo
            referenciaEntrada = novoNo;
            return;
        }
        No<T> noAuxiliar = referenciaEntrada;       // Criando NoAuxilar ele vai recebe referencia de entrada
        for (int i = 0; i < this.size() - 1; i++){   // For vai correr inicio da lista ate tamanho lista metodo size
            noAuxiliar = noAuxiliar.getProximoNo(); // noAuxiliar vai receber get ProximoNo, onde esta correndo em nó e nó na lista
        }                                           // quando chega no final da lista (size())
        noAuxiliar.setProximoNo(novoNo);            // chega noAuxiliar seta novoNo adiciona.
    }



    public int size(){
        int tamanhoLista = 0;
        No<T> referenciaAux = referenciaEntrada;
        while (true){ // while infinito
            if (referenciaAux != null){   // referenciaAux é diferente de nulo
                tamanhoLista++;          //acrementar 1 na lista, garente que tem mais 1 na minha lista
                if (referenciaAux.getProximoNo() != null){  // testa se o Nó depois dela(referenciaAux) é diferente de nulo
                    referenciaAux = referenciaAux.getProximoNo(); // se caso ele tem Nó a sua frente (referenciaAux proximo Nó
                }else{ //referenciaAux for nulo será dado o break
                    break;
                }
            }else {
                break;
            }
        }
        return tamanhoLista; // Quebra os while
    }

    public boolean isEmpty(){
        return referenciaEntrada == null ? true : false;
    }
}
