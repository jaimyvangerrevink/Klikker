package klikker;

public class PuntenModel {
	protected double totaalpunten;

	public double getPunten() {

		return this.totaalpunten;
	}
	
	public void addPunten(double aantalpunten) {

		this.totaalpunten = this.totaalpunten + aantalpunten;
	}
}