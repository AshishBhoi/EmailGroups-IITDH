package in.ac.iitdh.EmailGroups;

import java.util.Date;

public class EmailInventory {

  /**
   * Email ID of the email.
   */
  private String myEmailID;

  /**
   * Sender Email ID.
   */
  private String mySenderID;

  /**
   * All the receiver IDs.
   */
  private String[] myReceiverID;

  /**
   * Date the email sent.
   */
  private Date myDate;

  /**
   * All keywords present on the email.
   */
  private String[] myKeywords;

  /**
   * Previous email ID if it is a reply.
   */
  private String myReply;

  /**
   * Public Email Inventory.
   *
   * @param emailID    email id on the email.
   * @param senderID   sender email id.
   * @param receiverID receiver email id.
   * @param date       date of the email.
   * @param keywords   keywords on the email
   * @param reply      reply id if any.
   */
  public EmailInventory(final String emailID,
                        final String senderID,
                        final String[] receiverID,
                        final Date date,
                        final String[] keywords,
                        final String reply) {
    this.myEmailID = emailID;
    this.mySenderID = senderID;
    this.myReceiverID = receiverID;
    this.myDate = date;
    this.myKeywords = keywords;
    this.myReply = reply;
  }

  /**
   * return email id on the email.
   *
   * @return EmailID
   */
  public String getEmailID() {
    return myEmailID;
  }

  /**
   * Sender email ID.
   *
   * @return sender ID
   */
  public String getSenderID() {
    return mySenderID;
  }

  /**
   * Receiver ID.
   *
   * @return Receiver Email id.
   */
  public String[] getReceiverID() {
    return myReceiverID;
  }

  /**
   * Email date.
   *
   * @return date the email sent.
   */
  public Date getDate() {
    return myDate;
  }

  /**
   * Email keywords.
   *
   * @return return the keywords on email.
   */
  public String[] getKeywords() {
    return myKeywords;
  }

  /**
   * Reply id if any.
   *
   * @return reply email id.
   */
  public String getReply() {
    return myReply;
  }
}
