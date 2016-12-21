package br.ufmg.dcc.nanocomp.ctl.defines;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import br.ufmg.dcc.nanocomp.ctl.CtlObject;
import br.ufmg.dcc.nanocomp.ctl.CtlVariable;

public class CtlSimpleFunctionDeclaration<T> extends CtlFunctionDeclaration<T> {
	
	private static final long serialVersionUID = 1L;

	private String name;
	
	public CtlSimpleFunctionDeclaration(String name, List<CtlDeclaredVariable> args) {
		super(args);
		this.name = name;
	}
	
	@Override
	public void fillArgs(Iterator<? extends CtlVariable<Object>> values) {
		for(CtlDeclaredVariable arg : (List<CtlDeclaredVariable>)getArgs()) {
			if(values.hasNext()) {
				arg.setValue(values.next());
			} else {
				 throw new RuntimeException("Function "+name+" has received not enough arguments");
			}
		}
	}
	
	@Override
	public void write(Appendable appendable) throws IOException {
		appendable.append("(").append(getName());
		for(CtlObject obj : getArgs()) {
			appendable.append(" ");
			obj.write(appendable);
		}
		appendable.append(")");
	}
	
	public String getName() {
		return name;
	}
}
