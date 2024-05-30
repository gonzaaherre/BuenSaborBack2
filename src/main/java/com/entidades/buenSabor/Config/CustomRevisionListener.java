package com.entidades.buenSabor.Config;

import com.entidades.buenSabor.audit.Revision;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {
    public void newRevision(Object revisionEntity){
        final Revision revision=(Revision) revisionEntity;//transformamos el objeto en una revision


    }
}
