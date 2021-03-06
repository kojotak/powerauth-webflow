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
package io.getlime.security.powerauth.lib.nextstep.model.response;

import io.getlime.security.powerauth.lib.nextstep.model.entity.AuthStep;
import io.getlime.security.powerauth.lib.nextstep.model.enumeration.AuthResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Response object used for updating an operation.
 *
 * @author Petr Dvorak, petr@lime-company.eu
 */
public class UpdateOperationResponse {

    private String operationId;
    private String operationName;
    private String userId;
    private AuthResult result;
    private String resultDescription;
    private Date timestampCreated;
    private Date timestampExpires;
    private List<AuthStep> steps;

    /**
     * Default constructor.
     */
    public UpdateOperationResponse() {
        steps = new ArrayList<>();
    }

    /**
     * Get operation ID.
     * @return Operation ID.
     */
    public String getOperationId() {
        return operationId;
    }

    /**
     * Set operation ID.
     * @param operationId Operation ID.
     */
    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    /**
     * Get operation name.
     * @return Operation name.
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * Set operation name.
     * @param operationName Operation name.
     */
    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    /**
     * Get user ID of the user who is associated with the operation.
     * @return User ID.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Set user ID of the user who is associated with the operation.
     * @param userId User ID.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Get the authentication step result.
     * @return Authentication step result.
     */
    public AuthResult getResult() {
        return result;
    }

    /**
     * Set the authentication step result.
     * @param result Authentication step result.
     */
    public void setResult(AuthResult result) {
        this.result = result;
    }

    /**
     * Get the authentication result description.
     *
     * @return Result description.
     */
    public String getResultDescription() {
        return resultDescription;
    }

    /**
     * Set the authentication result description.
     *
     * @param resultDescription Result description.
     */
    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    /**
     * Get the timestamp of when the operation was created.
     * @return Timestamp when operation was created.
     */
    public Date getTimestampCreated() {
        return timestampCreated;
    }

    /**
     * Set the timestamp of when the operation was created.
     * @param timestampCreated Timestamp when operation was created.
     */
    public void setTimestampCreated(Date timestampCreated) {
        this.timestampCreated = timestampCreated;
    }

    /**
     * Get the timestamp of when the operation expires.
     * @return Timestamp when operation expires.
     */
    public Date getTimestampExpires() {
        return timestampExpires;
    }

    /**
     * Set the timestamp of when the operation expires.
     * @param timestampExpires Timestamp when operation expires.
     */
    public void setTimestampExpires(Date timestampExpires) {
        this.timestampExpires = timestampExpires;
    }

    /**
     * Is the operation expired?
     *
     * @return true if expired
     */
    public boolean isExpired() {
        return new Date().after(timestampExpires);
    }

    /**
     * Get the list with optional extra parameters.
     * @return Extra parameters.
     */
    public List<AuthStep> getSteps() {
        return steps;
    }

}
