package com.codekata.lambdas

import spock.lang.Specification

/**
 * Created by davidgk on 29/12/16.
 */
class LambdaUsesTest extends Specification {

  void "Ejemplo de Supplier, cuando lo ejecuto el valor que lo usa lo cambia" () {
    given:
      LambdaUses lambdaUses = new LambdaUses();
    when:
      int value=lambdaUses.executeSupplier()
    then:
      value == 5

  }

  void "Ejemplo de Consumer, cuando lo ejecuto el valor que afecta lo cambia" () {
    given:
      LambdaUses lambdaUses = new LambdaUses();
    when:
      lambdaUses.executeConsumer(3)
    then:
      lambdaUses.valueA == 23
  }

  void "Ejemplo de Consumer, pero con una Lambda cuando lo ejecuto el valor que afecta lo cambia" () {
    given:
      LambdaUses lambdaUses = new LambdaUses();
    when:
      lambdaUses.executeOtroConsumer(3)
    then:
      lambdaUses.valueA == 43
  }

  void "Ejemplo de Predicate, cuando lo ejecuto el valor que afecta lo evalua" () {
    given:
      LambdaUses lambdaUses = new LambdaUses();
    when:
      lambdaUses.valueA = 10
      boolean value = lambdaUses.evaluarQueEsMenorQueValueAUsandoPredicados(8)
    then:
      value
  }

  void "Ejemplo de otroPredicado, cuando lo ejecuto el valor que afecta lo evalua" () {
    given:
      LambdaUses lambdaUses = new LambdaUses();
    when:
      lambdaUses.valueA = 10
      boolean value = lambdaUses.evaluarQueEsMenorQueValueAUsandoOtroPredicados(7)
    then:
      value
  }
}
