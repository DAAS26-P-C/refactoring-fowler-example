package ubu.gii.dass.refactoring;
/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	private MoviePrice _priceCode;

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return _priceCode.getPrice();
	}

	 public void setPriceCode(int arg) {
	        switch (arg) {  // ← Este switch se mantiene SOLO para crear la estrategia correcta
	            case REGULAR:
	                _priceCode = new RegularPrice();
	                break;
	            case NEW_RELEASE:
	                _priceCode = new NewReleasePrice();
	                break;
	            case CHILDRENS:
	                _priceCode = new ChildrenPrice();
	                break;
	            default:
	                throw new IllegalArgumentException("Invalid price code");
	        }
	    }

	public String getTitle() {
		return _title;
	}

	public double getCharge(int daysRented) {

	    double result = 0;
	    switch(getPriceCode()) {
	        case Movie.REGULAR:
	            result += 2;
	            if(daysRented > 2)
	                result += (daysRented - 2) * 1.5;
	            break;

	        case Movie.NEW_RELEASE:
	            result += daysRented * 3;
	            break;

	        case Movie.CHILDRENS:
	            result += 1.5;
	            if(daysRented > 3)
	                result += (daysRented - 3) * 1.5;
	            break;
	    }

	    return result;
	}

	public int getFrecuentRenterPoints(int daysRented) {
		int frequentRenterPoints=1;
		// add bonus for a two day new release rental
		if ((getPriceCode() == Movie.NEW_RELEASE)
				&& daysRented > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}
	
	
}
