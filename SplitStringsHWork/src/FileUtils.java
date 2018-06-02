import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileUtils {

    Movie[] movieList = new Movie[3];
    int moviesAdded = 0;


    public void readFile1() {

        try {
            FileReader fileReader = new FileReader("C:\\Users\\jitar\\ProjectsSDAcad\\SplitStringsHWork\\src\\input1.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                String name = bufferedReader.readLine();
                Integer year = Integer.valueOf(bufferedReader.readLine());
                Double rating = Double.valueOf(bufferedReader.readLine());
                Movie movie = new Movie(name, year, rating);
                addMovieToList(movie);
            }
        } catch (IOException e) {
            System.out.println("File could not be read!!");
        }
    }

    public void readFile2() {
        try {
            FileReader fileReader = new FileReader("C:\\Users\\jitar\\ProjectsSDAcad\\SplitStringsHWork\\src\\input2.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                String fullLine = bufferedReader.readLine();
                String[] temp = fullLine.split(", ", 3);
                String name = temp[0];
                Integer year = Integer.valueOf(temp[1]);
                Double rating = Double.valueOf(temp[2]);
                Movie movie = new Movie(name, year, rating);
                addMovieToList(movie);
            }

        } catch (IOException e) {
            System.out.println("File could not be read!!!");
        }
    }

    public void addMovieToList(Movie movie) {
        if (moviesAdded <= movieList.length) {
            movieList[moviesAdded] = movie;
            moviesAdded++;
        } else {
            movieList = Arrays.copyOf(movieList, movieList.length * 2);
            movieList[moviesAdded] = movie;
            moviesAdded++;
        }
    }

    public void displayMovieList() {
        for (Movie iterator : movieList) {
            System.out.println(iterator);
        }
    }

}
