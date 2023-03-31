package com.alura.reactivestreams.subscribe;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import com.alura.reactivestreams.model.NotaFiscal;
import com.alura.reactivestreams.wsclient.NotaFiscalWSClient;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class NotaFiscalSubscribe implements Subscriber<NotaFiscal> {

  private Subscription subscription;

  @Override
  public void onSubscribe(Subscription subscription) {
    System.out.println("Chamando o onSubscribe!!");
    this.subscription = subscription;
  }

  @Override
  public void onNext(NotaFiscal notaFiscal) {
    NotaFiscalWSClient nfws = new NotaFiscalWSClient();
    nfws.enviar(notaFiscal);
  }

  @Override
  public void onError(Throwable throwable) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'onError'");
  }

  @Override
  public void onComplete() {
    System.out.println("Todas as notas foram emitidas");
  }
  
}
