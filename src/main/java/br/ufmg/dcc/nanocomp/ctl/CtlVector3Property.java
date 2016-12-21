package br.ufmg.dcc.nanocomp.ctl;

import java.io.IOException;

import br.ufmg.dcc.nanocomp.ctl.number.CtlInteger;

/**
 * {@link CtlVariable} class for storing {@link CtlVector3} properties
 * in classes, it is used so the y and z components are not printed if they're 0
 * @author Jerônimo Nunes Rocha
 *
 */
public class CtlVector3Property extends CtlConstant<CtlVector3> {

	private static final long serialVersionUID = 1L;
	
	public CtlVector3Property(CtlVector3 value) {
		super(value);
	}
	
	@Override
	public void write(Appendable appendable) throws IOException {
		getValue().getX().write(appendable);
		if(!CtlInteger.ZERO.equals(getValue().getY()) || !CtlInteger.ZERO.equals(getValue().getZ())){
			appendable.append(" ");
			getValue().getY().write(appendable);
		}
		if(!CtlInteger.ZERO.equals(getValue().getZ())) {
			appendable.append(" ");
			getValue().getZ().write(appendable);			
		}
	}

}
