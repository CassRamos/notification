package cass.notification.domain;

public enum NotificationMessages {

    UNDER_REVIEW("Dear %s, your proposal has been received by our team and is under review. We will get back to you soon."),
    REJECTED("Dear %s, your proposal has been REJECTED. Our system detected the following reason: %s"),
    APPROVED("Dear %s, your proposal has been APPROVED. You will receive more information soon.");

    private final String message;

    NotificationMessages(String message) {
        this.message = message;
    }

    public String getFormattedMessage(String... parameters) {
        return String.format(message, (Object[]) parameters);
    }
}
