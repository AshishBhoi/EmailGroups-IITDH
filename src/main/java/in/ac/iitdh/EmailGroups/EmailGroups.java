package in.ac.iitdh.EmailGroups;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    this.emailGroups = groupEmails();
  }

  private List<List<String>> groupEmails() {
    List<List<String[]>> list = mergeOne();
    List<List<String>> emailGroups1 = new ArrayList<>();
    for (List<String[]> strings1 : list) {
      List<String> emailGroup = new ArrayList<>();
      for (String[] strings2 : strings1) {
        final int check  = 5;
        if (Integer.parseInt(strings2[2]) >= check) {
          emailGroup.add(strings2[0]);
          emailGroup.add(strings2[1]);
        }
      }
      emailGroups1.add(emailGroup.stream().distinct()
              .collect(Collectors.toList()));
    }
    return  emailGroups1.stream().distinct().collect(Collectors.toList());
  }

  private List<List<String[]>> mergeOne() {
    List<List<String[]>> list = emailGroups();
    List<List<String[]>> newList = new ArrayList<>();
    for (List<String[]> strings : list) {
      List<String[]> newLists = new ArrayList<>();
      List<String[]> newLists2 = new ArrayList<>();
      if (strings.size() != 0) {
        for (String[] string : strings) {
          boolean check = false;
          if (newLists.size() == 0) {
            String[] addNew = {string[0], string[1], "1"};
            newLists.add(addNew);
            newLists2.add(addNew);
          }
          int i = 0;
          for (String[] newLists1 : newLists) {
            if (newLists1[0].equals(string[0])
                    && newLists1[1].equals(string[1])) {
              int count = Integer.parseInt(newLists2.get(i)[2]) + 1;
              String[] str = {string[0], string[1], String.valueOf(count)};
              newLists2.set(i, str);
              check = true;
            } else if (newLists1[0].equals(string[1])
                    && newLists1[1].equals(string[0])) {
              int count = Integer.parseInt(newLists2.get(i)[2]) + 1;
              String[] str = {string[0], string[1], String.valueOf(count)};
              newLists2.set(i, str);
              check = true;
            }
            i++;
          }
          if (!check) {
            String[] addNew = {string[0], string[1], "1"};
            newLists.add(addNew);
            newLists2.add(addNew);
          }
        }
      }
      newList.add(newLists2);
    }
    return newList;
  }

  private List<List<String[]>> emailGroups() {
    List<List<String[]>> list = new ArrayList<>(keywords.size());
    for (String keyword : keywords) {
      List<String[]> string = new ArrayList<>();
      for (TransactionInventory emailTransaction : emailTransactions) {
        for (int i = 0; i < emailTransaction.getKeywords().length; i++) {
          if (keyword.equals(emailTransaction.getKeywords()[i])) {
            String[] str = {emailTransaction.getSenderID(),
                    emailTransaction.getReceiverID()};
            string.add(str);
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
      if (emailGroup.size() != 0) {
        System.out.print("[\t");
        for (String emailGroup1 : emailGroup) {
          System.out.print(emailGroup1 + "\t");
        }
        System.out.print("]");
        System.out.println();
      }
    }
  }
}
