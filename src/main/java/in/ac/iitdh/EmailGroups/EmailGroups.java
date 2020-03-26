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
  private List<TransactionInventory> emailTransactions;

  /**
   * List of email groups.
   */
  private List<List<String>> emailGroups;

  EmailGroups(final String email, final String keyword, final String person)
          throws IOException, ParseException {
    ReadCSV readCSV = new ReadCSV();
    this.persons = readCSV.readPersons(person);
    this.keywords = readCSV.readKeyWords(keyword);
    this.emails = readCSV.readEmails(email);
    this.emailTransactions = emailTransactions();
    this.emailGroups = emailGroups();
  }

  private List<List<String>> emailGroups() {
    List<List<String>> list = new ArrayList<>(keywords.size());
    for (String keyword : keywords) {
      List<String> string = new ArrayList<>();
      for (TransactionInventory emailTransaction : emailTransactions) {
        for (int i = 0; i < emailTransaction.getKeywords().length; i++) {
          if (keyword.equals(emailTransaction.getKeywords()[i])) {
            string.add(emailTransaction.getSenderID());
            string.add(emailTransaction.getReceiverID());
          }
        }
      }
      list.add(string);
    }
    return list;
  }

  private List<TransactionInventory> emailTransactions() {
    List<TransactionInventory> strings = new ArrayList<>();
    final int day = 30;
    LocalDate date = LocalDate.now().minusDays(day);
    for (EmailInventory email : emails) {
      if (!email.getDate().before(Date.
              from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()))) {
        for (int j = 0; j < email.getReceiverID().length; j++) {
          String senderID = email.getSenderID();
          String receiverID = email.getReceiverID()[j];
          String[] keyword = email.getKeywords();
          strings.add(new TransactionInventory(senderID, receiverID, keyword));
        }
        if (!email.getReply().equals("null")) {
          String senderID = email.getReply();
          String receiverID = email.getEmailID();
          String[] keyword = email.getKeywords();
          strings.add(new TransactionInventory(senderID, receiverID, keyword));
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
  public List<TransactionInventory> getEmailTransactions() {
    return emailTransactions;
  }

  /**
   * Print Email transactions.
   */
  public void printEmailTransactions() {
    for (TransactionInventory emailTransaction : emailTransactions) {
      System.out.printf("%-30s %10s %30s \n",
              emailTransaction.getReceiverID(),
              emailTransaction.getSenderID(),
              Arrays.toString(emailTransaction.getKeywords()));
    }
  }

  /**
   * Public function to get email groups.
   *
   * @return Array list of email groups.
   */
  public List<List<String>> getEmailGroups() {
    return emailGroups;
  }

  /**
   * Function to print email groups.
   */
  public void printEmailGroups() {
    for (List<String> emailGroup : emailGroups) {
      System.out.println(emailGroup.toString());
    }
  }
}
