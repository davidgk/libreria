package com.codekata.libreria;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by davidgk on 25/07/16.
 */
public class Cajero {

    public Sell currentSell;

    public IMerchantOrderProcessor merchantOrderProcessor;


    public BigDecimal doCheckout() {
            Double totalamount = 0D;

            Map<String,List<Book>> listaCompras = this.currentSell.carritoACobrar.getListaCompras();
            for (String title :listaCompras.keySet()){
                List<Book> compradosPorTitulo = listaCompras.get(title);
                totalamount+=compradosPorTitulo
                        .stream()
                        .mapToDouble(Book::getPrecio).sum();
            }
            return new BigDecimal(totalamount);

    }

    public void setMerchantOrderProcessor(IMerchantOrderProcessor merchantOrderProcessor) {
        this.merchantOrderProcessor = merchantOrderProcessor;
    }

    public ProcessStatus realizarCobroVentaActual(BigDecimal totalAmount) throws Exception{
        ProcessStatus processStatus = new ProcessStatus();
        try {
            this.currentSell.makeValidations();
            this.currentSell.getMedioDePago().setTransactionAmount(totalAmount);
            processStatus.status =this.merchantOrderProcessor.doCobro(this.currentSell.getMedioDePago());
        } catch (Exception e) {
            processStatus.status =0;
            processStatus.message =e.getMessage();

        }
        return processStatus;
    }
}
