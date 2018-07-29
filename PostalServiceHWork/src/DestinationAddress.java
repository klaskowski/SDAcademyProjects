import java.io.*;

public class DestinationAddress {

    String postcode;
    String city;
    String streetName;
    Integer houseNo;
    Exception invalidAddressException = new InvalidAddressException();


    public void readAddress() {
        String[] temp = null;
        String output = new String();
        try {
            FileReader fileReader = new FileReader("C:\\Users\\jitar\\ProjectsSDAcad\\PostalServiceHWork\\src\\destination.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                String wholeLine = bufferedReader.readLine();
                temp = wholeLine.split(",");
                postcode = temp[0];
                houseNo = Integer.valueOf(temp[3]);
                //System.out.println(addressCounter + ". " + postcode + ", street: " + streetName + ", City: " + city + ", no: " + houseNo);
                completeAddress(postcode, houseNo, temp);
                output = output.concat(postcode + ": " + temp[2] + ", " + temp[1] + " " + houseNo + "\n");
                writeFile(output);
                System.out.println(postcode + ", street: " + temp[2] + ", City: " + temp[1] + ", no: " + houseNo);
            }
        } catch (IOException e) {
            System.out.println("File could not be read!");
        }
    }

    private void completeAddress(String code, Integer houseNumber, String[] array) throws InvalidAddressException{
        for (String key : PostCodes.POST_CODES.keySet()) {

            if (code.equals(key)) {
                PostAreaCode searchedKey = PostCodes.POST_CODES.get(key);
                if (houseNumber >= searchedKey.minHouseNo || houseNumber <= searchedKey.maxHouseNo) {
                    array[1] = searchedKey.city;
                    array[2] = searchedKey.streetName;
                } else {
                    throw new InvalidAddressException();
                }
            } else {
                throw new InvalidAddressException();
            }

        }
    }

    public void writeFile(String output) {
        try {
            FileWriter fileWriter = new FileWriter("destinationOutput.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(output);
            bufferedWriter.flush();
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Cannot write to file!!");
        }
    }

}
