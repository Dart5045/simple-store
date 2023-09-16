package com.inditex.domain.valueobject;

import java.util.UUID;

public class ApplicationId extends BaseId<UUID> {
    public ApplicationId(UUID value) {
        super(value);
    }
}
