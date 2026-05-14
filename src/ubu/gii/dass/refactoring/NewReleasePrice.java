package ubu.gii.dass.refactoring;

public class NewReleasePrice extends MoviePrice{

	@Override
	public int getPrice() {
		return Movie.NEW_RELEASE;
	}

}
