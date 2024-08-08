package com.prosettings.prosettings.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "pName", types = {Player.class})
public interface PlayerProjection {
    public String getPlayerName();
}
