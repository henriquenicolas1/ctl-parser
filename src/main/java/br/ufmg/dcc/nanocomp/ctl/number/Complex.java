package br.ufmg.dcc.nanocomp.ctl.number;

import java.io.IOException;

import br.ufmg.dcc.nanocomp.ctl.CtlObject;

public class Complex extends CtlObject {
	
	private static final long serialVersionUID = 1L;
	
	public static final Complex ZERO = new Complex(0d,0d);
	public static final Complex ONE = new Complex(1d,0d);

	private Double real;
	
	private Double imaginary;
	
	public Complex(Double real, Double imaginary) {
		super();
		this.real = real;
		this.imaginary = imaginary;
	}

	public Double getReal() {
		return real;
	}
	
	public void setReal(Double real) {
		this.real = real;
	}
	
	public Double getImaginary() {
		return imaginary;
	}
	
	public void setImaginary(Double imaginary) {
		this.imaginary = imaginary;
	}
	
	@Override
	public void write(Appendable appendable) throws IOException {
		appendable.append(real.toString());
		if(imaginary>0) {
			appendable.append("+").append(imaginary.toString()).append("i");
		} else if(imaginary<0){
			appendable.append(imaginary.toString()).append("i");
		}
	}

	public static Complex valueOf(Object val) {
		if(val instanceof Number) {
			return new Complex(((Number) val).doubleValue(),0d);
		} else if(val instanceof Complex) {
			return (Complex) val;
		} else {
			return null;
		}
	}

	public Complex sum(Complex c) {
		return new Complex(
				this.getReal()+c.getReal(),
				this.getImaginary()+c.getImaginary());
	}

	public Complex sub(Complex c) {
		return new Complex(
				this.getReal()-c.getReal(),
				this.getImaginary()-c.getImaginary());
	}

	public Complex mul(Complex c) {
		return new Complex(
				this.getReal()*c.getReal()-this.getImaginary()*c.getImaginary(),
				this.getReal()*c.getImaginary()+this.getImaginary()*c.getReal());
	}

	public Complex div(Complex c) {
		return new Complex(
				(this.getReal()*c.getReal()+this.getImaginary()*c.getImaginary())/(c.getReal()*c.getReal() + c.getImaginary()*c.getImaginary()),
				(this.getImaginary()*c.getReal()-this.getReal()*c.getImaginary())/(c.getReal()*c.getReal() + c.getImaginary()*c.getImaginary()));
	}
}