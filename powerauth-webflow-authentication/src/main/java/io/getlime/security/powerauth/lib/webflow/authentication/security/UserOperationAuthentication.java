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

package io.getlime.security.powerauth.lib.webflow.authentication.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

/**
 * Object representing a user authentication.
 *
 * @author Petr Dvorak, petr@lime-company.eu
 */
public class UserOperationAuthentication extends AbstractAuthenticationToken implements Serializable {

    private static final long serialVersionUID = -3790516505615465445L;

    private String userId;
    private String operationId;
    private Boolean strongAuthentication;
    private String language;

    /**
     * Default constructor
     */
    public UserOperationAuthentication() {
        super(null);
        this.strongAuthentication = false;
        this.language = Locale.US.getLanguage();
    }

    /**
     * Constructor for a new UserOperationAuthentication
     *
     * @param operationId Operation ID
     * @param userId      User ID
     */
    public UserOperationAuthentication(String operationId, String userId) {
        super(null);
        this.operationId = operationId;
        this.userId = userId;
        this.strongAuthentication = false;
        this.language = Locale.US.getLanguage();
    }

    @Override
    public String getName() {
        return userId;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>(1);
        authorities.add(new SimpleGrantedAuthority("USER"));
        return Collections.unmodifiableList(authorities);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.userId + "." + this.operationId;
    }

    /**
     * Get user ID
     *
     * @return User ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Set user ID
     *
     * @param userId User ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Get operation ID.
     *
     * @return Operation ID.
     */
    public String getOperationId() {
        return operationId;
    }

    /**
     * Set operation ID.
     *
     * @param operationId Operation ID.
     */
    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    /**
     * Get information about the type of authentication (strong = more than one factor).
     * @return True of authentication is strong, false otherwise.
     */
    public Boolean isStrongAuthentication() {
        return strongAuthentication;
    }

    /**
     * Set information about the type of authentication (strong = more than one factor).
     * @param strongAuthentication True of authentication is strong, false otherwise.
     */
    public void setStrongAuthentication(Boolean strongAuthentication) {
        this.strongAuthentication = strongAuthentication;
    }

    /**
     * Get information about language that is set for the authentication.
     * @return Language information in ISO format.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Set information about language that is set for the authentication.
     * @param language Language information in ISO format.
     */
    public void setLanguage(String language) {
        this.language = language;
    }
}
