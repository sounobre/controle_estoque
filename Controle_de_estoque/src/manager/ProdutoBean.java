package manager;




import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import br.com.estoque.model.Produto;
import br.com.estoque.persistence.ProdutoDao;

@ManagedBean(name="pBean")
@ViewScoped
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
		
		
		if(listaproduto != null){
			
			System.out.println(listaproduto);
		
	}else{
		
		try{
			
			System.out.println( "get " + listaproduto);
				
				listaproduto = new ProdutoDao().listar();
				
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			return listaproduto;
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
		 
		 System.out.println( "no onRowEdit " + listaproduto);
		 System.out.println( "no onRowEdit produto " + produto);
		produto = ((Produto) event.getObject());
		System.out.println( "no onRowEdit produto depois do getobject " + produto);
		
		new ProdutoDao().editar(produto);
	 }
		 
		     
	   
		public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Edit Cancelled");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	

}
