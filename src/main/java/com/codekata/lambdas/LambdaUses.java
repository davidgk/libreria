package com.codekata.lambdas;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by davidgk on 29/12/16.
 */
public class LambdaUses {

  int valueA;

  /*
  * Hace de Supplier , no recibe parametros y
  * */
  public int yoSoyUnSupplier(){
    return  1+2;
  }


  public int useSupplier(Supplier<? extends Integer> supplier) {
    int val = supplier.get();
    return val +2;
  }

  public int executeSupplier() {
    return this.useSupplier(this::yoSoyUnSupplier);
  }

  public void executeConsumer(int val ) {
    valueA = val;
    aplicarConsumer(this::sumar);

  }
  public void executeOtroConsumer(int val ) {
    valueA = val;
    Consumer otraFormaDeSumar= x -> {
      valueA += 2 * (Integer) x;
    };
    aplicarConsumer(otraFormaDeSumar);
  }

  private void aplicarConsumer(Consumer<Integer> consumer) {
    consumer.accept(20);
  }

  private void sumar(Integer x) {
    valueA += x;
  }


  public boolean evaluarQueEsMenorQueValueAUsandoPredicados(int val ) {
    valueA = 10;
    return aplicarUnPredicado(this::soyUnPredicado, val);
  }

  public boolean evaluarQueEsMenorQueValueAUsandoOtroPredicados(int val ) {
    valueA = 10;
    Predicate<Integer> otroPredicado = x -> valueA > x ;
    return aplicarUnPredicado(otroPredicado, val);
  }



  private boolean aplicarUnPredicado(Predicate<Integer> predicate, int val) {
    return predicate.test(val);
  }

  private boolean soyUnPredicado(Integer value) {
    return valueA > value;
  }



}
