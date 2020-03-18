package in.ac.iitdh.EmailGroups;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadCSV implements IEmailGroups {
  /**
   * Reading Persons.csv file and putting it into a list.
   * @param fileName Name of the csv file.
   * @return returns a list of array containing all persons details.
   * @throws IOException Throws io exception.
   */
  @Override
  public List<String[]> readPerson(final String fileName) throws IOException {
    List<String[]> content = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = br.readLine()) != null) {
        content.add(line.split(","));
      }
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
    return content;
  }

  /**
   * Reading Keywords.csv file and putting it into a list.
   * @param fileName Name of the csv file.
   * @return returns a list of array containing all keywords.
   * @throws IOException Throws io exception.
   */
  @Override
  public List<String> readKeyWord(final String fileName) throws IOException {
    List<String> content = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = br.readLine()) != null) {
        content.add(line);
      }
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
    return content;
  }
}
