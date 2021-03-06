/*
 * Copyright 2016 Lime - HighTech Solutions s.r.o.
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
import React from "react";
import {connect} from "react-redux";
// i18n
import {FormattedMessage} from "react-intl";

/**
 * Component showing successful authentication result with redirect to original application.
 */
@connect((store) => {
    return {
        context: store.dispatching.context
    }
})
export default class Success extends React.Component {

    componentWillMount() {
        setTimeout(() => {
            window.location = './authenticate/continue';
        }, 3000);
    }

    render() {
        return (
            <div className="panel panel-body text-center">
                <div className="message-success title">
                    {(this.props.context.message) ? (
                        <FormattedMessage id={this.props.context.message}/>
                    ) : (
                        <FormattedMessage id="error.unknown"/>
                    )}
                </div>
                <div className="image-result success"></div>
                <div className="message-information">
                    <FormattedMessage id="message.redirect"/>
                </div>
            </div>
        )
    }
}