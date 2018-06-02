public class Movie {
    private String movieName;
    private Integer year;
    private Double rating;

    public Movie(String movieName, Integer year, Double rating){
        this.movieName = movieName;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return movieName + "(" + year + "): "+ rating;
    }
}
