package org.github.me2nardo.consumer.service;

import ca.radiant3.redisq.Message;
import ca.radiant3.redisq.consumer.MessageListener;
import ca.radiant3.redisq.consumer.retry.RetryableMessageException;
import org.github.me2nardo.core.model.Campaign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by leo on 20.12.16.
 */
public class CampaignListener implements MessageListener<Campaign> {

    private final Logger LOG = LoggerFactory.getLogger(CampaignListener.class);

    @Override
    public void onMessage(Message<Campaign> message) throws RetryableMessageException {
        LOG.info("Start receive campaign:"+message.getId());
        Campaign campaign = message.getPayload();
        LOG.info("Campaign:"+campaign.toString());
    }
}
