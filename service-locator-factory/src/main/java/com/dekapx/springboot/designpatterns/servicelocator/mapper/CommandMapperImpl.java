package com.dekapx.springboot.designpatterns.servicelocator.mapper;

import com.dekapx.springboot.designpatterns.servicelocator.command.CommandType;
import com.dekapx.springboot.designpatterns.servicelocator.command.delete.DeleteCommand;
import com.dekapx.springboot.designpatterns.servicelocator.command.save.SaveCommand;
import com.dekapx.springboot.designpatterns.servicelocator.command.update.UpdateCommand;
import org.springframework.stereotype.Component;

import static com.dekapx.springboot.designpatterns.servicelocator.command.CommandType.SAVE;
import static com.dekapx.springboot.designpatterns.servicelocator.command.CommandType.UPDATE;
import static com.dekapx.springboot.designpatterns.servicelocator.command.CommandType.DELETE;

import static java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CommandMapperImpl implements CommandMapper {
    private Map<CommandType, String> commandMapping = Stream.of(
            new SimpleImmutableEntry<>(SAVE, getType(SaveCommand.class)),
            new SimpleImmutableEntry<>(UPDATE, getType(UpdateCommand.class)),
            new SimpleImmutableEntry<>(DELETE, getType(DeleteCommand.class)))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private String getType(final Class clazz) {
        return clazz.getTypeName();
    }

    @Override
    public String getCommandType(final CommandType commandType) {
        return commandMapping.get(commandType);
    }
}
