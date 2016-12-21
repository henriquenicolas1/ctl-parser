package br.ufmg.dcc.nanocomp.ctl;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

public class CtlClass extends CtlObject {
	
	private static final long serialVersionUID = 1L;

	private String name;
	
	private Map<String,CtlVariable<?>> properties;

	public CtlClass(String name, Map<String, CtlVariable<?>> properties) {
		this.name = name;
		this.properties = properties;
	}
	
	public CtlVariable<?> getProperty(String name) {
		return properties.get(name);
	}
	
	public void setProperty(String name, CtlVariable<?> value) {
		properties.put(name, value);
	}

	public String getName() {
		return name;
	}
	
	@Override
	public void write(Appendable appendable) throws IOException {
		appendable.append("(make ").append(getName());
		for(Entry<String, CtlVariable<?>> prop : properties.entrySet()) {
			appendable.append(" (").append(prop.getKey()).append(" ");
			prop.getValue().write(appendable);
			appendable.append(")");
		}
		appendable.append(")");
	}

}
