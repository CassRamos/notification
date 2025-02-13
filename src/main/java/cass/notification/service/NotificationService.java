package cass.notification.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final AmazonSNS amazonSNS;

    public NotificationService(AmazonSNS amazonSNS) {
        this.amazonSNS = amazonSNS;
    }

    public void notifyUser(String phoneNumber, String message) {
        PublishRequest publishRequest = new PublishRequest()
                .withMessage(message)
                .withPhoneNumber(phoneNumber);
        amazonSNS.publish(publishRequest);
    }
}
