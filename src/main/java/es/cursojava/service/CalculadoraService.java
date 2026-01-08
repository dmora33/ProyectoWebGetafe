package es.cursojava.service;

import es.cursojava.dto.CalculadoraDto;

public class CalculadoraService {
	public String calcular(CalculadoraDto calculadoraDto) {
		String resultado = "";
		switch (calculadoraDto.getOperacion()) {
			case "suma" ->resultado= "El resultaodo es: " +(calculadoraDto.getNumero1() + calculadoraDto.getNumero2());
			case "resta" ->resultado= "El resultaodo es: "+ (calculadoraDto.getNumero1() - calculadoraDto.getNumero2());
			case "multiplicacion" ->resultado= "El resultaodo es: "+ (calculadoraDto.getNumero1() * calculadoraDto.getNumero2());
			default -> throw new IllegalArgumentException("Operación no válida: " + calculadoraDto.getOperacion());
		};
		return resultado;
	}
	private void validar(CalculadoraDto dto) { if (dto.getOperacion() == null || dto.getOperacion().isBlank()) { throw new IllegalArgumentException("La operación no puede estar vacía"); } }
}