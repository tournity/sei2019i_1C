package com.tournity.Data.API.Enums.APIErrors;

public enum GuardErrors implements APIError {
    INCORRECT_EMAIL,
    INCORRECT_PASSWORD,
    TOKEN_UNAUTORIZED;

    @Override
    public int getErrorCode() {
        return 0;
    }
}
