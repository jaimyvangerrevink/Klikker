package klikker;

public class PuntenModel {
	protected double totaalpunten;

	public void setPunten(double aantalpunten) {
		this.totaalpunten = aantalpunten;
	}

	public void addPunten(double aantalpunten) {
		this.totaalpunten = this.totaalpunten + aantalpunten;
	}
	
	public double getPunten() {
		return this.totaalpunten;
	}
}