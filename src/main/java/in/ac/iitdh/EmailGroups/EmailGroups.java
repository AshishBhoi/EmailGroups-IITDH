package in.ac.iitdh.EmailGroups;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

  /**
   * List of all email transactions.
   */
  private List<String[]> emailTransactions;

  EmailGroups(final String email, final String keyword, final String person)
          throws IOException, ParseException {
    ReadCSV readCSV = new ReadCSV();
    this.persons = readCSV.readPersons(person);
    this.keywords = readCSV.readKeyWords(keyword);
    this.emails = readCSV.readEmails(email);
    this.emailTransactions = emailTransactions();
  }

  private List<String[]> emailTransactions() {
    List<String[]> strings = new ArrayList<>();
    final int number = 3;
    final int day = 30;
    LocalDate date = LocalDate.now().minusDays(day);
    for (EmailInventory email : emails) {
      if (!email.getDate().before(Date.
              from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()))) {
        for (int j = 0; j < email.getReceiverID().length; j++) {
          String[] string = new String[number];
          string[0] = email.getSenderID();
          string[1] = email.getReceiverID()[j];
          string[2] = Arrays.toString(email.getKeywords());
          strings.add(string);
        }
        if (!email.getReply().equals("null")) {
          String[] string = new String[number];
          string[0] = email.getReply();
          string[1] = email.getEmailID();
          string[2] = Arrays.toString(email.getKeywords());
          strings.add(string);
        }
      }
    }
    return strings;
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
   * Print all persons and their details.
   */
  public void printPersons() {
    for (String[] person : persons) {
      System.out.printf("%-30s %10s %30s \n",
              person[0],
              person[1],
              person[2]);
    }
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
   * Print all keywords.
   */
  public void printKeywords() {
    for (String keyword : keywords) {
      System.out.printf("%s \n", keyword);
    }
  }

  /**
   * Public function to get all emails and their detail.
   *
   * @return List of emails with details.
   */
  public List<EmailInventory> getEmails() {
    return emails;
  }

  /**
   * Public function to get receiver sender and keywords.
   *
   * @return List of email groups.
   */
  public List<String[]> getEmailTransactions() {
    return emailTransactions;
  }

  /**
   * Print Email transactions.
   */
  public void printEmailTransactions() {
    for (String[] emailTransaction : emailTransactions) {
      System.out.printf("%-30s %10s %30s \n",
              emailTransaction[0],
              emailTransaction[1],
              emailTransaction[2]);
    }
  }
}
