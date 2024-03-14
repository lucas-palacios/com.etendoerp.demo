package com.etendoerp.demo.event;

import javax.enterprise.event.Observes;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.model.common.invoice.Invoice;

class EventTest extends EntityPersistenceEventObserver {

    private static Entity[] entities = {
            ModelProvider.getInstance().getEntity(Invoice.ENTITY_NAME) };

    @Override
    protected Entity[] getObservedEntities() {
        return entities;
    }

    public void onSave(@Observes EntityNewEvent event) {
        if (!isValidEvent(event)) {
            return;
        }

        boolean test = true;

        if(test){
            throw new OBException("HOLA");
        }

    }
}
