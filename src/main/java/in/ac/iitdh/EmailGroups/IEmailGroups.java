package in.ac.iitdh.EmailGroups;


import java.io.IOException;
import java.util.List;

public interface IEmailGroups {
  /**
   * Reading Persons.csv file and putting it into a list.
   * @param fileName Name of the csv file.
   * @return returns a list of array containing all persons details.
   * @throws IOException Throws io exception.
   */
  List<String[]> readPerson(String fileName) throws IOException;

  /**
   * Reading Keywords.csv file and putting it into a list.
   * @param fileName Name of the csv file.
   * @return returns a list of array containing all keywords.
   * @throws IOException Throws io exception.
   */
  List<String> readKeyWord(String fileName) throws IOException;
}
