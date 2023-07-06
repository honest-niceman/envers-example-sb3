package com.jpabuddy.enversexamplesb3.envers;

import com.jpabuddy.enversexamplesb3.services.UserService;
import org.hibernate.envers.RevisionListener;

public class UserRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object revisionEntity) {
        AuditEnversInfo auditEnversInfo = (AuditEnversInfo) revisionEntity;
        auditEnversInfo.setUsername(UserService.getCurrentUsername());
    }
}
