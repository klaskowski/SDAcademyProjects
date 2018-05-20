import comparators.MovieNameComparators;
import comparators.MovieRatingComparators;
import movie.Movie;
import movie.MovieYearComparators;

import java.util.*;

public class CollectionsTests {
    public static void printCollection(Collection<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
        System.out.println("size: " + movies.size());
    }

    public static void removeMoviesAfter2000(Collection<Movie> movies){
        Iterator iterator = movies.iterator();

        while(iterator.hasNext()){
            Movie movie = (Movie)iterator.next();
            if(movie.year >= 2000){
                System.out.println(movie + "will be removed");
                iterator.remove();
            }
        }
    }

    public static void testCollections() {
        Movie m1 = new Movie("Star Wars", 1977, 9.00);
        Movie m2 = new Movie("LOTR", 1990, 9.00);
        Movie m3 = new Movie("Blade Runner 2049", 2018, 9.00);
        Movie m4 = new Movie("Silence of The lambs", 1992, 10.00);
        Movie m5 = new Movie("Seven", 1984, 10.00);
        Movie m6 = new Movie("2001:A Space Odyssey", 1967, 9.50);

        Collection<Movie> myMovies1 = new ArrayList<Movie>(3);
        myMovies1.add(m1);
        myMovies1.add(m2);
        myMovies1.add(m3);
        myMovies1.add(m4);
        printCollection(myMovies1);

        System.out.println("********sort list*************");


        ArrayList<Movie> myMovies2 = new ArrayList<>();
        myMovies2.add(myMovies2.size(), m1);
        myMovies2.addAll(myMovies1);
        myMovies2.set(1, m5);
        printCollection(myMovies2);
        System.out.println("----------------");
        System.out.println(myMovies2.get(2));
        myMovies2.retainAll(myMovies1);
        printCollection(myMovies2);
        myMovies2.removeAll(myMovies1);
        printCollection(myMovies2);

        System.out.println("**************List 3*****************");

        LinkedList<Movie> myMovies3 = new LinkedList<>();
        myMovies3.addAll(myMovies1);
        myMovies3.addAll(myMovies2);
        myMovies3.add(m6);
        //removeMoviesAfter2000(myMovies3);
        System.out.println(myMovies3);

        System.out.println("-------Removing movies after 2000---------");

        removeMoviesAfter2000(myMovies1);
        System.out.println(myMovies1);

        System.out.println("-------compareTo---------");
        System.out.println("comparing " + m1 + " to "+ m2);
        System.out.println(m1.compareTo(m2));

        System.out.println("Collections.sort default");
        Collections.sort(myMovies3);
        printCollection(myMovies3);

        System.out.println("Collections.sort by name");
        Collections.sort(myMovies3, new MovieNameComparators());
        printCollection(myMovies3);

        System.out.println("Collections.sort by year");
        Collections.sort(myMovies3, new MovieYearComparators());
        printCollection(myMovies3);

        System.out.println("Collections.sort by rating");
        Collections.sort(myMovies3, new MovieRatingComparators());
        printCollection(myMovies3);

        System.out.println("-------sets with natural order---------");

        Set<Movie> movieTreeSet = new TreeSet<>();
        movieTreeSet.add(m6);
        movieTreeSet.add(m3);
        movieTreeSet.add(m4);
        movieTreeSet.add(m5);
        movieTreeSet.add(m5);
        printCollection(movieTreeSet);

        System.out.println("-------sets with custom (year) order---------");

        Set<Movie> movieTreeSetCustomOrder = new TreeSet<>(new MovieYearComparators());
        movieTreeSetCustomOrder.add(m6);
        movieTreeSetCustomOrder.add(m3);
        movieTreeSetCustomOrder.add(m4);
        movieTreeSetCustomOrder.add(m5);
        movieTreeSetCustomOrder.add(m5);
        printCollection(movieTreeSetCustomOrder);

        System.out.println("************Maps**************");


        System.out.println("-------queue---------");

    }


}
