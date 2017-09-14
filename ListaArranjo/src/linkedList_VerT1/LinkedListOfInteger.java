package linkedList_VerT1;

public class LinkedListOfInteger {

	// Classe interna Node
	private class Node {

		public Integer element;
		public Node next;

		public Node(Integer element) {
			this.element = element;
			next = null;
		}
	}

	// Referência para o primeiro elemento da lista encadeada.
	private Node head;
	// Referência para o último elemento da lista encadeada.
	private Node tail;
	// Contador para a quantidade de elementos que a lista contem.
	private int count;

	/**
	 * Construtor da lista
	 */
	public LinkedListOfInteger() {
		head = null;
		tail = null;
		count = 0;
	}

	/**
	 * Adiciona um elemento ao final da lista
	 *
	 * @param element
	 *            elemento a ser adicionado ao final da lista
	 */
	public void add(Integer element) {
		Node aux = new Node(element);
		if (head == null) {
			head = aux;
		} else {
			tail.next = aux;
		}
		tail = aux;
		count++;
	}

	/**
	 * Insere um elemento em uma determinada posicao da lista
	 *
	 * @param index
	 *            a posicao da lista onde o elemento sera inserido
	 * @param element
	 *            elemento a ser inserido
	 * @throws IndexOutOfBoundsException
	 *             se (index < 0 || index > size())
	 */
	public void add(int index, Integer element) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}

		Node n = new Node(element);
		if (index == 0) { // insere no inicio
			n.next = head;
			head = n;
			if (tail == null) { // serve para caso esteja adicionando o primeiro elemento?
				System.out.println("printei");
				tail = n;
			}
		} else if (index == count) { // insere no final
			tail.next = n;
			tail = n;
		} else { // insere no meio
			Node aux = head;
			for (int i = 0; i < index - 1; i++) {
				aux = aux.next;
			}
			n.next = aux.next;
			aux.next = n;
		}
		count++;
	}

	/**
	 * Retorna o elemento de uma determinada posicao da lista
	 *
	 * @param index
	 *            a posição da lista
	 * @return o elemento da posicao especificada
	 * @throws IndexOutOfBoundsException
	 *             se (index < 0 || index >= size())
	 */
	public Integer get(int index) {
		if ((index < 0) || (index >= count)) {
			throw new IndexOutOfBoundsException();
		}
		Node aux = head;
		int c = 0;
		while (c < index) {
			aux = aux.next;
			c++;
		}
		return (aux.element);
	}

	/**
	 * Substitui o elemento armanzenado em uma determinada posicao da lista pelo
	 * elemento indicado
	 *
	 * @param index
	 *            a posicao da lista
	 * @param element
	 *            o elemento a ser armazenado na lista
	 * @return o elemento armazenado anteriormente na posicao da lista
	 * @throws IndexOutOfBoundsException
	 *             se (index < 0 || index >= size())
	 */
	public Integer set(int index, Integer element) {
		if ((index < 0) || (index >= count)) {
			throw new IndexOutOfBoundsException();
		}
		Node aux = head;
		for (int i = 0; i < index; i++) {
			aux = aux.next;
		}
		Integer tmp = aux.element;
		aux.element = element;
		return tmp;

	}

	/**
	 * Remove a primeira ocorrencia do elemento na lista, se estiver presente
	 *
	 * @param element
	 *            o elemento a ser removido
	 * @return true se a lista contem o elemento especificado
	 */
	public boolean remove(Integer element) {
		if (element == null) {
			return false;
		}
		if (count == 0) {
			return false;
		}

		if (head.element.equals(element)) { // remocao do primeiro
			head = head.next;
			if (count == 1) { // se havia so um elemento na lista
				tail = null; // head também vira null com isso?
			}
			count--;
			return true;
		}

		Node ant = head;
		Node aux = head.next;

		for (int i = 1; i < count; i++) {
			if (aux.element.equals(element)) {
				if (aux == tail) { // remocao do ultimo // se eu fizer ( ant = tail ) o que seria errado?
					tail = ant;
					tail.next = null;
				} else { // remocao do meio
					ant.next = aux.next; // " salta por cima do nodo "
				}
				count--;
				return true;
			}
			ant = ant.next; // esseas 2 variaveis fazem com que a lista encadeada seja percorrida
			aux = aux.next; // observando o elemento corrente e o elemento anterior
		}

		return false;
	}

	/**
	 * Retorna true se a lista nao contem elementos
	 *
	 * @return true se a lista nao contem elementos
	 */
	public boolean isEmpty() {
		return (head == null);
	}

	/**
	 * Retorna o numero de elementos da lista
	 *
	 * @return o numero de elementos da lista
	 */
	public int size() {
		return count;
	}

	/**
	 * Esvazia a lista
	 */
	public void clear() {
		head = null;
		tail = null;
		count = 0;
	}

	/**
	 * Remove o elemento de uma determinada posicao da lista
	 *
	 * @param index
	 *            a posicao da lista
	 * @return o elemento que foi removido da lista
	 * @throws IndexOutOfBoundsException
	 *             se (index < 0 || index >= size())
	 */
	public Integer removeByIndex(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException();
		}

		Node aux = head;
		if (index == 0) {
			if (tail == head) { // se tiver apenas um elemento // tail e head apontam pro mesmo lugar
				tail = null;
			}
			head = head.next; // se a lista tem mais de um elemento cai aqui direto
			count--;
			return aux.element;
		}

		int c = 0;
		while (c < index - 1) {
			aux = aux.next;
			c++;
		}
		Integer element = aux.next.element;
		if (tail == aux.next) {
			tail = aux;
		}
		aux.next = aux.next.next;
		count--;
		return element;
	}

	/**
	 * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
	 * lista nao contem o elemento
	 *
	 * @param element
	 *            o elemento a ser buscado
	 * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
	 *         lista nao contem o elemento
	 */
	public int indexOf(Integer element) {
		int index = 0;
		Node aux = head;
		while (aux != null) {
			if (aux.element.equals(element)) {
				return (index);
			}
			aux = aux.next;
			index++;
		}
		return -1;
	}

	/**
	 * Retorna true se a lista contem o elemento especificado
	 *
	 * @param element
	 *            o elemento a ser testado
	 * @return true se a lista contem o elemento especificado
	 */
	public boolean contains(Integer element) {
		Node aux = head;
		while (aux != null) {
			if (aux.element.equals(element)) {
				return (true);
			}
			aux = aux.next;
		}
		return false;
	}

	/**
	 * Cria e retorna uma cópia deste objeto, isto é, instancia uma lista, copia os
	 * elementos para ela e a retorna. Ex: lista A = {1,2,3,4,5} lista B = A.clone()
	 * lista B = {1,2,3,4,5}
	 * 
	 * @return LinkedListOfInteger cópia da lista
	 * 
	 *         Caracterizacao O do tempo de execucao do metodo implementado: O(n)
	 *         Obs: se for o caso, considere o tempo de execução dos métodos que
	 *         estão sendo chamados.
	 */
	public LinkedListOfInteger clone() {
		LinkedListOfInteger lista = new LinkedListOfInteger();
		// int mcont = 0;
		Node aux = head;
		while (aux != null) {
			lista.add(aux.element);
			aux = aux.next;
		}
		return lista;
	}

	/**
	 * Remove todos os números pares da lista sem chamar nenhum método já
	 * implementado. Apenas os atributos (head, tail e cont) podem ser usados e
	 * atualizados se necessário. Ex: lista A = {1,2,3,4,5,6,7,8} boolean b =
	 * A.removeEvenNumbers() b = true A = {1,3,5,7}
	 * 
	 * @return boolean true se houve remoção ou false caso contrário.
	 * 
	 *         Caracterizacao O do tempo de execucao do metodo implementado:____
	 */
	public boolean removeEvenNumbers() {

		Node ant = null;
		Node aux = head;
		boolean v = false;

		while (aux != null) {
			if (aux.element % 2 == 0) {
				v = true;
				if (aux == head) {
					head = aux.next;
					v = true;
				} else if (aux == tail) {
					tail = ant;
					tail.next = null;
					v = true;
				} else {
					ant.next = aux.next;
					v = true;
				}

			} else {
				v = false;
				ant = aux;
				aux = aux.next;
			}
			
		}
		return v;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();

		Node aux = head;

		while (aux != null) {
			s.append(aux.element.toString());
			s.append("\n");
			aux = aux.next;
		}

		return s.toString();
	}

}
