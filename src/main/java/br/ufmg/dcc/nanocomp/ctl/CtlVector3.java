package br.ufmg.dcc.nanocomp.ctl;

import java.io.IOException;

import br.ufmg.dcc.nanocomp.ctl.number.CtlInteger;

public class CtlVector3 extends CtlObject {

	private static final long serialVersionUID = 1L;

	private CtlVariable<?> x;
	private CtlVariable<?> y;
	private CtlVariable<?> z;

	public CtlVector3(CtlVariable<?> x) {
		this(x,CtlInteger.ZERO,CtlInteger.ZERO);
	}

	public CtlVector3(CtlVariable<?> x, CtlVariable<?> y) {
		this(x,y,CtlInteger.ZERO);
	}

	public CtlVector3(CtlVariable<?> x, CtlVariable<?> y, CtlVariable<?> z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public CtlVariable<?> getX() {
		return x;
	}

	public void setX(CtlVariable<?> x) {
		this.x = x;
	}

	public CtlVariable<?> getY() {
		return y;
	}

	public void setY(CtlVariable<?> y) {
		this.y = y;
	}

	public CtlVariable<?> getZ() {
		return z;
	}

	public void setZ(CtlVariable<?> z) {
		this.z = z;
	}

	@Override
	public void write(Appendable appendable) throws IOException {
		appendable.append("(vector3 ");
		x.write(appendable);
		if(!CtlInteger.ZERO.equals(y) || !CtlInteger.ZERO.equals(z)){
			appendable.append(" ");
			y.write(appendable);
		}
		if(!CtlInteger.ZERO.equals(z)) {
			appendable.append(" ");
			z.write(appendable);			
		}
		appendable.append(")");
	}

}
