package in.ac.iitdh.EmailGroups;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Email Groups.
 *
 * <p>
 * Groups of people who have strongly communicated
 * among themselves on a given keyword.
 * Such that the group should contain
 * persons who have sent at least
 * 5 emails on the topic and also replied to
 * 5 emails that she received on that topic
 * in the last one month.
 * </p>
 *
 * @author Ashish Kumar Bhoi
 * @version 1.0.0
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
    List<String[]> persons = emailGroups.getEmailTransactions();

    for (String[] strings : persons) {
      System.out.printf("%-30s %10s %30s \n",
              strings[0],
              strings[1],
              strings[2]);
    }
  }
}
