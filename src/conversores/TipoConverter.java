package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.dao.TipoDAO;
import modelo.dominio.Tipo;

@FacesConverter(value="tip-converter")
public class TipoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Integer id;
		try {
			id = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			id = null;
		}
		
		if (id != null)
		{
			TipoDAO dao = new TipoDAO();
			// lê a tipo do banco
			Tipo tip = dao.lerPorId(id);
			
			return tip;  // retorna a tipo lida
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (value instanceof Tipo)
		{
			Tipo tip = (Tipo) value;
			// retorna o ID do objeto como String
			return tip.getId().toString();
		}
		
		return null;
	}

}
