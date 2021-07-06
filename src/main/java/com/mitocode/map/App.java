package com.mitocode.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class App {

	private Map<Integer, String> map;

	public void poblar() {
		map = new HashMap<>();
		map.put(1, "Mito");
		map.put(2, "Code");
		map.put(3, "Suscribete");
	}

	public void imprimir_v7() {
		for (Entry<Integer, String> e : map.entrySet()) {
			System.out.println("Llave: " + e.getKey() + " Valor: " + e.getValue());
		}
		
//		Set<Integer> keyMap= map.keySet();
//		for (Integer key :keyMap) {
//			System.out.println("Llave: " + key + " Valor: " + map.get(key));
//		}
	}

	public void imprimir_v8() {
		map.forEach(new BiConsumer<Integer, String>(){

			@Override
			public void accept(Integer k, String v) {
				System.out.println("Llave: " + k + " Valor: " + v);
				
			}
			
		});
//		map.forEach((k,v) -> System.out.println("Llave: " + k + " Valor: " + v));
		map.entrySet().stream().forEach(System.out::println);
	}

	public void recolectar() {
		Map<Integer, String> mapaRecolectado = map.entrySet().stream()
				.filter(e->e.getValue().contains("o"))
				.collect(Collectors.toMap(p-> p.getKey(), p-> p.getValue()));
		
		mapaRecolectado.forEach((k,v)-> System.out.println("Llave: " + k + " Valor: " + v));
	}

	public void insertarSiAusente() {
		map.putIfAbsent(2, "Jaime");
	}

	public void operarSiPresente() {
		map.computeIfPresent(3, (k,v)-> k + v);
		System.out.println(map.get(3));
	}

	public void obtenerOrPredeterminado() {
		String valor = map.getOrDefault(5, "valor por defecto");
		System.out.println(valor);
	}

	public static void main(String[] args) {
		App app = new App();
		app.poblar();
		app.imprimir_v7();
		//app.insertarSiAusente();
		//app.imprimir_v8();
		//app.operarSiPresente();
		//app.obtenerOrPredeterminado();
//		app.recolectar();
	}

}
