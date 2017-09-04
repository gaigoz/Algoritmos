package listaComArranjo1;

public class ListaComArranjo {

	private static final int TAXA_CRESCIMENTO = 10;
	private int[] lista;
	private int count; // número de posiçoes ocupadas

	public ListaComArranjo() {
		clear();
	}

	public void clear() {
		this.lista = new int[TAXA_CRESCIMENTO];
		this.count = 0;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return (count == 0);
	}

	public int indexOf(int element) {
		for (int index = 0; index < count; index++) {
			if (lista[index] == element) {
				return index;
			}
		}

		return -1;
	}

	public boolean contains(int element) {
		return (indexOf(element) >= 0);
	}

	private boolean indiceValido(int index) {
		return (index >= 0 && index < count);
	}

	public int get(int index) throws Exception {
		if (indiceValido(index)) {
			return lista[index];
		} else {
			throw new Exception("Indice inválido " + index);
		}
	}

	public void set(int index, int element) throws Exception {
		if (indiceValido(index)) {
			lista[index] = element;
		} else {
			throw new Exception("Indice inválido " + index);
		}
	}

	public boolean remove(int element) {
		int index = indexOf(element);

		if (index < 0) {
			return false;
		} else {
			// remover o elemento que está em index

			if (index == count - 1) { // é o último?
				count--;
			} else { // é o primeiro ou outro no meio
				for (int i = index; i < count - 1; i++) {
					lista[i] = lista[i + 1];
				}
				count--;
			}

			return true;
		}
	}

	private boolean temEspacoParaAdicionar() {
		return (count < lista.length);
	}

	private void crescerLista() {
		int[] novaLista = new int[lista.length + TAXA_CRESCIMENTO];

		for (int i = 0; i < count; i++) {
			novaLista[i] = lista[i];
		}

		this.lista = novaLista;
	}

	/**
	 * Adiciona um elemento no final da lista
	 * 
	 * @param element
	 */
	public void add(int element) {

		if (!temEspacoParaAdicionar()) {
			crescerLista();
		}

		lista[count] = element;
		count++;
	}

	public void add(int index, int element) {
		if (index == count) { // é a última
			add(element);
		} else { // no início ou no meio?
			if (!temEspacoParaAdicionar()) {
				crescerLista();
			}

			for (int pos = count - 1; pos >= index; pos--) {
				lista[pos + 1] = lista[pos];
			}

			lista[index] = element;
			count++;
		}
	}

	@Override
	public String toString() {
		String lstr = "[ ";
		for (int i = 0; i < count; i++) {
			lstr += lista[i] + " ";
		}

		return lstr + "]";
	}

	// retira uma determinada parte de um array de uma posicao at� a outra
	public int[] sublist(int from, int to) {
		int[] list = new int[to - from];
		int cont = 0;
		for (int i = from; i < to; i++) {
			list[cont] = lista[i];
			cont++;
		}
		return list;
	}

	// inverte a lista
	public void reverse() {
		int ultimaP = count - 1;
		for (int i = 0; i < count / 2; i++) {
			int aux = lista[i];
			lista[i] = lista[ultimaP];
			lista[ultimaP] = aux;
			ultimaP--;
		}
	}

	// conta a ocorrencia de um determinado termo em uma lista
	public int countOccurrences(int element) {
		int cont = 0;
		for (int i = 0; i < count; i++) {
			if (lista[i] == element) {
				cont++;
			}
		}
		return cont;
	}

	// insercao ordenada em uma lista
	public void addIncreasingOrder(int element) {

		if (count == 0) {

			lista[0] = element;

		} else if (element > lista[count -1]) {

			lista[count] = element;

		} else {

			for (int i = 0; i < count; i++) {
				if (lista[i] > element) {
					for (int j = count; j > i; j--) {
						lista[j] = lista[j - 1];
					}
					lista[i] = element;
				}
			}
		}
		count++;
	}
}

/*
 * 
 * 
 * 
 * int removeByIndex (int index )
 * 
 * 
 */
