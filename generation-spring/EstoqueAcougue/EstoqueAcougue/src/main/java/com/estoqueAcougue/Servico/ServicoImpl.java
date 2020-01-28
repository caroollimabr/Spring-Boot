package com.estoqueAcougue.Servico;

import com.estoqueAcougue.baseDados.BaseDadosCarne;
import com.estoqueAcougue.model.Carne;
//3.2 contruir metodos de getAllCarne, addCarne, deleteCarne
public class ServicoImpl implements IServico {
	BaseDadosCarne baseDados= new BaseDadosCarne();
	public void getAllCarne() {
		for (int i = 0; i < baseDados.getListaCarne().size(); i++) {
			System.out.println(
	    "Carne de:"+baseDados.getListaCarne().get(i).getNome()+" "+
		"quantidade: "+baseDados.getListaCarne().get(i).getQuantidade()
		+"preco por Kilo: "+baseDados.getListaCarne().get(i).getPreco());
		}
		
	}

	public void addCarne(Carne carne) {
		baseDados.getListaCarne().add(carne);
		
	}

	public void deleteCarne() {
		baseDados.getListaCarne().remove(baseDados.getListaCarne().size()-1);
		
	}

}
