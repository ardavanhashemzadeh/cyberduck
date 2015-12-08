package ch.cyberduck.core.features;

/*
 * Copyright (c) 2013 David Kocher. All rights reserved.
 * http://cyberduck.ch/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to:
 * feedback@cyberduck.ch
 */

import ch.cyberduck.core.Credentials;
import ch.cyberduck.core.LoginCallback;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.VersioningConfiguration;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.ConnectionCanceledException;

import java.util.Map;

/**
 * @version $Id$
 */
public interface Versioning {

    public Versioning withCache(Map<Path, VersioningConfiguration> cache);

    VersioningConfiguration getConfiguration(Path container) throws BackgroundException;

    void setConfiguration(Path container, LoginCallback prompt, VersioningConfiguration configuration) throws BackgroundException;

    void revert(Path file) throws BackgroundException;

    Credentials getToken(LoginCallback controller) throws ConnectionCanceledException;
}