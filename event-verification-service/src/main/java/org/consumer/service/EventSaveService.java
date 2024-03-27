package org.consumer.service;

import org.consumer.configuration.exceptions.BusinessLogicException;
import org.consumer.dto.EventReceivedDto;
import org.consumer.entity.Event;
import org.consumer.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventSaveService {

    private final EventRepository eventRepository;

    @Autowired
    public EventSaveService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Transactional(label = "event save",
            propagation = Propagation.REQUIRED,
            isolation = Isolation.REPEATABLE_READ,
            rollbackFor = BusinessLogicException.class,
            timeout = 3)
    public void saveEvent(EventReceivedDto event) throws BusinessLogicException {

        eventRepository.saveAndFlush(new Event(event));

        if(event.getIsTransactionalFailing()){
            throw new BusinessLogicException();
        }
    }
}
