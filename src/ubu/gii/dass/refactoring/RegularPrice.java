package ubu.gii.dass.refactoring;

public class RegularPrice extends MoviePrice{

	@Override
	public int getPrice() {
		return Movie.REGULAR;
	}

}
