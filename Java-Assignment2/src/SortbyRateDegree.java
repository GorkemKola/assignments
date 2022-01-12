import java.util.Comparator;

public class SortbyRateDegree implements Comparator<Film> {

    /**
     * Compare Films by Rates
     *
     * @param o1 Film1
     * @param o2 Film2
     * @return An Integer to sort films by descending order
     */
    @Override
    public int compare(Film o1, Film o2) {
        // TODO Auto-generated method stub
        return Double.compare(o2.getAverageRatingScore(), o1.getAverageRatingScore());
    }

}
