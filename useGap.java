public class useGap {
	public static void main(String[] args) {
		BufferGap<Character> bf = new BufferGap<>();
		bf.insertar('a');
		bf.insertar('b');
		bf.insertar('d');
		bf.insertar('e');
		bf.insertar('f');
		bf.moverCursor(-2);
		System.out.println(bf.getInicioHueco());
		System.out.println(bf.getFinHueco());
		System.out.println(bf);
		System.out.println(bf.desplazamientos());
	}
}
