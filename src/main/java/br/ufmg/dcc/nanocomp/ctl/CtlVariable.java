package br.ufmg.dcc.nanocomp.ctl;

import br.ufmg.dcc.nanocomp.ctl.number.Complex;

/**
 * Any {@link CtlObject} that holds a value extends this class
 * @author Jerônimo Nunes Rocha
 *
 * @param <T> The type of the holded value
 */
public abstract class CtlVariable<T> extends CtlObject {
	
	private static final long serialVersionUID = 1L;

	private String type;
	
	public CtlVariable(String type) {
		super();
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public double doubleValue() {
		Number value = (Number) getValue();
		return value.doubleValue();
	}
	
	public double intValue() {
		Number value = (Number) getValue();
		return value.intValue();
	}
	
	public Complex complexValue() {
		Complex value = (Complex) getValue();
		return value;
	}
	
	public CtlList listValue() {
		CtlList value = (CtlList) getValue();
		return value;
	}
	
	public CtlVector3 vector3Value() {
		CtlVector3 value = (CtlVector3) getValue();
		return value;
	}
	
	public CtlClass classValue() {
		CtlClass value = (CtlClass) getValue();
		return value;
	}
	
	public abstract T getValue();

}
