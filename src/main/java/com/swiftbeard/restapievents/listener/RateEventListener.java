package com.swiftbeard.restapievents.listener;

import com.swiftbeard.restapievents.annotation.Log;
import com.swiftbeard.restapievents.event.CurrencyEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class RateEventListener {

    //@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    @TransactionalEventListener
    @Log(printParamsValues=true,callMethodWithNoParamsToString="getRate")
    public void processEvent(CurrencyEvent event){ }
}
