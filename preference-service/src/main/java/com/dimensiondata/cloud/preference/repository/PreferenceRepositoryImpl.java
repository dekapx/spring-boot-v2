package com.dimensiondata.cloud.preference.repository;

import com.dimensiondata.cloud.preference.domain.UserPreference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class PreferenceRepositoryImpl implements PreferenceRepository
{
    private static final Logger LOGGER = LoggerFactory.getLogger(PreferenceRepositoryImpl.class);

    private static final String KEY = "UserPreference";

    private HashOperations hashOperations;
    private RedisTemplate<String, UserPreference> redisTemplate;

    @PostConstruct
    private void init()
    {
        hashOperations = redisTemplate.opsForHash();
    }

    @Autowired
    public PreferenceRepositoryImpl(RedisTemplate<String, UserPreference> redisTemplate)
    {
        this.redisTemplate = redisTemplate;
    }

    public void save(final UserPreference preference)
    {
        hashOperations.put(KEY, String.valueOf(preference.getId()), preference);
        LOGGER.info("Preference persisted for ID {}", preference.getId());
    }

    public void update(final UserPreference preference)
    {
        hashOperations.put(KEY, String.valueOf(preference.getId()), preference);
        LOGGER.info("Preference updated for ID {}", preference.getId());
    }

    public UserPreference find(final String id)
    {
        final UserPreference preference = (UserPreference) hashOperations.get(KEY, id);
        LOGGER.info("preference found {} for ID {}", preference, id);
        return preference;
    }

    public Map<Object, UserPreference> findAll()
    {
        return hashOperations.entries(KEY);
    }

    public void delete(final String id)
    {
        hashOperations.delete(KEY, id);
        LOGGER.info("Preference deleted for ID {}", id);
    }
}
