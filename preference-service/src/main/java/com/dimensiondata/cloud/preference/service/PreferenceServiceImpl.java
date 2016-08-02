package com.dimensiondata.cloud.preference.service;

import com.dimensiondata.cloud.preference.domain.UserPreference;
import com.dimensiondata.cloud.preference.repository.PreferenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
@Service
public class PreferenceServiceImpl implements PreferenceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PreferenceServiceImpl.class);

    @Autowired
    private PreferenceRepository preferenceRepository;

    @Override
    public UserPreference find(final String id) {
        return preferenceRepository.find(id);
    }

    @Override
    public Map<Object, UserPreference> findAll() {
        return preferenceRepository.findAll();
    }

    @Override
    public void save(final UserPreference preference) {
        preferenceRepository.save(preference);
    }

    @Override
    public void update(final UserPreference preference) {
        preferenceRepository.update(preference);
    }

    @Override
    public void delete(final String id) {
        preferenceRepository.delete(id);
    }
}
