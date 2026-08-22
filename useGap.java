import java.util.Scanner;

public class useGap {
	public static void main(String[] args) {
		BufferGap<Character> bf = new BufferGap<>();
		BufferGap<Character> bf2 = new BufferGap<>();

		int n = 50;
		int nIncrement = 100000;
		String abc = "abcdefghijklmnopqrstuvwxyz";
		//cargar primeros n caracteres
		for (int i = 0; i < n; i++) {
			int index = (int) (Math.random() * abc.length());
			bf.insertar(abc.charAt(index));
			bf2.insertar(abc.charAt(index));
		}

		test(bf, bf2, 100000);
		test(bf, bf2, 200000);
		test(bf, bf2, 300000);
		test(bf, bf2, 400000);
		test(bf, bf2, 500000);


	}

	public static void agregarIngenuo(BufferGap<Character> bf, char c) {
		int inicio = bf.posicionCursor();
		bf.moverCursor(-inicio);
		bf.insertar(c);

	}
	public static void cargarBuffersGap(BufferGap<Character> bf1, BufferGap<Character> bf2, int n) {
		String abc = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < n; i++) {
			int index = (int) (Math.random() * abc.length());
			bf1.insertar(abc.charAt(index));
			agregarIngenuo(bf2, abc.charAt(index));
		}
	}

	public static void test(BufferGap<Character> bf, BufferGap<Character> bf2, int n) {
		if (bf.posicionCursor() > 0) {

			int medio = bf.size() / 2;
			bf.moverCursor(-medio);
			bf2.moverCursor(-medio);
		}

		//Reiniciar desplazamientos
		bf.reiniciarDesplazamientos();
		bf2.reiniciarDesplazamientos();


		cargarBuffersGap(bf, bf2, n);
		System.out.println("N \t BufferGap desplazamientos \t Desplazamientos ingenuo");
		System.out.println(n + "\t" + bf.desplazamientos() + "\t\t\t\t" + bf2.desplazamientos());
	}

}
