package in.ac.iitdh.EmailGroups;


import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface IEmailGroups {
  /**
   * Reading Persons.csv file and putting it into a list.
   *
   * @param fileName Name of the csv file.
   * @return returns a list of array containing all persons details.
   * @throws IOException Throws io exception.
   */
  List<String[]> readPersons(String fileName) throws IOException;

  /**
   * Reading Keywords.csv file and putting it into a list.
   *
   * @param fileName Name of the csv file.
   * @return returns a list of array containing all keywords.
   * @throws IOException Throws io exception.
   */
  List<String> readKeyWords(String fileName) throws IOException;

  /**
   * Reading Emails.csv file and putting it into a inventory list.
   *
   * @param fileName Name of the csv file.
   * @return returns a inventory list containing all email details.
   * @throws IOException Throws io exception.
   */
  List<EmailInventory> readEmails(String fileName) throws IOException,
          ParseException;
}
