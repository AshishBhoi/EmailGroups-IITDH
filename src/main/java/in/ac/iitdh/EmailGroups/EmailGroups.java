package in.ac.iitdh.EmailGroups;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class EmailGroups {

  /**
   * List of persons and their details.
   */
  private List<String[]> persons;

  /**
   * list of keywords.
   */
  private List<String> keywords;

  /**
   * List of all emails and their details.
   */
  private List<EmailInventory> emails;

  EmailGroups(final String email, final String keyword, final String person)
          throws IOException, ParseException {
    ReadCSV readCSV = new ReadCSV();
    this.persons = readCSV.readPersons(person);
    this.keywords = readCSV.readKeyWords(keyword);
    this.emails = readCSV.readEmails(email);
  }

  /**
   * Public function to get details of all persons.
   *
   * @return List of persons and their details.
   */
  public List<String[]> getPersons() {
    return persons;
  }

  /**
   * Public function to get all keywords.
   *
   * @return List of keywords.
   */
  public List<String> getKeywords() {
    return keywords;
  }

  /**
   * Public function to get all emails and their detail.
   *
   * @return List of emails with details.
   */
  public List<EmailInventory> getEmails() {
    return emails;
  }
}
