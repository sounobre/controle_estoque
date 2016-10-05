package manager;


import java.util.ArrayList;
import java.util.List;


import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import br.com.estoque.model.Produto;
import br.com.estoque.persistence.ProdutoDao;

@ManagedBean(name="pBean")
@RequestScoped
public class ProdutoBean {
	private Produto produto;
	private List<Produto> listaproduto;
	
	public ProdutoBean() {
		produto = new Produto();
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Produto> getListaproduto() {
		try{
			
			listaproduto = new ProdutoDao().listar();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return listaproduto;
	}
	public void setListaproduto(List<Produto> listaproduto) {
		this.listaproduto = listaproduto;
	}
	
	public String cadastrar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		
			try{
				
				new ProdutoDao().cadastrar(produto);
				
				fc.addMessage("formproduto", new FacesMessage(produto.getNome() + "produto cadastrado com sucesso"));
				
				produto = new Produto();
				
			}catch(Exception e){
				e.printStackTrace();
				fc.addMessage("formproduto", new FacesMessage(produto.getNome() + "Não cadastrado"));
			}
			
			return null;		
		
	}
	
	
	 public void onRowEdit(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Car Edited", ((Produto) event.getObject()).getNome());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Edit Cancelled");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onCellEdit(CellEditEvent event) {
	        Object oldValue = event.getOldValue();
	        Object newValue = event.getNewValue();
	         
	        if(newValue != null && !newValue.equals(oldValue)) {
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	        }
	    }
	
	
	
	
	

}
