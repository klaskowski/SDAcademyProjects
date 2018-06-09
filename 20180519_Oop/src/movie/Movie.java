package movie;

public class Movie implements Comparable<Movie> {
    public String name;
    public Integer year;
    public Double rating;

    public Movie(String name, Integer year, Double rating) {
        this.name = name;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "movie.Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int compareTo(Movie o) {
        if (this == o) {
            return 0;
        }
        if (this.rating == o.rating) {
            return 0;
        } else if (this.rating < o.rating) {
            return -1;
        } else {
            return 1;
        }
    }
}
