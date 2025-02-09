package cass.notification.listener;

import cass.notification.domain.NotificationMessages;
import cass.notification.domain.Proposal;
import cass.notification.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PendingProposalListener {

    private final NotificationService notificationService;

    public PendingProposalListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "${rabbitmq.pending-proposal.notification-queue}")
    public void pendingProposal(Proposal proposal) {
        String message = NotificationMessages
                .UNDER_REVIEW
                .getFormattedMessage(proposal.getUser().getName());

        notificationService.notifyUser(proposal.getUser().getPhone(),message);
    }
}
