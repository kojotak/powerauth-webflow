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
import React from 'react';
import Select from 'react-select';

/**
 * Select UI component for bank account choice.
 */
export default class BankAccountSelect extends React.Component {

    constructor() {
        super();
        this.onChange = this.onChange.bind(this);
    }

    onChange(value) {
        this.props.callback(value);
    }

    render () {
        return (
            <div className="section">
                <Select
                    optionComponent={BankAccountOption}
                    options={this.props.bankAccounts}
                    value={this.props.chosenBankAccount}
                    valueComponent={BankAccountValue}
                    disabled={this.props.choiceDisabled}
                    clearable={false}
                    searchable={false}
                    autoFocus={true}
                    onChange={this.onChange}
                />
            </div>
        )
    }
}

class BankAccountOption extends React.Component {

    constructor() {
        super();
        this.handleMouseMove = this.handleMouseMove.bind(this);
        this.handleMouseDown = this.handleMouseDown.bind(this);
        this.handleMouseEnter = this.handleMouseEnter.bind(this);
    }

    handleMouseDown(event) {
        event.preventDefault();
        event.stopPropagation();
        this.props.onSelect(this.props.option, event);
    }

    handleMouseEnter(event) {
        this.props.onFocus(this.props.option, event);
    }

    handleMouseMove(event) {
        if (this.props.isFocused) return;
        this.props.onFocus(this.props.option, event);
    }
    render () {
        const bankAccount = this.props.option;
        return (
            <div className={this.props.className}
                 onMouseMove={this.handleMouseMove}
                 onMouseDown={this.handleMouseDown}
                 onMouseEnter={this.handleMouseEnter}>
                {formatBankAccount(bankAccount)}
            </div>
        );
    }
}

class BankAccountValue extends React.Component {
    render () {
        const bankAccount = this.props.value;
        return (
            <div className="Select-value">
                <div className="Select-value-label">
                    {formatBankAccount(bankAccount)}
                </div>
            </div>
        );
    }
}

function formatBankAccount(bankAccount) {
    return (
        <div>
            <table width="100%">
                <tbody>
                <tr>
                    <td width="50%" className="key">{bankAccount.name}</td>
                    <td width="50%" className="tint text-right">
                        {bankAccount.balance} {bankAccount.currency}
                    </td>
                </tr>
                <tr>
                    <td width="50%" className="message-information">{bankAccount.number}</td>
                    <td width="50%">
                        {(!bankAccount.usableForPayment && bankAccount.unusableForPaymentReason) ? (
                            <div className="message-error font-tiny text-right">
                                {bankAccount.unusableForPaymentReason}
                            </div>
                        ) : (undefined)}
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    )
}