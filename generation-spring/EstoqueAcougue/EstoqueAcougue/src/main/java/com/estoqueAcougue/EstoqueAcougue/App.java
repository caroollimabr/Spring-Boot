package com.estoqueAcougue.EstoqueAcougue;

import com.estoqueAcougue.Servico.ServicoImpl;
import com.estoqueAcougue.model.Carne;

public class App 
{
	//passo 4.0 crio um objeto serv do tipo serviço e apresento os metodos de forma limpa.
    public static void main( String[] args )
    {
       ServicoImpl serv= new ServicoImpl();
      
       serv.addCarne(new Carne("maminha", 15, 12.00));
       serv.deleteCarne();
       serv.getAllCarne();
    }
}
