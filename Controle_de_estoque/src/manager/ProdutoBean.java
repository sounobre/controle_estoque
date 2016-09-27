package manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseStream;
import javax.faces.context.ResponseWriter;
import javax.faces.model.SelectItem;
import javax.faces.render.RenderKit;

import br.com.estoque.model.Produto;
import br.com.estoque.persistence.ProdutoDao;

@ManagedBean
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
			}
			
			return null;		
		
	}
	
	
	

}
