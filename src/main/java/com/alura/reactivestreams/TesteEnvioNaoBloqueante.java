package com.alura.reactivestreams;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;

import com.alura.reactivestreams.model.NotaFiscal;
import com.alura.reactivestreams.subscribe.NotaFiscalSubscribe;


public class TesteEnvioNaoBloqueante {

	public static void main(String[] args) {

		// Definir um numero de quantas threads eu gostaria de criar  
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);

		NotaFiscal primeiraNotaFiscal = new NotaFiscal(">> Joao", 39.99, LocalDate.now());

		/*
		 * Segundo parametro: número de quantas mensagens eu vou processar por vez
		 */
		SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<>(newFixedThreadPool, 3);


		NotaFiscalSubscribe subscribe = new NotaFiscalSubscribe();
		publisher.subscribe(subscribe);

		publisher.submit(primeiraNotaFiscal);
		
		System.out.println("Voca ira receber a nota fiscal no seu e-mail");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();
		publisher.close();
	}
}
 