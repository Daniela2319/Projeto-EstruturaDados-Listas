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

    public T get(int index){ // método get (index) é o índice aonde vai utilizar as informações
        return getNo(index).getConteudo();

    }


    private No<T> getNo(int index){// método interno da classe
        validaIndice(index);  // validação do método /Exemplo: Como a minha lista tem tamannho 2, passando para o tamanho 4 precisa fazer validação o índice.
        No<T> noAuxiliar = referenciaEntrada; // Criando um nó generico chamado noAuxiliar,recebe a referencia referenciaEntrada
        No<T> noRetorno = null;               // criando outro nó será o no retorno referencia é nula

        for (int i = 0; i < index; i++){ // for vai correr até o índece (index)
            noRetorno = noAuxiliar;              // esse noRetorno vai ser guardado antes de fazer passagem do proximo nó
            noAuxiliar = noAuxiliar.getProximoNo(); // passagem do proximo nó
        }
        return noRetorno;
    }

    public T remove(int index){// método remove para remover o nó index
        No<T> noPivor = this.getNo(index);
        if(index == 0){ // teste se índex for igual a zero quer dizer esta removendo o primeiro nó
           referenciaEntrada = noPivor.getProximoNo(); //este apontado para o segundo nó
           return noPivor.getConteudo(); // retornar contéudo do nó pivo
        }
        No<T> noAnterior = getNo(index -1); // Foi pego o no anterior
        noAnterior.setProximoNo(noPivor.getProximoNo());// disse noAnterior é o nó depois da frente dele
        return noPivor.getConteudo(); // perco referencia de acesso
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

    private void validaIndice(int index){
        if (index >= size()){ // teste caso index seja maior size soltar exception
            int ultimoIndice = size() - 1;
            throw new IndexOutOfBoundsException("Não existe contéudo no índice" + index + " desta lista. Esta lista só vai até índice " + ultimoIndice + '.');

        }

    }

    public boolean isEmpty(){
        return referenciaEntrada == null ? true : false;
    }

    @Override
    public String toString() {

        String strRetorno = " ";

        No<T> noAuxiliar = referenciaEntrada; // criado um nó noAuxiliar com a referência de entrada

        for (int i = 0; i < this.size(); i++){ // for correr em toda a nossa lista
            strRetorno += "No{contéudo" + noAuxiliar.getConteudo() + "}---->"; //
            noAuxiliar = noAuxiliar.getProximoNo(); // noAuxiliar estou usando pra correr a lista
                                                    // noAuxiliar recebe o proprio noAuxiliar passa a ser o nó da frente dele em cada ciclo.
        }
        strRetorno += "null"; // ultimo nó é sempre aponta nulo.


        return strRetorno;
    }
}

