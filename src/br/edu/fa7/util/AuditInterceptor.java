package br.edu.fa7.util;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Date;

public class AuditInterceptor extends EmptyInterceptor {

    private static final long serialVersionUID = 1016359394597759588L;

    public void onDelete(Object entity, Serializable id, Object[] state,
                         String[] propertyNames, Type[] types) {
        // do nothing
    }

    public boolean onFlushDirty(Object entity, Serializable id,
                                Object[] currentState, Object[] previousState,
                                String[] propertyNames, Type[] types) {

        for (int i = 0; i < propertyNames.length; i++) {
            if ("dataAlteracao".equals(propertyNames[i])) {
                currentState[i] = new Date();
                return true;
            }
        }
        return false;
    }

    public boolean onSave(Object entity, Serializable id, Object[] state,
                          String[] propertyNames, Type[] types) {

        boolean changedDate = Boolean.FALSE;
        boolean changedFlag = Boolean.FALSE;
        for (int i = 0; i < propertyNames.length; i++) {
            if ("dataRegistro".equals(propertyNames[i])) {
                state[i] = new Date();
                changedDate = Boolean.TRUE;
            } else if ("estaAtivo".equals(propertyNames[i])) {
                state[i] = Boolean.TRUE;
                changedFlag = Boolean.TRUE;
            }
        }
        if (changedDate && changedFlag) {
            return true;
        }
        return false;
    }


}
