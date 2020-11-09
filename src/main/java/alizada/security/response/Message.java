package alizada.security.response;

public class Message {

    private String messageDetail;

    public Message(String messageDetail) {
        this.messageDetail = messageDetail;
    }

    public String getMessageDetail() {
        return messageDetail;
    }

    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageDetail='" + messageDetail + '\'' +
                '}';
    }
}
