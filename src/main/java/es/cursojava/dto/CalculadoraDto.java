package es.cursojava.dto;

public class CalculadoraDto {
	private String operacion;
	private int numero1;
	private int numero2;
	public CalculadoraDto(String operacion, int numero1, int numero2) {
		super();
		this.operacion = operacion;
		this.numero1 = numero1;
		this.numero2 = numero2;
	}
	public CalculadoraDto() {
		super();
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public int getNumero1() {
		return numero1;
	}
	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}
	public int getNumero2() {
		return numero2;
	}
	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}

}
