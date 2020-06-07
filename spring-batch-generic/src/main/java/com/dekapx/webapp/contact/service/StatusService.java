package com.dekapx.webapp.contact.service;


import com.dekapx.webapp.contact.model.Status;

public interface StatusService {
    Status findByStatusKey(String statusKey);
}
