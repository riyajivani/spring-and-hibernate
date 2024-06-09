package org.example.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component   //this is used only if you are using AppConfig class....with spring-config.xml do not use annotation
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BtechStudent implements Student{
    @Override
    public String getCurrentStatus() {
        return this + "is studying in 6th semester";
    }
}
