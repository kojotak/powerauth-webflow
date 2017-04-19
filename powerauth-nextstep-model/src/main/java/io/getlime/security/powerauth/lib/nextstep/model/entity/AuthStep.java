/*
 * Copyright 2017 Lime - HighTech Solutions s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.getlime.security.powerauth.lib.nextstep.model.entity;

import io.getlime.security.powerauth.lib.nextstep.model.enumeration.AuthMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing an authentication step. Authentication process consists of one or more
 * "steps", each representing a given authentication method.
 *
 * @author Petr Dvorak, petr@lime-company.eu
 */
public class AuthStep {

    private AuthMethod authMethod;
    private String description;
    private List<KeyValueParameter> params;

    /**
     * Default constructor.
     */
    public AuthStep() {
        params = new ArrayList<>();
    }

    /**
     * Get authentication method.
     * @return Authentication method.
     */
    public AuthMethod getAuthMethod() {
        return authMethod;
    }

    /**
     * Set authentication method.
     * @param authMethod Authentication method.
     */
    public void setAuthMethod(AuthMethod authMethod) {
        this.authMethod = authMethod;
    }

    /**
     * Get authentication step description.
     * @return Authentication step description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set authentication step description.
     * @param description Authentication step description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the list of extra parameters.
     * @return Extra parameters.
     */
    public List<KeyValueParameter> getParams() {
        return params;
    }

}
