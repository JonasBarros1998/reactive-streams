package com.alura.reactivestreams.wsclient;

import com.alura.reactivestreams.model.NotaFiscal;

public class NotaFiscalWSClient {

	public void enviar(NotaFiscal nf) {
		try {
			
			System.out.println(">>> NotaFiscalWSClient thred: " + Thread.currentThread().getName());
			System.out.println("Processando nota fiscal");
			Thread.sleep(5000);
			System.out.format("Nota fiscal emitida %nEm nome de %s %nNa data de %s %n", 
					nf.getNome(), nf.getData());
			System.out.println("Finalizado nota fiscal na thred: " + Thread.currentThread().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
