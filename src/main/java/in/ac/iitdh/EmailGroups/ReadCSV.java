package in.ac.iitdh.EmailGroups;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ReadCSV implements IEmailGroups {
  /**
   * Reading Persons.csv file and putting it into a list.
   *
   * @param fileName Name of the csv file.
   * @return returns a list of array containing all persons details.
   * @throws IOException Throws io exception.
   */
  @Override
  public List<String[]> readPersons(final String fileName) throws IOException {

    return readCSVFile(fileName);
  }

  /**
   * Reading Keywords.csv file and putting it into a list.
   *
   * @param fileName Name of the csv file.
   * @return returns a list of array containing all keywords.
   * @throws IOException Throws io exception.
   */
  @Override
  public List<String> readKeyWords(final String fileName) throws IOException {
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

  /**
   * Reading Emails.csv file and putting it into a inventory list.
   *
   * @param fileName Name of the csv file.
   * @return returns a inventory list containing all email details.
   * @throws IOException Throws io exception.
   */
  @Override
  public List<EmailInventory> readEmails(final String fileName)
          throws IOException, ParseException {
    List<String[]> content = readCSVFile(fileName);
    List<EmailInventory> emailInventoryList = new ArrayList<>();
    for (int i = 1; i < content.size(); i++) {
      final int email = 0;
      final int sender = 1;
      final int receiver = 2;
      final int date2 = 3;
      final int keyword1 = 4;
      final int reply1 = 5;
      String emailID = content.get(i)[email];
      String senderID = content.get(i)[sender];
      String receiverIDs = content.get(i)[receiver];
      String[] receiverID = receiverIDs.split(" ");
      String date1 = content.get(i)[date2];
      Date date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(date1);
      String keyword = content.get(i)[keyword1];
      String[] keywords = keyword.split(" ");
      String reply = content.get(i)[reply1];
      emailInventoryList.add(new EmailInventory(emailID,
              senderID,
              receiverID,
              date,
              keywords,
              reply));
    }
    return emailInventoryList;
  }

  private List<String[]> readCSVFile(final String fileName) throws IOException {
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
}
