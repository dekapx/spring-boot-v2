package com.dimensiondata.cloud.preference.repository;

import com.dimensiondata.cloud.preference.domain.UserPreference;

import java.util.Map;

public interface PreferenceRepository {
    void save(final UserPreference preference);

    void update(final UserPreference preference);

    UserPreference find(final String id);

    Map<Object, UserPreference> findAll();

    void delete(final String id);
}
