package in.ac.iitdh.EmailGroups;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

/**
 * Email Groups.
 */
final class Main {

  private Main() {
  }

  /**
   * Email Groups MAIN class.
   *
   * @param args Arguments.
   * @throws IOException    IOException.
   * @throws ParseException ParseException.
   */
  public static void main(final String[] args)
          throws IOException, ParseException {
    EmailGroups emailGroups = new EmailGroups(
            "/home/ashish/Courses/cs305/EmailGroups/Emails.csv",
            "/home/ashish/Courses/cs305/EmailGroups/Keywords.csv",
            "/home/ashish/Courses/cs305/EmailGroups/Persons.csv");
    List<EmailInventory> persons = emailGroups.getEmails();

    for (EmailInventory strings : persons) {
      System.out.printf("%-30s %10s %30s \n",
              strings.getEmailID(),
              Arrays.toString(strings.getReceiverID()),
              strings.getDate());
    }
  }
}
