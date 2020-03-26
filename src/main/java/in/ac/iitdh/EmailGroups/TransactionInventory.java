package in.ac.iitdh.EmailGroups;

public class TransactionInventory {

  /**
   * Sender email id.
   */
  private String mySenderID;

  /**
   * Receiver email id.
   */
  private String myReceiverID;

  /**
   * Keywords associated with sender and receiver email id.
   */
  private String[] myKeywords;

  /**
   * Create inventory for transactions.
   * @param senderID Sender ID.
   * @param receiverID Receiver ID
   * @param keywords Keywords.
   */
  public TransactionInventory(final String senderID,
                              final String receiverID,
                              final String[] keywords) {
    this.mySenderID = senderID;
    this.myReceiverID = receiverID;
    this.myKeywords = keywords;
  }

  /**
   * Public function to get sender id.
   * @return Returns sender id.
   */
  public String getSenderID() {
    return mySenderID;
  }

  /**
   * Public function to get receiver id.
   * @return Returns receiver id.
   */
  public String getReceiverID() {
    return myReceiverID;
  }

  /**
   * Public function to get array of keywords.
   * @return Returns array of keywords.
   */
  public String[] getKeywords() {
    return myKeywords;
  }
}
