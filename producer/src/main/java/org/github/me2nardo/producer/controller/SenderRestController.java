package org.github.me2nardo.producer.controller;

import ca.radiant3.redisq.producer.MessageProducer;
import org.github.me2nardo.core.model.Campaign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leo on 20.12.16.
 */
@RestController
public class SenderRestController {

    private final Logger LOG = LoggerFactory.getLogger(SenderRestController.class);

    @Autowired
    private MessageProducer messageProducer;

    @RequestMapping(value = "/send",method = RequestMethod.POST)
    public void performSend(@RequestBody Campaign campaign){
        LOG.info("Perform submit:"+campaign.toString());
        messageProducer.create(campaign).submit();
    }
}
