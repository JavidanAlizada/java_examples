package alizada.security.response;

import java.time.LocalDateTime;

public class Response<V> {
    private V value;
    private Message message;
    private Status status;
    private LocalDateTime createdOn;


    private Response(V value, Message message, Status status) {
        this.value = value;
        this.message = message;
        this.status = status;
        this.createdOn = LocalDateTime.now();
    }

    private Response(Message message, Status status) {
        this.message = message;
        this.status = status;
        this.createdOn = LocalDateTime.now();
    }

    public V getValue() {
        return value;
    }

    public Message getMessage() {
        return message;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    @Override
    public String toString() {
        return "Response{" +
                "value=" + value +
                ", message=" + message +
                ", status=" + status +
                ", createdOn=" + createdOn +
                '}';
    }

    public static <V> Response<V> response(V value, Message message, Status status) {
        return new Response<V>(value, message, status);
    }

    public static <V> Response<V> response(Message message, Status status) {
        return new Response<V>(message, status);
    }
}
