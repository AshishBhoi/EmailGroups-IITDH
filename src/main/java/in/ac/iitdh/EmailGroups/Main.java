package in.ac.iitdh.EmailGroups;

import java.io.IOException;
import java.text.ParseException;

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
            args[0],
            args[1],
            args[2]);

    emailGroups.printEmailTransactions();
  }
}
