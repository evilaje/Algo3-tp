import java.lang.reflect.Array;

public class BufferGap<T> {

	//constantes
	private int TAM_INICIAL = 16;

	//atributos
	private int inicioHueco;
	private int finHueco;
	private Long desplazamientos;
	private T datos[];

	//Ignorar la advertencia que arroja castear una instancia de un array tal y como se hace
	@SuppressWarnings("unchecked")
	public BufferGap (Class<T> clazz) {
		this.datos = (T[]) Array.newInstance(clazz, TAM_INICIAL);
	}

	public void insertar(T obj) {
		this.datos[inicioHueco] = obj;
		this.inicioHueco ++;
	}

	public T borrar() throws BufferVacioException{ //agregar el throw buffervacio
		if (inicioHueco == 0) {
			throw new BufferVacioException("El buffer esta vacio!");
		}
		inicioHueco--;
		T obj = this.datos[inicioHueco];
		return obj;
	}



}
